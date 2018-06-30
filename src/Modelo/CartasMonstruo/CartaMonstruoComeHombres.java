package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;
import Modelo.Combate.Botin;
import Modelo.Efecto;
import Modelo.Estados.BocaAbajoComeHombres;
import Modelo.Estados.BocaArriba;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;

public class CartaMonstruoComeHombres extends CartaMonstruo {

    private final Campo campoEnemigo;
    private CartaMonstruo cartaSeleccionada;
    private Efecto efecto;
    public CartaMonstruoComeHombres(Monstruo monstruo, int estrellas, Campo campoEnemigo) {
        super(monstruo, estrellas);
        this.cartaSeleccionada = new NoCartaMonstruo(monstruo); //Le paso un monstruos cualquiera
        this.campoEnemigo = campoEnemigo;
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

    private void activarEfecto(){

        if (this.cartaSeleccionada.getClass() != NoCartaMonstruo.class){
            this.campoEnemigo.destruir(this.cartaSeleccionada);
        }
        this.cartaSeleccionada = new NoCartaMonstruo(this.monstruo); //Deselecciono la carta
    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError {
        this.seleccionar(cartaAtacante);
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }

    public void seleccionar(CartaMonstruo unaCarta) {
        this.cartaSeleccionada = unaCarta;
    }

}