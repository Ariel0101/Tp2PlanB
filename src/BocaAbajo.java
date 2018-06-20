public class BocaAbajo implements Boca {

    public Botin pelear(Monstruo monstruo, Monstruo monstruo1) {

        return new Botin();

    }

    public Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo){

        return new Botin();

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacada, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo){
        cartaAtacada.colocarBocaArriba();
        return monstruoAtacante.atacar(monstruoAtacado);
    }

    @Override
    public boolean estaBocaArriba() {
        return false;
    }
}
