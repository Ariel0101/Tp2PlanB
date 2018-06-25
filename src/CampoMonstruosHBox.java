import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import java.util.Iterator;

class CampoMonstruosHBox extends HBox implements Actualizable {
    private final Campo campo;

    CampoMonstruosHBox(Campo campoARepresentar){
        this.campo = campoARepresentar;
    }

    public void actualizar(){
        this.getChildren().clear();
        ListaMonstruos monstruos = this.campo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstruos.iterator();
        while (iteradorMonstruos.hasNext()) {
            CartaMonstruo carta = iteradorMonstruos.next();
            ImageView imagenCarta = new ImageView();
            imagenCarta.setFitWidth(100);
            imagenCarta.setFitHeight(150);
            imagenCarta.setImage(carta.imagen());
            this.getChildren().add(imagenCarta);
        }
    }
}
