import java.util.Collection;

public class EfectoArmarExodia implements Efecto {

    public void activarEn(Carta monstruo) { }

    public void activarEn(Mano unaMano) {
        unaMano.armarExodia();
    }

    @Override
    public void activar(ListaMonstruos listaMonstruos) {

    }

}
