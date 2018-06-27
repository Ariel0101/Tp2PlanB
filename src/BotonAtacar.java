import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;

public class BotonAtacar implements EventHandler<ActionEvent> , Reiniciable {

    private final ActualizadorDeRepresentaciones actualizador;
    private final HashSet<CartaMonstruo> monstruosQueYaAtacaron;
    private Campo campo;
    private Campo campoEnemigo;
    private final Jugador jugador;
    private final Jugador enemigo;

    BotonAtacar(Campo campo, Campo campoEnemigo, Jugador jugador, Jugador enemigo, ActualizadorDeRepresentaciones actualizador) {

        this.campo = campo;
        this.campoEnemigo = campoEnemigo;
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.actualizador = actualizador;
        this.monstruosQueYaAtacaron = new HashSet<>();

    }

    public void handle(ActionEvent actionEvent){

        Stage stage = new Stage();

        ComboBox<CartaMonstruo> eleccionAtacante = new ComboBox<>();
        eleccionAtacante.setPromptText("Eligi tu Monstruo");

        for (CartaMonstruo m : this.campo.listaMonstruos()) {
            if (! this.monstruosQueYaAtacaron.contains(m)) {
                eleccionAtacante.getItems().add(m);
            }
        }

        ComboBox<CartaMonstruo> eleccionAtacado = new ComboBox<>();
        eleccionAtacado.setPromptText("Elige a quien quieres atacar ");

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
        this.monstruosQueYaAtacaron.add(atacante);
        this.actualizador.actualizar();
        stage.close();

        System.out.print("Combate realizado:" + atacante.toString() + " vs " + atacado.toString());

    }

    public void reiniciar(){
        this.monstruosQueYaAtacaron.clear();
    }

}
