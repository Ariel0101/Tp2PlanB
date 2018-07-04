package Controlador;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.CartasMonstruo.NoCartaMonstruo;
import Modelo.Excepciones.NoHaySufucienteSacrificiosError;
import Modelo.Jugador.Mano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocarCarta implements EventHandler<ActionEvent>, Reiniciable {

    private final Campo campo;
    private final Mano mano;
    private final ActualizadorDeRepresentaciones actualizador;
    private CartaMonstruo monstruoColocado;

    BotonColocarCarta(Campo campo, Mano mano, ActualizadorDeRepresentaciones actualizador) {

        this.campo = campo;
        this.mano = mano;
        this.actualizador = actualizador;
        this.monstruoColocado = new NoCartaMonstruo(new Monstruo(0,0));

    }

    public void handle(ActionEvent actionEvent) {
        Stage ventanaColocarCarta = new Stage();

        ComboBox<Carta> eleccionCarta = new ComboBox<>();
        eleccionCarta.setPromptText("Eligi tu carta");

        for (Carta c : this.mano.cartas()) {
            if (c instanceof CartaMonstruo && this.monstruoColocado.getClass() != NoCartaMonstruo.class){
                continue;
            }
            eleccionCarta.getItems().add(c);

        }

        ComboBox<String> opcionesBoca = new ComboBox<>();
        opcionesBoca.setPromptText("Boca abajo");
        opcionesBoca.getItems().add("Boca abajo");
        opcionesBoca.getItems().add("Boca arriba");



        Button botonAceptarBoca = new Button("Bueno, colocar en el campo");

        botonAceptarBoca.setOnAction(actionEvent1 -> {
            this.aceptarColocar(eleccionCarta,opcionesBoca, ventanaColocarCarta);
        });


        ImageView imagenDeCarta = new ImageView();
        imagenDeCarta.setFitWidth(240);
        imagenDeCarta.setFitHeight(400);
        eleccionCarta.setOnAction((e -> imagenDeCarta.setImage(eleccionCarta.getValue().imagen())));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(eleccionCarta,opcionesBoca, botonAceptarBoca, imagenDeCarta);

        Scene escenaColocarCarta = new Scene(layout, 300, 550);
        ventanaColocarCarta.setScene(escenaColocarCarta);
        ventanaColocarCarta.show();


    }

    private void aceptarColocar(ComboBox<Carta> eleccionCarta, ComboBox<String> opcionesBoca, Stage ventanaColocarCarta) {
        Carta cartaAColocar = eleccionCarta.getValue();

        if (cartaAColocar == null ) {
            ventanaColocarCarta.close();
            return;
        }

        try {
            this.mano.colocar(cartaAColocar, this.campo);
        } catch (NoHaySufucienteSacrificiosError e){
            String avisoParteUno = "No hay suficientes sacrificios en el campo: \n";
            String avisoParteDos = "5 a 6 estrellas : 1 Sacrificios \n";
            String avisoParteTres = "7 o mas estrellas : 2 Sacrificios \n";
            String avisoParteCuatro = "En caso de fusion, leer descripcion en la carta \n";
            new Alerta(avisoParteUno + avisoParteDos + avisoParteTres + avisoParteCuatro, ventanaColocarCarta);
            return;
        }
        if (cartaAColocar instanceof CartaMonstruo){
            this.monstruoColocado = (CartaMonstruo) cartaAColocar;
        }

        this.colocarBoca(cartaAColocar, opcionesBoca);

        if (cartaAColocar instanceof CartaMonstruo){

            this.preguntarPosicion((CartaMonstruo) cartaAColocar);

        }

        this.actualizador.actualizar();
        ventanaColocarCarta.close();

    }

    private void colocarBoca(Carta cartaAColocar, ComboBox<String> opcionesBoca) {
        if (opcionesBoca.getValue() == "Boca arriba"){

            System.out.print("Colocado boca arriba\n");

            cartaAColocar.colocarBocaArriba();

            if (cartaAColocar instanceof CartaMagica){
                this.campo.destruir((CartaMagica) cartaAColocar);
            }

        }

        if (opcionesBoca.getValue() == "Boca abajo"){

            System.out.print("Colocado boca abajo\n");

            cartaAColocar.colocarBocaAbajo();

        }
        if (opcionesBoca.getValue() == null){ //Por defecto
            System.out.println("Colocado boca abajo, por defecto\n");
            cartaAColocar.colocarBocaAbajo();
        }
    }

    private void preguntarPosicion(CartaMonstruo cartaAColocar) {
        Stage ventanaElegirPosicion = new Stage();
        ventanaElegirPosicion.setTitle("¿Que posicion?");

        ComboBox<String> opcionesPosicion = new ComboBox<>();
        opcionesPosicion.setPromptText("En Ataque");
        opcionesPosicion.getItems().add("En Ataque");
        opcionesPosicion.getItems().add("En Defensa");

        Button botonAceptarPosicion = new Button("aceptar");
        botonAceptarPosicion.setOnAction(actionEvent -> {
            this.aceptarPosicion(opcionesPosicion,cartaAColocar, ventanaElegirPosicion);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(opcionesPosicion, botonAceptarPosicion);

        Scene scene = new Scene(layout, 200, 250);

        ventanaElegirPosicion.setScene(scene);
        ventanaElegirPosicion.show();
    }

    private void aceptarPosicion(ComboBox<String> opcionesPosicion, CartaMonstruo cartaAColocar, Stage ventanaElegirPosicion) {
        if (opcionesPosicion.getValue() == "En Ataque"){

            System.out.print("Colocado en pos ataque.\n");

            cartaAColocar.colocarEnPosAtaque();

        }

        if (opcionesPosicion.getValue() == "En Defensa"){

            System.out.print("Colocado en pos defensa.\n");

            cartaAColocar.colocarEnPosDefensa();

        }

        if (opcionesPosicion.getValue() == null){ //Por defecto
            System.out.print("Colocado en pos ataque, por defecto.\n");

            cartaAColocar.colocarEnPosAtaque();
        }
        this.actualizador.actualizar();
        ventanaElegirPosicion.close();
    }

    public void reiniciar(){

        this.monstruoColocado = new NoCartaMonstruo(new Monstruo(0,0));

    }

    public boolean colocaste(CartaMonstruo carta){

        return this.monstruoColocado == carta;

    }

}

