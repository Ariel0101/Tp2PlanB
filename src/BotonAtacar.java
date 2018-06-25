import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonAtacar implements EventHandler<ActionEvent> {

    private Campo campo;
    private Campo campoEnemigo;
    private final Jugador jugador;
    private final Jugador enemigo;

    BotonAtacar(Campo campo, Campo campoEnemigo, Jugador jugador, Jugador enemigo) {

        this.campo = campo;
        this.campoEnemigo = campoEnemigo;
        this.jugador = jugador;
        this.enemigo = enemigo;

    }

    public void handle(ActionEvent actionEvent){

        Stage stage = new Stage();

        ComboBox<CartaMonstruo> eleccionAtacante = new ComboBox<>();
        eleccionAtacante.setPromptText("Eligi tu Monstruo");

        for (CartaMonstruo m : this.campo.listaMonstruos()) {

            eleccionAtacante.getItems().add(m);

        }

        ComboBox<CartaMonstruo> eleccionAtacado = new ComboBox<>();
        eleccionAtacado.setPromptText("Eligi el Monstruo enemigo");

        for (CartaMonstruo m : this.campoEnemigo.listaMonstruos()) {

            eleccionAtacado.getItems().add(m);

        }


        Button comenzarAtaque = new Button("Comenzar ataque");

        comenzarAtaque.setOnAction(e ->
                this.aceptar(eleccionAtacante.getValue(), eleccionAtacado.getValue(), stage)
        );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionAtacante, eleccionAtacado, comenzarAtaque);

        Scene scene =  new Scene(layout, 300, 500);
        stage.setScene(scene);
        stage.show();


    }

    private void aceptar(CartaMonstruo atacante, CartaMonstruo atacado, Stage stage){

        if (atacante == null || atacado == null){

            return;

        }

        Combate combate = new Combate(jugador, campo, enemigo, campoEnemigo);
        combate.combatir(atacante, atacado);
        stage.close();

        System.out.print("Combate realizado:" + atacante.toString() + " vs " + atacado.toString());

    }

}
