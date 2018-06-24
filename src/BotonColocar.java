import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class BotonColocar implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final ComboBox cm;
    private final Mano mano;
    Carta carta;
    Stage ventana;

    BotonColocar(Campo campo, ComboBox cm, Mano mano, Stage ventana){
        
        this.campo = campo;
        this.cm = cm;
        this.mano = mano;
        this.ventana = ventana;
        this.carta = new NoCarta(); //parche terrible
        
    }
    
    public void handle(ActionEvent actionEvent){


        for (Carta m: this.mano.cartas()){  //busca carta con el nombre elegido

            if (m.nombre() == cm.getValue()){

                 carta = m;
            }
        }

        if (carta.getClass() != NoCarta.class) {

            carta.colocarse(this.campo);

            mano.sacar(carta);
        }

        this.ventana.close();

    }
    
}
