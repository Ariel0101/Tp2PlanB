public class PosDormido implements Posicion {

    public int obtenerPuntos(int danio, int defensa) {

        throw new MonstruoNoPuedeAtacarError();

    }

    public int danioDePersonaje(int dif) {

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) {

        throw new MonstruoNoPuedeAtacarError();

    }

    public void atacar() {

        throw new MonstruoNoPuedeAtacarError();

    }

}
