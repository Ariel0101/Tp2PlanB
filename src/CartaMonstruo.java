class CartaMonstruo implements Carta{

    private Monstruo monstruo;
    private Boca boca;
    private int estrellas;

    CartaMonstruo(Monstruo m, int estrellas){

        m.setCarta(this);
        this.monstruo = m;
        this.boca = new BocaNeutra();
        this.estrellas = estrellas;

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

    Botin atacar(CartaMonstruo m) {

        return this.boca.pelear(this.monstruo, m.monstruo);

    }

    void destruir(Cementerio c) {

        c.enviar(this);

    }


    public void colocarse(Campo c) {

        this.invocar(c);
        c.colocarCarta(this);

    }

    private void invocar(Campo c) {

    }

}
