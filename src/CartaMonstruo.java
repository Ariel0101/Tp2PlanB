class CartaMonstruo implements Carta{

    private Monstruo monstruo;
    private Boca boca;

    CartaMonstruo(Monstruo m) {

        this.monstruo = m;
        this.boca = new BocaNeutra();

    }

    void colocarEnPosAtaque() {

        this.monstruo.colocarEnPosAtaque();

    }

    void colocarEnPosDefensa() {

        this.monstruo.colocarEnPosDefensa();

    }

    void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    void colocarBocaArriba() {

        this.boca = new BocaArriba();

    }

    void activarEfecto(){

        this.monstruo.activarEfecto();
    }

    Efecto efecto(){

        return this.monstruo.efecto();

    }

    Botin atacar(CartaMonstruo m) {

        return this.monstruo.atacar(m.monstruo);

    }

    void destruir(Cementerio c) {

        c.enviar(this.monstruo);

    }
}
