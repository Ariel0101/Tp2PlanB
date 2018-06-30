package Modelo;

import Modelo.Campo.Campo;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class NoCarta implements Carta {

    @Override
    public void colocarse(Mano unaMano) {

    }

    @Override
    public void colocarse(Campo c) {

    }

    @Override
    public void colocarBocaAbajo() {

    }

    @Override
    public void colocarBocaArriba() {

    }

    @Override
    public Image imagen() {

        return new Image("Vista/imagenes/bocaNeutra.jpg");

    }

    @Override
    public void ponerNombre(String nombre) {

    }
}
