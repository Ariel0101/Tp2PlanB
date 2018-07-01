package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.CartaMonstruoComeHombres;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Iterator;

public class ControladorEfectoComeHombres {

    private final Campo campoEnemigo;
    private final ActualizadorDeRepresentaciones actualizador;
    private final CartaMonstruoComeHombres comeHombres;

    ControladorEfectoComeHombres(CartaMonstruoComeHombres comeHombres,Campo campoEnemigo, ActualizadorDeRepresentaciones actualizador){
        this.comeHombres = comeHombres;
        this.campoEnemigo = campoEnemigo;
        this.actualizador = actualizador;
    }

    public void activarEfecto() {
        Stage ventanaSeleccionarCarta = new Stage();

        ListaMonstruos monstrosEnemigos = this.campoEnemigo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstrosEnemigos.iterator();
        ComboBox<CartaMonstruo> opcionesMonstruos = new ComboBox<>();
        opcionesMonstruos.setPromptText("Elegir Monstruo a Destruir");
        while (iteradorMonstruos.hasNext()){
            CartaMonstruo carta = iteradorMonstruos.next();
            opcionesMonstruos.getItems().add(carta);
        }
        Button botonAceptarSeleccion = new Button("aceptar");
        botonAceptarSeleccion.setOnAction(actionEvent1 -> {
            CartaMonstruo cartaElegida = opcionesMonstruos.getValue();
            this.comeHombres.seleccionar(cartaElegida);
            this.comeHombres.colocarBocaAbajo();
            this.comeHombres.colocarBocaArriba();
            actualizador.actualizar();
            ventanaSeleccionarCarta.close();
            System.out.println(cartaElegida.toString() + " fue destruida por efecto de " + this.comeHombres.toString());
        });

        ImageView imagenDeCarta = new ImageView();
        imagenDeCarta.setFitWidth(240);
        imagenDeCarta.setFitHeight(400);
        opcionesMonstruos.setOnAction((e -> imagenDeCarta.setImage(opcionesMonstruos.getValue().imagen())));

        VBox contenedorSeleccion = new VBox(10);
        contenedorSeleccion.setPadding(new Insets(20, 20, 100, 20));
        contenedorSeleccion.getChildren().addAll(opcionesMonstruos,botonAceptarSeleccion, imagenDeCarta);
        Scene escenaSeleccionarCarta = new Scene(contenedorSeleccion);
        ventanaSeleccionarCarta.setScene(escenaSeleccionarCarta);
        ventanaSeleccionarCarta.show();
    }
}
