public class CartaMonstruoComeHombres implements Carta{

    private Monstruo monstruo;
    private Boca boca;
    private int estrellas;

    CartaMonstruoComeHombres(Monstruo m, int e) {

        this.monstruo = m;
        this.boca = new BocaNeutra();
        this.estrellas = e;

    }

    public void colocarEnPosAtaque(){

        this.monstruo.colocarEnPosAtaque();
        this.monstruo.activarEfecto();
    }

    private void activarEfectoEn(Carta m){

        Efecto efect = this.monstruo.efecto();
        efect.activarEn(m);

    }

    void colocarBocaArriba(Carta m){

        this.boca = new BocaArriba();
        this.activarEfectoEn(m);

    }

    public void colocarse(Campo c) {

    }
}