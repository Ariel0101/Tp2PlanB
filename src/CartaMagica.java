class CartaMagica implements Carta {

    private Magia magia;
    private Boca boca;

    CartaMagica(Magia magia) {

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
