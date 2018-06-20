import java.awt.*;
import java.util.LinkedList;

class CartaMonstruo implements Carta {

    protected Monstruo monstruo;
    protected Boca boca;
    private int estrellas;

    CartaMonstruo(Monstruo monstruo, int estrellas){

        monstruo.setCarta(this);
        this.monstruo = monstruo;
        this.boca = new BocaNeutra();
        this.estrellas = estrellas;
    }

    void colocarEnPosAtaque() {

        this.monstruo.colocarEnPosAtaque();

    }

    void colocarEnPosDefensa() {

        this.monstruo.colocarEnPosDefensa();

    }

    public void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    public void colocarBocaArriba() {

        this.boca = new BocaArriba();

    }

    void activarEfecto(){

        this.monstruo.activarEfecto();
    }

    Botin atacar(CartaMonstruo cartaAtacada, Campo campoEnemigo) {

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


    void destruir(Cementerio c) {

        c.enviar(this);

    }

    public void colocarse(Mano unaMano) {
        unaMano.agregar(this);
    }

    public void colocarse(Campo c) {

        this.invocar(c);
        c.colocarCarta(this);

    }

    private void invocar(Campo miCampo) {

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
}
