import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Iterator;
import java.util.LinkedList;

public class CampoMagicasTrampasHBox extends HBox implements Actualizable{
    private final Campo campo;

    CampoMagicasTrampasHBox(Campo campo){
        this.campo = campo;
    }

    public void actualizar(){
        this.getChildren().clear();
        LinkedList<CartaMagica>  cartasMagicas = this.campo.magicas();
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
            this.getChildren().add(imagenCarta);
        }

        Iterator<CartaTrampa> iteradorTrampas = cartasTrampa.iterator();

        while (iteradorMagicas.hasNext()) {
            Carta carta = iteradorTrampas.next();
            ImageView imagenCarta = new ImageView();
            imagenCarta.setFitWidth(ancho_imagen);
            imagenCarta.setFitHeight(alto_imagen);
            imagenCarta.setImage(carta.imagen());
            this.getChildren().add(imagenCarta);
        }


    }
}
