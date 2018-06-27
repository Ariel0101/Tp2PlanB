import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class BotonAceptar implements EventHandler<ActionEvent> {

    private final ComboBox<String> pos;
    private CartaMonstruo monstruo;
    private final Stage stage;

    public BotonAceptar(ComboBox<String> posicion, CartaMonstruo monstruo, Stage stage) {

        this.pos = posicion;
        this.monstruo = monstruo;
        this.stage = stage;

    }

    public void handle(ActionEvent actionEvent){

        if (pos.getValue() == "En Ataque"){

            System.out.print("Colocado en pos ataque.\n");

            monstruo.colocarEnPosAtaque();

        }

        if (pos.getValue() == "En Defensa"){

            System.out.print("Colocado en pos defensa.\n");

            monstruo.colocarEnPosDefensa();

        }

        if (pos.getValue() == null){
            System.out.print("Colocado en pos ataque, por defecto.\n");

            monstruo.colocarEnPosAtaque();
        }

        this.stage.close();

    }
}
