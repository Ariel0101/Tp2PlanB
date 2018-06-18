public class CartaMonstruoComeHombres implements Carta{

    private Monstruo monstruo;
    private Boca boca;

    CartaMonstruoComeHombres(Monstruo m) {

        this.monstruo = m;
        this.boca = new BocaNeutra();

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


}