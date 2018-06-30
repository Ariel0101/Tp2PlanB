package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.Combate.Botin;
import Modelo.Excepciones.NoCartaMonstruoError;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class NoCartaMonstruo extends CartaMonstruo {


    public NoCartaMonstruo(Monstruo monstruo) {
        super(monstruo, 0);
    }

    public void colocarEnPosAtaque() {

        throw new NoCartaMonstruoError();

    }

    public void colocarEnPosDefensa() {

        throw new NoCartaMonstruoError();

    }

    public void colocarBocaAbajo() {

        throw new NoCartaMonstruoError();

    }

    public void colocarBocaArriba() {

        throw new NoCartaMonstruoError();

    }

    public Botin atacar(CartaMonstruo cartaAtacada, Campo campoEnemigo) {

        throw new NoCartaMonstruoError();

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) {

        throw new NoCartaMonstruoError();

    }

    public void aumentarAtaque(int aumento) {

        throw new NoCartaMonstruoError();
    }

    public void aumentarDefensa(int aumento) {

        throw new NoCartaMonstruoError();
    }


    public void destruir(Cementerio c) {

        throw new NoCartaMonstruoError();

    }

    public void colocarse(Mano unaMano) {

        throw new NoCartaMonstruoError();

    }

    public void colocarse(Campo c) {

        throw new NoCartaMonstruoError();

    }

    public boolean estaBocaArriba() {

        throw new NoCartaMonstruoError();

    }

    public CartaMonstruo monstruoConMenorAtaque(CartaMonstruo otra) {

        throw new NoCartaMonstruoError();

    }

    public void desactivarTemporales() {

        throw new NoCartaMonstruoError();

    }



    public int conCuantosPuntosAtaca() {

        throw new NoCartaMonstruoError();

    }

    public void ponerNombre(String nombre){

        throw new NoCartaMonstruoError();

    }

    @Override
    public String toString(){

        return "NoCartaMonstruo";

    }

    @Override
    public Image imagen() {
        return new Image("Vista/Imagenes/bocaNeutra.jpg");
    }
}
