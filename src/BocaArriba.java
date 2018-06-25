public class BocaArriba implements Boca {

    public Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo) throws MonstruoNoPuedeAtacarError{
        return cartaAtacada.recibirAtaque(cartaAtacante, campoEnemigo);
    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacada, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError{
        Botin unBotin = monstruoAtacante.atacar(monstruoAtacado);
        unBotin = miCampo.activarTrampa(monstruoAtacante, monstruoAtacado, unBotin);
        return unBotin;
    }

    @Override
    public boolean estaBocaArriba() {
        return true;
    }

    @Override
    public boolean estaBocaAbajo() {
        return false;
    }

}

