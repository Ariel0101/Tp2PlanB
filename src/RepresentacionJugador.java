import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class RepresentacionJugador implements Actualizable{
    private final Jugador jugador;
    private final VBox jugadorVBox;
    private final int vidaTotal;
    private ImageView imagen;
    private ProgressBar barra;
    private Label nombre;

    RepresentacionJugador(Jugador jugador, VBox jugadorVBox, ImageView imagenJugador, ProgressBar barraDeVida, Label etiqueta){
        this.jugador = jugador;
        this.jugadorVBox = jugadorVBox;
        this.imagen = imagenJugador;
        this.barra = barraDeVida;
        this.nombre = etiqueta;
        this.vidaTotal = this.jugador.verVida();

    }


    @Override
    public void actualizar() {
        this.jugadorVBox.getChildren().clear();
        nombre.setText(jugador.toString() +" "+ jugador.verVida() + "/" + this.vidaTotal);
        barra.setProgress(jugador.verVida()/(1.0*this.vidaTotal));
        this.jugadorVBox.getChildren().addAll(imagen, nombre, barra);
        }
}
