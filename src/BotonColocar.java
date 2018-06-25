import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BotonColocar implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final ComboBox cm;
    private final Mano mano;
    private final HBox monstruos;
    Carta carta;
    Stage ventana;

    BotonColocar(Campo campo, ComboBox cm, Mano mano, Stage ventana, HBox monstruos){
        
        this.campo = campo;
        this.cm = cm;
        this.mano = mano;
        this.ventana = ventana;
        this.carta = new NoCarta(); //parche terrible
        this.monstruos = monstruos;
        
    }
    
    public void handle(ActionEvent actionEvent){

        this.carta = (Carta) cm.getValue();

        if (this.carta != null && carta.getClass() != NoCarta.class) {

            carta.colocarse(this.campo);

            mano.sacar(carta);

            ImageView imagen = new ImageView();
            imagen.setImage(carta.imagen());
            imagen.setFitWidth(100);
            imagen.setFitHeight(150);
            this.monstruos.getChildren().add(imagen);
        }

        this.ventana.close();

    }
    
}
