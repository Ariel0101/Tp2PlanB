import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class BotonVerVida implements EventHandler<ActionEvent> {

    private final Jugador jugador;

    BotonVerVida(Jugador jugador){

        this.jugador = jugador;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Integer intVida = this.jugador.verVida();
        String vida = intVida.toString();

        Stage stage = new Stage();
        String textoConVidaDeJugador = "Vida de " + this.jugador.nombre() + ": " + vida;

        TextArea texto = new TextArea(textoConVidaDeJugador);
        Scene scene = new Scene(texto);
        stage.setScene(scene);
        stage.show();

        Button aceptar = new Button("Ok");
        aceptar.setOnAction(e -> stage.close());

    }
}
