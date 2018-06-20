public class BocaAbajoComeHombres implements Boca {

    public Botin atacar(CartaMonstruo cartaMonstruo, CartaMonstruo cartaM, Campo campoEnemigo) {
        return new Botin();
    }

    public Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) {
        miCarta.colocarBocaArriba();
        miCarta.activarEfecto();
        return new Botin();
    }

    @Override
    public boolean estaBocaArriba() {
        return false;
    }
}
