import Cartas.CartaMonstruo;

public interface Efecto {

    void activar(ListaMonstruos listaMonstruos);

    void activar(CartaMonstruo carta);

}
