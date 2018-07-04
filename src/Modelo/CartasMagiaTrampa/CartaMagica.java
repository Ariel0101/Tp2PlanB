package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaAbajo;
import Modelo.Estados.BocaArriba;
import Modelo.Estados.BocaNeutra;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class CartaMagica implements Carta {

    private Magia magia;
    private Boca boca;
    private String nombre;

    public CartaMagica(String nombre, Magia magia) {

        this.nombre = nombre;
        this.magia = magia;
        this.boca = new BocaNeutra();

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

    public String toString(){

        return this.nombre;
    }

    public Image imagen(){

        return this.boca.imagen(this.nombre, "");

    }

}
