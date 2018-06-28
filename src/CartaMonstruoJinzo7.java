import Excepciones.NoSePuedeAtacarAJugadorError;

public class CartaMonstruoJinzo7 extends CartaMonstruo {
    CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }


    Botin atacar(Atacable jugadorAtacado, Campo campoEnemigo) {
        try {
            return super.atacar(jugadorAtacado, campoEnemigo);
        } catch (NoSePuedeAtacarAJugadorError e) {
            Botin botin = new Botin();
            botin.setDanioAtacado(this.conCuantosPuntosAtaca());
            botin.atacarJugador((Jugador) jugadorAtacado);
            return botin;
        }
    }
}
