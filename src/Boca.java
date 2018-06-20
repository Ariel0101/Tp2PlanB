public interface Boca {
    /*Botin pelear(Monstruo monstruo, Monstruo monstruo1);*/

    Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo);

    Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo);

    boolean estaBocaArriba();
}
