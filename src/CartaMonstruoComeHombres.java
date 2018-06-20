public class CartaMonstruoComeHombres extends CartaMonstruo {

    private CartaMonstruo cartaSeleccionada;

    CartaMonstruoComeHombres(Monstruo m, int e) {
        super(m,e);
        this.cartaSeleccionada = new CartaMonstruo(new Monstruo(0,0),0);
    }

    private void activarEfectoEn(CartaMonstruo m){

        Efecto efect = this.monstruo.efecto();
        efect.activarEn(m);

    }

    public void colocarBocaAbajo(){

        this.boca = new BocaAbajoComeHombres();
    }

    void activarEfecto(){

        Efecto efecto = this.monstruo.efecto();
        efecto.activarEn(this.cartaSeleccionada);

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) {
        this.seleccionar(cartaAtacante);
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }

    public void seleccionar(CartaMonstruo unaCarta) {
        this.cartaSeleccionada = unaCarta;
    }

}