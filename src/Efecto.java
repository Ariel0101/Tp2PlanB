import java.util.Collection;

public interface Efecto {

    void activarEn(Mano unaMano);

    void activar(ListaMonstruos listaMonstruos);

    default void activar() {

    }

    default void activarEn(CartaMonstruo carta){

    }
}
