public class CartaMonstruoExodia extends CartaMonstruo {

    CartaMonstruoExodia(Monstruo m, int estrellas) {
        super(m, estrellas);
    }

    public void colocarse(Mano unaMano){
        unaMano.agregar(this);
        unaMano.ganar();
    }
}
