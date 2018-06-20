import java.util.Collection;

public interface Efecto {

    void activar();

    void activarEn(Carta monstruo);

    void activarEn(Mano unaMano);

    void activar(Monstruo m);

    void activar(Collection<Monstruo> monstruos);

}
