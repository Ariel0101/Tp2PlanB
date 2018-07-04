package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;
import Modelo.Combate.Botin;
import Modelo.Jugador.Jugador;

public class CartaMonstruoJinzo7 extends CartaMonstruo {
    public CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }


    public Botin atacar(Jugador jugadorAtacado, Campo campoEnemigo) {
        return jugadorAtacado.recibirAtaque(this, campoEnemigo);
    }
}
