public class CartaMonstruoJinzo7 extends CartaMonstruo {
    CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }

    public void atacar(Jugador jugadorAtacado) {
        int danio = this.monstruo.obtenerPuntosDeAtaque();
        jugadorAtacado.restarVida(danio);
    }
}
