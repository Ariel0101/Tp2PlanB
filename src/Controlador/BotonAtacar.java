package Controlador;

import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.CartaMonstruoJinzo7;
import Modelo.Combate.Atacable;
import Modelo.Combate.Combate;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Jugador.Jugador;
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

    BotonAtacar(Campo campo, Campo campoEnemigo, Jugador jugador, Jugador enemigo, ActualizadorDeRepresentaciones actualizador) {

        this.campo = campo;
        this.campoEnemigo = campoEnemigo;
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.actualizador = actualizador;
        this.monstruosQueYaAtacaron = new HashSet<>();

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

        Button botonElegirOponente = new Button("Elegir Oponente");
        botonElegirOponente.setOnAction(actionEvent1 -> {
            CartaMonstruo atacante = eleccionAtacante.getValue();
            this.elegirOponente(atacante);
            ventantaDeAtaque.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionAtacante, botonElegirOponente); //, eleccionAtacado, comenzarAtaque

        Scene scene =  new Scene(layout, 300, 500);
        ventantaDeAtaque.setScene(scene);
        ventantaDeAtaque.show();


    }

    private void elegirOponente(CartaMonstruo atacante){
        Stage ventantaDeAtaque = new Stage();

        ComboBox<Atacable> eleccionAtacado = new ComboBox<>();
        eleccionAtacado.setPromptText("Eligir oponente ");

        for (Atacable m : this.campoEnemigo.listaMonstruos()) {

            eleccionAtacado.getItems().add(m);

        }
        if (atacante instanceof CartaMonstruoJinzo7){
            eleccionAtacado.getItems().add(this.enemigo);
        }

        Button comenzarAtaque = new Button("Comenzar ataque");

        comenzarAtaque.setOnAction(e ->{
                this.aceptar(atacante, eleccionAtacado.getValue(), ventantaDeAtaque);
        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionAtacado, comenzarAtaque); //, eleccionAtacado, comenzarAtaque

        Scene scene =  new Scene(layout, 300, 500);
        ventantaDeAtaque.setScene(scene);
        ventantaDeAtaque.show();

    }

    private void aceptar(CartaMonstruo atacante, Atacable atacado, Stage ventantaDeAtaque){

        if (atacante == null || atacado == null){

            return;

        }

        if (atacado instanceof Jugador){
            atacado.recibirAtaque(atacante, campoEnemigo);
            this.monstruosQueYaAtacaron.add(atacante);
            this.actualizador.actualizar();
            ventantaDeAtaque.close();
            return;
        }

        Combate combate = new Combate(jugador, campo, enemigo, campoEnemigo);
        try {
            combate.combatir(atacante, (CartaMonstruo) atacado);
        } catch (MonstruoNoPuedeAtacarError e){
            Stage ventanaDeError = new Stage();
            TextArea avisoDeErrorDeSacrifcios = new TextArea( "Monstruo elegido no esta en posicion de ataque.\n");
            avisoDeErrorDeSacrifcios.setEditable(false);
            Scene escenaDeErrorDeInvocacion = new Scene(avisoDeErrorDeSacrifcios);
            ventanaDeError.setScene(escenaDeErrorDeInvocacion);
            ventanaDeError.show();
            ventantaDeAtaque.close();
            return;
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
