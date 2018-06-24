import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocarMonstruo implements EventHandler<ActionEvent> {

    private Mano mano;
    private Campo campo;
    private Scene scene;
    private Stage stage;


    BotonColocarMonstruo(Campo campo, Mano mano) {

        this.campo = campo;
        this.mano = mano;
        //this.carta = new NoCarta();

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        this.stage = new Stage();

        ComboBox<String> eleccionCarta = new ComboBox<>();

        eleccionCarta.setPromptText("Eligi tu carta");

        for (Carta m : this.mano.cartas()) {

            eleccionCarta.getItems().add(m.nombre());

        }

        Button botN = new Button("Bueno, colocar en el campo");
        BotonColocar botonColocar = new BotonColocar(campo, eleccionCarta, mano, this.stage);
        botN.setOnAction(botonColocar);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(eleccionCarta, botN);

        this.scene = new Scene(layout, 300, 200);
        this.stage.setScene(this.scene);
        this.stage.show();

    }


}
