import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonSacarCartaDeMazo implements EventHandler<ActionEvent> {

    private final Button boton;
    Mazo mazo;
    Mano mano;

    BotonSacarCartaDeMazo(Mazo mazo, Mano mano, Button boton){

        this.mano = mano;
        this.mazo = mazo;
        this.boton = boton;

    }

    public void handle(ActionEvent actionEvent){

        this.mano.agregar(this.mazo.sacar());
        this.boton.setDisable(true);

    }


}
