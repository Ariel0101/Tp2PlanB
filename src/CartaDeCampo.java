public class CartaDeCampo implements Carta{

    private WasteLand magia;

    CartaDeCampo(WasteLand w) {

        this.magia = w;

    }


    public void colocarse(Campo c){

        c.colocarCarta(this);

    }

    public void colocarBocaAbajo() {

    }

    public void colocarBocaArriba() {

    }

    void activar() {

        this.magia.activar();

    }
}
