import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class RepresentacionJugador implements Actualizable{
    private final Jugador jugador;
    private final HBox jugadorHBox;
    private ImageView imagen;
    private ProgressBar barra;
    private Label nombre;

    RepresentacionJugador(Jugador jugador, HBox jugadorHBox, ImageView imagenJugador, ProgressBar barraDeVida, Label etiqueta){
        this.jugador = jugador;
        this.jugadorHBox = jugadorHBox;
        this.imagen = imagenJugador;
        this.barra = barraDeVida;
        this.nombre = etiqueta;

    }


    @Override
    public void actualizar() {
        this.jugadorHBox.getChildren().clear();
        int vida = this.jugador.verVida();
       // String vidaString = String.format("Vida Restante : %d", vida);
        nombre.setText(jugador.toString() +" "+ (int)jugador.verVida() + "/" + (int)jugador.verVidaMaxima());

        //TextArea vidaVisual = new TextArea(vidaString);
        barra.setProgress(jugador.verVida()/(1.0*jugador.verVidaMaxima()));
       // vidaVisual.setEditable(false);
        this.jugadorHBox.getChildren().addAll(imagen, nombre, barra);
        }
}
