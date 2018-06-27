import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class Partida {
    private final Stage ventana;
    private String ganador;
    private String perdedor;

    Partida(){
        this.perdedor = "";
        this.ganador = "";
        this.ventana = new Stage();
    }

    Partida(Stage ventanaDePartida){
        this.perdedor = "";
        this.ganador = "";
        this.ventana = ventanaDePartida;
    }

    public String verGanador() {

        return this.ganador;

    }

    public void setGanador(String nombreJugador) {
        this.ganador = nombreJugador;


    }

    public String verPerdedor() {

        return this.perdedor;

    }

    public void setPerdedor(String nombreJugador) {

        this.perdedor = nombreJugador;
        Stage ventanaFinDelJuego = new Stage();
        String mensajeFinDelJuego = String.format("Jugador : %s ha perdido.", nombreJugador);
        TextArea textoFinDelJuego = new TextArea(mensajeFinDelJuego);
        textoFinDelJuego.setEditable(false);
        Scene escenaJugadorPerdio = new Scene(textoFinDelJuego);
        ventanaFinDelJuego.setScene(escenaJugadorPerdio);
        ventanaFinDelJuego.show();
        this.ventana.close();
    }
}
