class CartaMagica extends Carta{

    private Magica magia;
    private Boca boca;

    CartaMagica(Magica m) {

        this.magia = m;

    }

    void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    void colocarBocaArriba() {

        this.magia.activar();
        this.boca = new BocaArriba();

    }

    public void colocarse(Campo c) {

        c.colocarCarta(this);

    }
}
