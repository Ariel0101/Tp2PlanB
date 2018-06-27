import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class Partida {
    private Stage ventana;
    private String ganador;
    private String perdedor;

    Partida(){
        this.perdedor = "";
        this.ganador = "";
        this.ventana = null;
    }

    public String verGanador() {

        return this.ganador;

    }

    private void finalizarJuego(String resultadoDeLaPartida){
        //Interfaz Grafica //Solo valido cuando las ordenes vienen desde el main.
        if (this.ventana != null){
            Stage ventanaFinDelJuego = new Stage();
            TextArea textoFinDelJuego = new TextArea(resultadoDeLaPartida);
            textoFinDelJuego.setEditable(false);
            Scene escenaFinDelJuego = new Scene(textoFinDelJuego);
            ventanaFinDelJuego.setScene(escenaFinDelJuego);
            ventanaFinDelJuego.show();
            this.ventana.close();
        }
    }

    public void setGanador(String nombreJugador) {
        this.ganador = nombreJugador;
        String mensajeFinDelJuego = String.format("Jugador : %s ha ganado.", nombreJugador);
        this.finalizarJuego(mensajeFinDelJuego);
    }

    public String verPerdedor() {

        return this.perdedor;

    }

    public void setPerdedor(String nombreJugador) {

        this.perdedor = nombreJugador;
        String mensajeFinDelJuego = String.format("Jugador : %s ha perdido.", nombreJugador);
        this.finalizarJuego(mensajeFinDelJuego);
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }
}
