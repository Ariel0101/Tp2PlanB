package Modelo.CartasMonstruo;

import Modelo.Jugador.Mano;

public class CartaMonstruoExodia extends CartaMonstruo {

    public CartaMonstruoExodia(String nombre, Monstruo m, int estrellas) {

        super(nombre, m, estrellas);
    }

    public void colocarse(Mano unaMano){
        unaMano.agregar(this);
        unaMano.ganar();
    }
}
