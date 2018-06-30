package Modelo;

import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;

public interface Efecto {

    void activar(ListaMonstruos listaMonstruos);

    void activar(CartaMonstruo carta);

}
