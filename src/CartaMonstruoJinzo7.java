public class CartaMonstruoJinzo7 extends CartaMonstruo {
    CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }


    Botin atacar(Jugador jugadorAtacado, Campo campoEnemigo) {
        Botin botin = new Botin();
        botin.setDanioAtacado(this.conCuantosPuntosAtaca());
        botin.atacarJugador(jugadorAtacado);
        return botin;
    }
}
