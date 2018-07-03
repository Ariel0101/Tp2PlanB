package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.Carta;
import Modelo.Combate.Atacable;
import Modelo.Combate.Botin;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaAbajo;
import Modelo.Estados.BocaArriba;
import Modelo.Estados.BocaNeutra;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class CartaMonstruo implements Carta, Atacable {

    protected Monstruo monstruo;
    protected Boca boca;
    protected int estrellas;
    protected Invocacion invocacion;
    String nombre;

    public CartaMonstruo(Monstruo monstruo, int estrellas){

        monstruo.setCarta(this);
        this.monstruo = monstruo;
        this.boca = new BocaNeutra();
        this.estrellas = estrellas;
        this.invocacion = new InvocacionSacrificio(estrellas);
        this.nombre = "sin-nombre";
    }

    public void colocarEnPosAtaque() {

        this.monstruo.colocarEnPosAtaque();

    }

    public void colocarEnPosDefensa() {

        this.monstruo.colocarEnPosDefensa();

    }

    public void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    public void colocarBocaArriba() {

        this.boca = new BocaArriba();

    }

    public Botin atacar(CartaMonstruo cartaAtacada, Campo campoEnemigo) {

        return this.boca.atacar(this, cartaAtacada, campoEnemigo);

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) {
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }
    
    public void aumentarAtaque(int aumento) {
    	
    	this.monstruo.aumentarAtaque(aumento);
    }
    
    public void aumentarDefensa(int aumento) {
    	
    	this.monstruo.aumentarDefensa(aumento);
    }


    public void destruir(Cementerio c) {

        c.enviar(this);

    }

    public void colocarse(Mano unaMano) {
        unaMano.agregar(this);
    }

    public boolean estaBocaArriba() {

        return this.boca.estaBocaArriba();

    }

    public CartaMonstruo monstruoConMenorAtaque(CartaMonstruo otra) {

        Monstruo m = this.monstruo.MonstruoConMenorAtaqueQue(otra.monstruo);

        if (m == this.monstruo){

            return this;

        }

        return otra;


    }

    public void desactivarTemporales() {
        this.monstruo.desactivarTemporales();
    }

    public void colocarse(Campo miCampo) {

        invocacion.activar(miCampo);
        miCampo.agregarMonstruo(this);
    }

    public int conCuantosPuntosAtaca() {
        return monstruo.obtenerPuntos();
    }

    public void ponerNombre(String nombre){

        this.nombre = nombre;

    }

    @Override
    public String toString(){

        return this.boca.verNombre(this.nombre);

    }

    @Override
    public Image imagen() {
        String posicionEnCaracteres = this.monstruo.posicionEnCaracteres();
        if (posicionEnCaracteres == "Dormido"){
            posicionEnCaracteres = "Ataque";
        }

        return this.boca.imagen(this.nombre, " " + posicionEnCaracteres);
    }

}
