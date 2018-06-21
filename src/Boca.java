public interface Boca {

    Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo) throws MonstruoNoPuedeAtacarError;

    Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError;

    boolean estaBocaArriba();

    boolean estaBocaAbajo();


}
