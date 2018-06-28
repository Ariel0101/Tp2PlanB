import Excepciones.MonstruoNoPuedeAtacarError;
import Excepciones.NoSePuedeAtacarAJugadorError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
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
    private Stage ventana;

    BotonAtacar(Campo campo, Campo campoEnemigo, Jugador jugador, Jugador enemigo, ActualizadorDeRepresentaciones actualizador, Stage ventanaPrincipal) {

        this.campo = campo;
        this.campoEnemigo = campoEnemigo;
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.actualizador = actualizador;
        this.monstruosQueYaAtacaron = new HashSet<>();
        this.ventana = ventanaPrincipal;

    }

    public void handle(ActionEvent actionEvent){

        Stage ventantaDeAtaque = new Stage();

        ComboBox<CartaMonstruo> eleccionAtacante = new ComboBox<>();
        eleccionAtacante.setPromptText("Eligi tu Monstruo");

        for (CartaMonstruo m : this.campo.listaMonstruos()) {
            if (! this.monstruosQueYaAtacaron.contains(m)) {
                eleccionAtacante.getItems().add(m);
            }
        }

        ComboBox<Atacable> eleccionAtacado = new ComboBox<>();
        eleccionAtacado.setPromptText("Elige a quien quieres atacar ");

        eleccionAtacado.getItems().add(enemigo);
        for (CartaMonstruo m : this.campoEnemigo.listaMonstruos()) {

            eleccionAtacado.getItems().add(m);

        }

        Button comenzarAtaque = new Button("Atacar");

        comenzarAtaque.setOnAction(e ->
                this.aceptar(eleccionAtacante.getValue(), eleccionAtacado.getValue(), ventantaDeAtaque)
        );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionAtacante, eleccionAtacado, comenzarAtaque);

        Scene scene =  new Scene(layout, 300, 500);
        ventantaDeAtaque.setScene(scene);
        ventantaDeAtaque.show();


    }

    private void aceptar(CartaMonstruo atacante, Atacable atacado, Stage ventantaDeAtaque){

        if (atacante == null || atacado == null){

            return;

        }

        Combate combate = new Combate(jugador, campo, enemigo, campoEnemigo);
        try {
            combate.combatir(atacante, atacado);
        } catch (MonstruoNoPuedeAtacarError e){
            Stage ventanaDeError = new Stage();
            TextArea avisoDeErrorDeSacrifcios = new TextArea( "Monstruo elegido no esta en posicion de ataque.\n");
            avisoDeErrorDeSacrifcios.setEditable(false);
            Scene escenaDeErrorDeInvocacion = new Scene(avisoDeErrorDeSacrifcios);
            ventanaDeError.setScene(escenaDeErrorDeInvocacion);
            ventanaDeError.show();
            ventantaDeAtaque.close();
            return;
        } catch (NoSePuedeAtacarAJugadorError e) {
            new Alerta("No es posible atacar al jugador enemigo si tiene monstruos en su campo!", this.ventana);
        }

        this.monstruosQueYaAtacaron.add(atacante);
        this.actualizador.actualizar();
        ventantaDeAtaque.close();

        System.out.print("Combate realizado:" + atacante.toString() + " vs " + atacado.toString());

    }

    public void reiniciar(){
        this.monstruosQueYaAtacaron.clear();
    }

}
