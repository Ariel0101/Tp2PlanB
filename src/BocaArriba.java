public class BocaArriba implements Boca {

    public Botin pelear(Monstruo m1, Monstruo m2) {

        return m1.atacar(m2);

    }

    public Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo){
        return cartaAtacada.recibirAtaque(cartaAtacante, campoEnemigo);
    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacada, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo){
        Botin unBotin = monstruoAtacante.atacar(monstruoAtacado);
        unBotin = miCampo.activarTrampa(monstruoAtacante, monstruoAtacado, unBotin);
        return unBotin;
    }

    @Override
    public boolean estaBocaArriba() {
        return true;
    }
}

