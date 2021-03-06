package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.CartaMonstruoComeHombres;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Iterator;

public class BotonCambiarBocaYPosicion implements EventHandler<ActionEvent>, Reiniciable {

    private final Campo campo;
    private final ActualizadorDeRepresentaciones actualizador;
    private final HashSet<CartaMonstruo> monstruosQueYaCambiaron;
    private final BotonColocarCarta botonColocar;
    private final Campo campoEnemigo;


    BotonCambiarBocaYPosicion(Campo campo, BotonColocarCarta botonColocar , ActualizadorDeRepresentaciones actualizador, Campo campoEnemigo){
        this.campo = campo;
        this.actualizador = actualizador;
        this.monstruosQueYaCambiaron = new HashSet<CartaMonstruo>();
        this.botonColocar = botonColocar;
        this.campoEnemigo = campoEnemigo;
    }

    public void handle(ActionEvent actionEvent) {
        Stage ventanaCambiarPosicion = new Stage();

        ComboBox<CartaMonstruo> opcionesMonstruo = new ComboBox<>();
        opcionesMonstruo.setPromptText("Eligi tu Monstruo");

        for (CartaMonstruo m : this.campo.listaMonstruos()) {
            if (!this.monstruosQueYaCambiaron.contains(m) && !botonColocar.colocaste(m)){
                opcionesMonstruo.getItems().add(m);
            }
        }

        ComboBox<String> opcionesBoca = new ComboBox<>();
        opcionesBoca.setPromptText("Boca arriba");
        opcionesBoca.getItems().add("Boca arriba");
        opcionesBoca.getItems().add("Boca abajo");


        ComboBox<String> opcionesPosicion = new ComboBox<>();
        opcionesPosicion.setPromptText("Posicion Ataque");
        opcionesPosicion.getItems().add("Posicion Ataque");
        opcionesPosicion.getItems().add("Posicion Defensa");

        Button botonAceptarCambio = new Button("aceptar");
        botonAceptarCambio.setOnAction(actionEvent1-> {
            CartaMonstruo cartaElegida = opcionesMonstruo.getValue();
            if (cartaElegida != null) {
                this.colocarBoca(opcionesBoca, cartaElegida);
                this.colocarPosicion(opcionesPosicion,cartaElegida);
                this.monstruosQueYaCambiaron.add(cartaElegida);
                this.actualizador.actualizar();
            }
            ventanaCambiarPosicion.close();
        } );

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(opcionesMonstruo,opcionesBoca,opcionesPosicion,botonAceptarCambio);

        Scene escenaCambiarPosicion =  new Scene(layout, 300, 500);
        ventanaCambiarPosicion.setScene(escenaCambiarPosicion);
        ventanaCambiarPosicion.show();

    }

    private void colocarBoca(ComboBox<String> opcionesBoca, CartaMonstruo cartaElegida) {
        if (opcionesBoca.getValue() == "Boca arriba" || opcionesBoca.getValue() == null){ //por defecto
            if (cartaElegida instanceof CartaMonstruoComeHombres){
                /*CartaMonstruoComeHombres cartaComeHombres = (CartaMonstruoComeHombres) cartaElegida;
                cartaComeHombres.activarEfectoVisualmente(this.actualizador);*/
                ControladorEfectoComeHombres controladorEfectoComeHombres = new ControladorEfectoComeHombres((CartaMonstruoComeHombres) cartaElegida,this.campoEnemigo, this.actualizador);
                controladorEfectoComeHombres.activarEfecto();
            }
            cartaElegida.colocarBocaArriba();
            System.out.print("Colocado boca arriba\n");
        }

        if (opcionesBoca.getValue() == "Boca abajo"){
            System.out.print("Colocado boca abajo\n");
            cartaElegida.colocarBocaAbajo();
        }
    }

    private void colocarPosicion(ComboBox<String> opcionesPosicion, CartaMonstruo cartaElegida) {
        if (opcionesPosicion.getValue() == "Posicion Ataque"){
            System.out.print("Colocado en pos ataque.\n");
            cartaElegida.colocarEnPosAtaque();
        }

        if (opcionesPosicion.getValue() == "Posicion Defensa"){
            System.out.print("Colocado en pos defensa.\n");
            cartaElegida.colocarEnPosDefensa();
        }

        if (opcionesPosicion.getValue() == null){ //Por defecto
            System.out.print("Colocado en pos ataque, por defecto.\n");
            cartaElegida.colocarEnPosAtaque();
        }

    }



    public void reiniciar(){
        this.monstruosQueYaCambiaron.clear();
    }
}
