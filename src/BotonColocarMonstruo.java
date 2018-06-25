import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocarMonstruo implements EventHandler<ActionEvent> {

    private final HBox monstruos;
    private Mano mano;
    private Campo campo;
    private Scene scene;
    private Stage stage;


    BotonColocarMonstruo(Campo campo, Mano mano, HBox monstruosEnCampo) {

        this.campo = campo;
        this.mano = mano;
        this.monstruos = monstruosEnCampo;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        this.stage = new Stage();

        ComboBox<Carta> eleccionCarta = new ComboBox<>();

        eleccionCarta.setPromptText("Eligi tu carta");

        for (Carta m : this.mano.cartas()) {

            eleccionCarta.getItems().add(m);

        }

        Button botN = new Button("Bueno, colocar en el campo");
        BotonColocar botonColocar = new BotonColocar(campo, eleccionCarta, mano, this.stage, this.monstruos);
        botN.setOnAction(botonColocar);


        ImageView imagenDeCarta = new ImageView();
        imagenDeCarta.setFitWidth(240);
        imagenDeCarta.setFitHeight(400);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionCarta, botN, imagenDeCarta);


        this.scene = new Scene(layout, 300, 500);
        this.stage.setScene(this.scene);
        this.stage.show();

        eleccionCarta.setOnAction((e -> imagenDeCarta.setImage(eleccionCarta.getValue().imagen())));


    }


}
