import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocar implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final ComboBox<Carta> cm;
    private final Mano mano;
    private final ComboBox boca;
    private final ActualizadorDeRepresentaciones actualizador;
    Carta carta;
    Stage ventana;

    BotonColocar(Campo campo, ComboBox<Carta> cm, Mano mano, Stage ventana,ActualizadorDeRepresentaciones actualizador , ComboBox boca){
        
        this.campo = campo;
        this.cm = cm;
        this.mano = mano;
        this.ventana = ventana;
        this.carta = new NoCarta(); //parche terrible
        this.actualizador = actualizador;
        this.boca = boca;
        
    }

    public void handle(ActionEvent actionEvent){

        this.carta = (Carta) cm.getValue();

        if (this.carta == null || carta.getClass() == NoCarta.class) {

            this.ventana.close();
            return;
        }
        try {
            carta.colocarse(this.campo);
        } catch (NoHaySufucienteSacrificiosError e){
            Stage ventanaDeError = new Stage();
            String avisoParteUno = "No hay suficientes sacrificios en el campo: \n";
            String avisoParteDos = "5 a 6 estrellas : 1 Sacrificios \n";
            String avisoParteTres = "7 o mas estrellas : 2 Sacrificios \n";
            String avisoParteCuatro = "En caso de fusion, leer descripcion en la carta \n";
            TextArea avisoDeErrorDeSacrifcios = new TextArea( avisoParteUno + avisoParteDos + avisoParteTres + avisoParteCuatro);
            Scene escenaDeErrorDeInvocacion = new Scene(avisoDeErrorDeSacrifcios);
            ventanaDeError.setScene(escenaDeErrorDeInvocacion);
            ventanaDeError.show();
            this.ventana.close();
            return;
        }


        mano.sacar(carta);

        this.colocarBoca();

        if (carta instanceof CartaMonstruo){

            this.preguntarPosicion();

        }

        this.actualizador.actualizar();
        this.ventana.close();

    }

    void colocarBoca(){

        if (this.boca.getValue() == "Boca arriba"){

            System.out.print("Colocado boca arriba");

            carta.colocarBocaArriba();

        }

        if (this.boca.getValue() == "Boca abajo"){

            System.out.print("Colocado boca abajo");

            carta.colocarBocaAbajo();

        }

    }

    void preguntarPosicion(){

        Stage stage = new Stage();

        ComboBox<String> posicion = new ComboBox<>();
        posicion.setPromptText("Que posicion?");
        posicion.getItems().add("Ataque");
        posicion.getItems().add("Defensa");

        BotonAceptar botonAceptar = new BotonAceptar(posicion, (CartaMonstruo) this.carta, stage);
        Button aceptar = new Button("aceptar");
        aceptar.setOnAction(botonAceptar);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 300, 20));
        layout.getChildren().addAll(posicion, aceptar);

        Scene scene = new Scene(layout, 200, 250); //

        stage.setScene(scene);
        stage.show();

    }



}
