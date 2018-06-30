import Excepciones.MonstruoNoPuedeAtacarError;

public interface Posicion {

    int obtenerPuntos(int danio, int defensa) throws MonstruoNoPuedeAtacarError;

    int danioDePersonaje(int dif);

    void matar(Monstruo enemigo, Botin b) throws MonstruoNoPuedeAtacarError;

    void atacar() throws MonstruoNoPuedeAtacarError;

    String enCaracteres();
}
