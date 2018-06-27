import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocarMonstruo implements EventHandler<ActionEvent>, Reiniciable {

    private final ActualizadorDeRepresentaciones actualizador;
    private boolean seColocoMonstruo;
    private Mano mano;
    private Campo campo;
    private Scene scene;
    private Stage stage;


    BotonColocarMonstruo(Campo campo, Mano mano, ActualizadorDeRepresentaciones actualizador) {

        this.campo = campo;
        this.mano = mano;
        this.actualizador = actualizador;
        this.seColocoMonstruo = false;

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        this.stage = new Stage();

        ComboBox<Carta> eleccionCarta = new ComboBox<>();
        eleccionCarta.setPromptText("Eligi tu carta");

        for (Carta c : this.mano.cartas()) {
            if (c instanceof CartaMonstruo && this.seColocoMonstruo){
                continue;
            }
            eleccionCarta.getItems().add(c);

        }

        ComboBox<String> opcionesBoca = new ComboBox<>();
        opcionesBoca.setPromptText("Boca abajo");
        opcionesBoca.getItems().add("Boca arriba");
        opcionesBoca.getItems().add("Boca abajo");


        Button botN = new Button("Bueno, colocar en el campo");
        BotonColocar botonColocar = new BotonColocar(campo, eleccionCarta, mano, this.stage, this.actualizador, opcionesBoca);
        botN.setOnAction(botonColocar);


        ImageView imagenDeCarta = new ImageView();
        imagenDeCarta.setFitWidth(240);
        imagenDeCarta.setFitHeight(400);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionCarta,opcionesBoca, botN, imagenDeCarta);


        this.scene = new Scene(layout, 300, 550);
        this.stage.setScene(this.scene);
        this.stage.show();

        eleccionCarta.setOnAction((e -> imagenDeCarta.setImage(eleccionCarta.getValue().imagen())));
    }

    public void reiniciar(){
        this.seColocoMonstruo = false;
    }


}
