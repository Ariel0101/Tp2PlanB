import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonColocar implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final ComboBox cm;
    private final Mano mano;
    private final HBox monstruos;
    private final ComboBox boca;
    Carta carta;
    Stage ventana;

    BotonColocar(Campo campo, ComboBox cm, Mano mano, Stage ventana, HBox monstruos, ComboBox boca){
        
        this.campo = campo;
        this.cm = cm;
        this.mano = mano;
        this.ventana = ventana;
        this.carta = new NoCarta(); //parche terrible
        this.monstruos = monstruos;
        this.boca = boca;
        
    }
    
    public void handle(ActionEvent actionEvent){

        this.carta = (Carta) cm.getValue();

        if (this.carta == null || carta.getClass() == NoCarta.class) {

            this.ventana.close();
            return;
        }
        carta.colocarse(this.campo);

        mano.sacar(carta);

        this.colocarBoca();

        if (carta instanceof CartaMonstruo){

            this.preguntarPosicion();

        }

        ImageView imagen = new ImageView();
        imagen.setImage(carta.imagen());
        imagen.setFitWidth(100);
        imagen.setFitHeight(150);
        this.monstruos.getChildren().add(imagen);

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
