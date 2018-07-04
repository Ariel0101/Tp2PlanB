package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaAbajo;
import Modelo.Estados.BocaArriba;
import Modelo.Estados.BocaNeutra;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class CartaTrampa implements Carta {
    private final String nombre;
    private final Trampa trampa;
    private Boca boca;

    public CartaTrampa(String nombre, Trampa trampa) {
        this.nombre = nombre;
        this.trampa = trampa;
        this.boca = new BocaNeutra();

    }

    public String toString(){
        return this.nombre;
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

    public Image imagen() {

        return this.boca.imagen(this.nombre, "");
    }
}
