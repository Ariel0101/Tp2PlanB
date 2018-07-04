package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;
import Modelo.Combate.Botin;
import Modelo.Jugador.Jugador;

public class CartaMonstruoJinzo7 extends CartaMonstruo {
    public CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }


    public Botin atacar(Jugador jugadorAtacado, Campo campoEnemigo) {
        /*Botin botin = new Botin();
        botin.setDanioAtacado(this.conCuantosPuntosAtaca());
        botin.infligirDanioAtacado(jugadorAtacado);
        return new Botin();*/
        return jugadorAtacado.recibirAtaque(this, campoEnemigo);
    }
}
