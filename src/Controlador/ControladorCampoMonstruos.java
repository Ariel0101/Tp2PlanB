package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;
import Modelo.Carta;
import Modelo.CartasMonstruo.CartaMonstruo;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Iterator;

public class ControladorCampoMonstruos implements Actualizable {

    private final Campo campo;
    private final HBox campoHBox;

    ControladorCampoMonstruos(Campo campo, HBox campoMonstruosHBox){
        this.campo = campo;
        this.campoHBox = campoMonstruosHBox;
    }

    public void actualizar() {
        int anchoImagen = 80;
        int altoImagen = 120;
        this.campoHBox.getChildren().clear();
        ListaMonstruos monstruos = this.campo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstruos.iterator();
        while (iteradorMonstruos.hasNext()) {
            Carta carta = iteradorMonstruos.next();
            ImageView imagenCarta = new ImageView();
            imagenCarta.setFitWidth(anchoImagen);
            imagenCarta.setFitHeight(altoImagen);
            imagenCarta.setImage(carta.imagen());
            this.campoHBox.getChildren().add(imagenCarta);
        }
    }
}
