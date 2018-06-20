class CartaMagica implements Carta {

    private Magica magia;
    private Boca boca;

    CartaMagica(Magica magia) {

        this.magia = magia;

    }

    public void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    public void colocarBocaArriba() {

        this.magia.activar();
        this.boca = new BocaArriba();

    }


    public void colocarse(Mano unaMano) {

        unaMano.agregar(this);

    }

    public void colocarse(Campo c) {

        c.colocarCarta(this);

    }
}
