public class CartaMonstruoComeHombres extends CartaMonstruo {

    private CartaMonstruo cartaSeleccionada;
    private Efecto efecto;
    CartaMonstruoComeHombres(Monstruo monstruo, int estrellas, Efecto efecto) {
        super(monstruo, estrellas);
        this.cartaSeleccionada = new CartaMonstruo(new Monstruo(0,0),0);
        this.efecto = efecto;
    }


    public void colocarBocaAbajo(){

        this.boca = new BocaAbajoComeHombres();

    }

    public void colocarBocaArriba(){
        if (this.boca.estaBocaAbajo()){
            this.activarEfecto();
        }
        this.boca = new BocaArriba();
    }

    void activarEfecto(){
        this.efecto.activar(this.cartaSeleccionada);
    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError {
        this.seleccionar(cartaAtacante);
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }

    public void seleccionar(CartaMonstruo unaCarta) {
        this.cartaSeleccionada = unaCarta;
    }

}