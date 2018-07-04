package Controlador;

import Modelo.Campo.Campo;
import Modelo.CartasMagiaTrampa.CartaMagica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonActivarMagica implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final ActualizadorDeRepresentaciones actualizador;

    BotonActivarMagica(Campo campo, ActualizadorDeRepresentaciones actualizador){

        this.campo = campo;
        this.actualizador = actualizador;
    }

    public void handle(ActionEvent actionEvent){

        Stage stage = new Stage();

        ComboBox<CartaMagica> eleccionCarta = new ComboBox<>();
        eleccionCarta.setPromptText("Eligi tu carta Magica");

        for (CartaMagica m : this.campo.magicas()) {

            eleccionCarta.getItems().add(m);

        }

        Button aceptar = new Button("Activar");
        aceptar.setOnAction(e -> this.activar(eleccionCarta.getValue(), stage));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionCarta,aceptar);

        Scene scene = new Scene(layout, 300, 500);
        stage.setScene(scene);
        stage.show();

    }

    void activar(CartaMagica carta, Stage stage){

        if (carta == null){

            return;

        }

        carta.colocarBocaArriba();
        this.campo.destruir(carta);
        this.actualizador.actualizar();

        System.out.print("Modelo.Carta magica colocada boca arriba y activada");

        stage.close();

    }

}
