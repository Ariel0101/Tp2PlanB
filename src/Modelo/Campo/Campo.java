package Modelo.Campo;

import Controlador.Reiniciable;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMagiaTrampa.CartaTrampa;
import Modelo.CartasMagiaTrampa.TrampaNula;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Efecto;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Excepciones.NoHaySufucienteSacrificiosError;

import java.util.Iterator;
import java.util.LinkedList;

public class Campo implements Reiniciable {

    private LinkedList<CartaMagica> magicas;
    private LinkedList<CartaTrampa> trampas;
    private Cementerio cementerio;
    private CartaDeCampo cartaDeCampo;
    private Efecto efectoDeCampoPropio;
    private Efecto efectoDeCampoEnemigo;
    private ListaMonstruos listaMonstruos;

    public Campo(Cementerio cementerio){

        this.listaMonstruos = new ListaMonstruos();
        this.magicas = new LinkedList<>();
        this.trampas = new LinkedList<>();
        this.cementerio = cementerio;
        this.efectoDeCampoPropio = new EfectoNulo();
        this.efectoDeCampoEnemigo = new EfectoNulo();
        this.cartaDeCampo = new CartaDeCampoNula("CartaDeCampoNula",new EfectoDeCampoNulo(this, this)); //Le paso dos campos cualquiera

    }
    public void destruir(CartaMagica carta){
        this.cementerio.enviar(carta);
        this.magicas.remove(carta);
    }

    public void destruir (CartaTrampa carta){
        this.cementerio.enviar(carta);
        this.trampas.remove(carta);
    }

    public void destruir(CartaMonstruo unMonstruo) {

        this.cementerio.enviar(unMonstruo);
        listaMonstruos.eliminar(unMonstruo);
    }

    public void colocarCarta(CartaMonstruo monstruo){

        monstruo.colocarse(this);
    }

    public void colocarCarta(CartaMagica carta){

        this.magicas.add(carta);

    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        this.trampas.add(cartaTrampa);
    }

    public void colocarCarta(CartaDeCampo unaCartaDeCampo) {

        this.cartaDeCampo = unaCartaDeCampo;
        this.cartaDeCampo.activar();

    }

    public void desactivarTemporales(){
        Iterator<CartaMonstruo> iteradorMonstruos = this.listaMonstruos.iterator();
        while (iteradorMonstruos.hasNext()){
            CartaMonstruo monstruo = iteradorMonstruos.next();
            monstruo.desactivarTemporales();
        }
    }

    public void reiniciar(){
        this.desactivarTemporales();
    }

    public void agregarMonstruo(CartaMonstruo carta) {
    	efectoDeCampoPropio.activar(carta);
    	efectoDeCampoEnemigo.activar(carta);
        this.listaMonstruos.agregar(carta);
    }

    public boolean esta(CartaMonstruo unaCartaMonstruo) {
        return listaMonstruos.esta(unaCartaMonstruo);
    }

    public void aplicarEnMonstruos(Efecto efecto) {

        this.listaMonstruos.aplicar(efecto);

    }

	public void setEfectoDeCampoPropio(Efecto unEfectoDeCampo) {
		
		this.efectoDeCampoPropio = unEfectoDeCampo;
		this.aplicarEnMonstruos(unEfectoDeCampo);

	}

    public void setEfectoDeCampoEnemigo(Efecto unEfectoDeCampo) {

        this.efectoDeCampoEnemigo = unEfectoDeCampo;
        this.aplicarEnMonstruos(unEfectoDeCampo);

    }


    public Botin activarTrampa(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError {
        if (this.trampas.size() == 0){
            CartaTrampa unaCartaTrampa = new CartaTrampa("", new TrampaNula());
            return unaCartaTrampa.activar(monstruoAtacante, monstruoAtacado, unBotin);
        }
        CartaTrampa unaCartaTrampa = this.trampas.remove();
        this.cementerio.enviar(unaCartaTrampa);
        return unaCartaTrampa.activar(monstruoAtacante, monstruoAtacado, unBotin);

    }

	public void sacrificar(int cantidadASacrificar) {
        if (this.listaMonstruos.cantidad() < cantidadASacrificar){
            throw new NoHaySufucienteSacrificiosError();
        }

		for(int i = cantidadASacrificar; i>0; i--) {
			CartaMonstruo monstruoADestruir = listaMonstruos.monstruoConMenorAtaque();
			this.destruir(monstruoADestruir);
		}
	}

	public void fusionar(CartaMonstruo cartaMonstruoAFusionar, int cantidadAFusionar) {
		
		LinkedList<CartaMonstruo> listaObtenida = listaMonstruos.obtenerTodas(cartaMonstruoAFusionar);
		if (listaObtenida.size() < cantidadAFusionar) {
            throw new NoHaySufucienteSacrificiosError();
        }

        for (int i = cantidadAFusionar; i>0; i--) {
            this.destruir(listaObtenida.removeFirst());
        }

	}

    public LinkedList<CartaMagica> magicas(){

        return this.magicas;
    }

    public LinkedList<CartaTrampa> trampas() {

        return this.trampas;
    }

    public ListaMonstruos listaMonstruos(){

        return this.listaMonstruos;
    }

    public CartaDeCampo cartaDeCampo() {

        return this.cartaDeCampo;
    }
}
