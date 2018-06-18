public interface Posicion {

    int obtenerPuntos(int danio, int defensa);

    int danioDePersonaje(int dif);

    void matar(Monstruo enemigo, Botin b);

    void atacar();
}
