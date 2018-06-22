public class CartaMonstruoExodia extends CartaMonstruo {

    private final Efecto efecto;

    CartaMonstruoExodia(Monstruo m, int estrellas, Efecto efecto) {
        super(m, estrellas);
        this.efecto = efecto;
    }

    public void colocarse(Mano unaMano){
        unaMano.agregar(this);

        this.efecto.activar(unaMano);

    }
}
