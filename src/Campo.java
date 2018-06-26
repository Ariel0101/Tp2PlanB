import java.util.LinkedList;

public class Campo {

    private LinkedList<CartaMagica> magicas;
    private LinkedList<CartaTrampa> trampas;
    private Cementerio cementerio;
    private CartaDeCampo cartaDeCampo;
    private Efecto efectoDeCampoPropio;
    private Efecto efectoDeCampoEnemigo;
    private ListaMonstruos listaMonstruos;

    Campo(Cementerio c){

        this.magicas = new LinkedList<>();
        this.trampas = new LinkedList<>();
        this.cementerio = c;
        this.efectoDeCampoPropio = new EfectoNulo();
        this.efectoDeCampoEnemigo = new EfectoNulo();
        this.listaMonstruos = new ListaMonstruos();

    }
    void destruir (CartaMagica carta){
        this.cementerio.enviar(carta);
        this.magicas.remove(carta);
    }

    void destruir (CartaTrampa carta){
        this.cementerio.enviar(carta);
        this.trampas.remove(carta);
    }

    void destruir(CartaMonstruo unMonstruo) {

        this.cementerio.enviar(unMonstruo);
        listaMonstruos.eliminar(unMonstruo);
    }

    void destruir(Carta unaCarta) {

        this.cementerio.enviar(unaCarta);
        this.magicas.remove(unaCarta);
        this.trampas.remove(unaCarta);
        this.listaMonstruos.eliminar((CartaMonstruo) unaCarta);

    }
    


    void colocarCarta(CartaMonstruo monstruo){
    	monstruo.colocarse(this);
    }

    void agregarMonstruo(CartaMonstruo carta) {
    	efectoDeCampoPropio.activar(carta);
    	efectoDeCampoEnemigo.activar(carta);
        this.listaMonstruos.agregar(carta);
    }
    
    void colocarCarta(CartaMagica carta){

        this.magicas.add(carta);

    }

    ListaMonstruos listaMonstruos(){

        return this.listaMonstruos;

    }

    void aplicarEnMonstruos(Efecto efecto){

        efecto.activar(this.listaMonstruos);

    }

	public void colocarCarta(CartaDeCampo unaCartaDeCampo) {
		
		this.cartaDeCampo = unaCartaDeCampo;
		cartaDeCampo.activar();
		
	}


	public void setEfectoDeCampoPropio(Efecto unEfectoDeCampo) {
		
		this.efectoDeCampoPropio = unEfectoDeCampo;
		this.aplicarEnMonstruos(unEfectoDeCampo);

	}

    public void setEfectoDeCampoEnemigo(Efecto unEfectoDeCampo) {

        this.efectoDeCampoEnemigo = unEfectoDeCampo;
        this.aplicarEnMonstruos(unEfectoDeCampo);

    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        this.trampas.add(cartaTrampa);
    }

    public Botin activarTrampa(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError {
        if (this.trampas.size() == 0){
            CartaTrampa unaCartaTrampa = new CartaTrampa(new TrampaNula());
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

    public boolean esta(CartaMonstruo unaCartaMonstruo) {
        return listaMonstruos.esta(unaCartaMonstruo);
    }

    LinkedList<CartaMagica> magicas(){
        return this.magicas;
    }
    LinkedList<CartaTrampa> trampas() { return this.trampas; }
}
