public class MonstruoComeHombres extends CartaMonstruoDecorator {

    private final CartaMonstruo carta;

    public MonstruoComeHombres(CartaMonstruo m) {

        super(m);
        this.carta = m;

    }

    public void colocarEnPosAtaque(){

        this.carta.colocarEnPosAtaque();
        this.carta.activarEfecto();
    }

    private void activarEfectoEn(Carta m){

        Efecto efect = this.carta.efecto();
        efect.activarEn(m);

    }

    void colocarBocaArriba(Carta m){

        this.carta.colocarBocaArriba();
        this.activarEfectoEn(m);

    }


}