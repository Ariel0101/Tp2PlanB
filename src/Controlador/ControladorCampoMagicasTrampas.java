package Controlador;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMagiaTrampa.CartaTrampa;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Iterator;
import java.util.LinkedList;

public class ControladorCampoMagicasTrampas implements Actualizable {

    private final Campo campo;
    private final HBox campoHBox;

    ControladorCampoMagicasTrampas(Campo campo, HBox campoMagicasTrampasHBox){
        this.campo = campo;
        this.campoHBox = campoMagicasTrampasHBox;
    }


    public void actualizar() {
        this.campoHBox.getChildren().clear();
        LinkedList<CartaMagica> cartasMagicas = this.campo.magicas();
        LinkedList<CartaTrampa> cartasTrampa = this.campo.trampas();

        int ancho_imagen = 80;
        int alto_imagen = 120;

        Iterator<CartaMagica> iteradorMagicas = cartasMagicas.iterator();

        while (iteradorMagicas.hasNext()) {
            Carta carta = iteradorMagicas.next();
            ImageView imagenCarta = new ImageView();
            imagenCarta.setFitWidth(ancho_imagen);
            imagenCarta.setFitHeight(alto_imagen);
            imagenCarta.setImage(carta.imagen());
            this.campoHBox.getChildren().add(imagenCarta);
        }

        Iterator<CartaTrampa> iteradorTrampas = cartasTrampa.iterator();

        while (iteradorTrampas.hasNext()) {
            Carta carta = iteradorTrampas.next();
            ImageView imagenCarta = new ImageView();
            imagenCarta.setFitWidth(ancho_imagen);
            imagenCarta.setFitHeight(alto_imagen);
            imagenCarta.setImage(carta.imagen());
            this.campoHBox.getChildren().add(imagenCarta);
        }
    }
}
