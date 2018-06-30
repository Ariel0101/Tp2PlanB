package Modelo.CartasMonstruo;

import Modelo.Jugador.Mano;

public class CartaMonstruoExodia extends CartaMonstruo {

    public CartaMonstruoExodia(Monstruo m, int estrellas) {
        super(m, estrellas);
    }

    public void colocarse(Mano unaMano){
        unaMano.agregar(this);
        unaMano.ganar();
    }
}
