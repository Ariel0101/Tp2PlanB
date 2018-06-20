public class CartaExodia extends CartaMonstruo {

    CartaExodia(Monstruo m, int estrellas) {
        super(m, estrellas);
    }

    public void colocarse(Mano unaMano){
        unaMano.agregar(this);
        Efecto efectoArmarExodia = this.monstruo.efecto();
        efectoArmarExodia.activar(unaMano);

    }
}
