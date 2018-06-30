package Controlador;

import Modelo.Carta;
import Modelo.Jugador.Mano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BotonVerMano implements EventHandler<ActionEvent> {

    private Mano mano;

    public BotonVerMano(Mano mano) {

        this.mano = mano;

    }

    @Override
    public void handle(ActionEvent event) {

        Stage ventana = new Stage();
        ventana.setTitle("Cartas en mano");

        HBox monstruosEnMano = new HBox();
        monstruosEnMano.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnMano.setSpacing(10);
        monstruosEnMano.setStyle("-fx-background-color: #336699;");
        ScrollPane scroll = new ScrollPane(monstruosEnMano);
        scroll.setFitToHeight(true);
        scroll.setFitToWidth(true);
        BorderPane bordeDeVentana = new BorderPane(scroll);
        for(Carta c : this.mano.cartas()){

            ImageView i = new ImageView();
            i.setImage(c.imagen());
            i.setFitWidth(100);
            i.setFitHeight(150);
            monstruosEnMano.getChildren().add(i);

        }

        Scene escena = new Scene(bordeDeVentana, 500, 250);
        ventana.setScene(escena);
        ventana.show();

    }

}
