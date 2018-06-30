package Controlador;

import Modelo.Jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ControladorJugador implements Actualizable {
    private final Jugador jugador;
    private final VBox jugadorVBox;
    private final int vidaTotal;
    private ImageView imagen;
    private ProgressBar barraDeVida;
    private int anchuraBarraDeVida = 150;
    private int alturaBarraDeVida = 20;
    private Label etiquetaNombreYVida;
    private String estiloDeEtiqueta = "-fx-font: 15 arial;";

    ControladorJugador(Jugador jugador, VBox jugadorVBox, ImageView imagenJugador){
        this.jugador = jugador;
        this.jugadorVBox = jugadorVBox;
        this.imagen = imagenJugador;
        this.barraDeVida = iniciarBarraDeVida();
        this.etiquetaNombreYVida = iniciarEtiqueta();
        this.vidaTotal = this.jugador.verVida();
    }

    private Label iniciarEtiqueta () {

        Label etiqueta = new Label(jugador.toString() +" "+ jugador.verVida() + "/" + vidaTotal);
        etiqueta.setStyle(estiloDeEtiqueta);
        return etiqueta;
    }
    private ProgressBar iniciarBarraDeVida(){

        ProgressBar barra = new ProgressBar();
        barra.setProgress(1.0);
        barra.setPrefSize(anchuraBarraDeVida, alturaBarraDeVida);
        return barra;
    }

    public void actualizar() {

        this.jugadorVBox.getChildren().clear();
        etiquetaNombreYVida.setText(jugador.toString() +" "+ jugador.verVida() + "/" + this.vidaTotal);
        barraDeVida.setProgress(jugador.verVida()/(1.0*this.vidaTotal));
        this.jugadorVBox.getChildren().addAll(imagen, etiquetaNombreYVida, barraDeVida);
    }
}
