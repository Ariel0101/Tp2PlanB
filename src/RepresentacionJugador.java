import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class RepresentacionJugador implements Actualizable{
    private final Jugador jugador;
    private final HBox jugadorHBox;

    RepresentacionJugador(Jugador jugador, HBox jugadorHBox){
        this.jugador = jugador;
        this.jugadorHBox = jugadorHBox;
    }


    @Override
    public void actualizar() {
        this.jugadorHBox.getChildren().clear();
        int vida = this.jugador.verVida();
        String vidaString = String.format("Vida Restante : %d", vida);
        TextArea vidaVisual = new TextArea(vidaString);
        vidaVisual.setEditable(false);

        this.jugadorHBox.getChildren().add(vidaVisual);
    }
}
