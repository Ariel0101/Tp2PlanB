package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.CartaDeCampo;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class ControladorCartaDeCampo implements Actualizable{
    private final Campo campo;
    private final VBox slotCartaDeCampo;

    ControladorCartaDeCampo(Campo campo, VBox slotCartaDeCampo){
        this.campo = campo;
        this.slotCartaDeCampo = slotCartaDeCampo;
    }


    public void actualizar() {
        this.slotCartaDeCampo.getChildren().clear();
        CartaDeCampo unaCartaDeCampo = this.campo.cartaDeCampo();
        ImageView imagenCarta = new ImageView();
        imagenCarta.setFitWidth(150);
        imagenCarta.setFitHeight(170);
        imagenCarta.setImage(unaCartaDeCampo.imagen());
        this.slotCartaDeCampo.getChildren().add(imagenCarta);
    }
}
