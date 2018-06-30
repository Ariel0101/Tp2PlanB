package Cartas;

import Excepciones.MonstruoNoPuedeAtacarError;
import javafx.scene.image.Image;

public class CartaTrampa implements Carta {
    private final Trampa trampa;
    private Boca boca;
    private String nombre;

    CartaTrampa(Trampa trampa) {
        this.trampa = trampa;
        this.boca = new BocaNeutra();
        this.nombre = "sin-nombre";
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

    @Override
    public Image imagen() {

        return this.boca.imagen(this.nombre, "");
    }

    @Override
    public void ponerNombre(String nombre) {
        this.nombre = nombre;
    }

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError {
        this.colocarBocaArriba();
        return this.trampa.activar(monstruoAtacante, monstruoAtacado, unBotin);
    }
}
