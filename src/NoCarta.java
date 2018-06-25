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

        return new Image("imagenes/bocaNeutra.jpg");

    }
}
