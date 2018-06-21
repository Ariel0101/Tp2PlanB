public class CartaTrampa implements Carta {
    private final Trampa trampa;
    private Boca boca;

    CartaTrampa(Trampa trampa) {
        this.trampa = trampa;
        this.boca = new BocaNeutra();
    }


    public void colocarse(Mano unaMano) {
        unaMano.agregar(this);
    }

    public void colocarse(Campo unCampo) {
        unCampo.colocarCarta(this);
    }

    public void colocarBocaAbajo() {
        this.boca = new BocaAbajo();
    }

    public void colocarBocaArriba() {
        this.boca = new BocaArriba();
    }

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError {
        this.colocarBocaArriba();
        return this.trampa.activar(monstruoAtacante, monstruoAtacado, unBotin);
    }
}
