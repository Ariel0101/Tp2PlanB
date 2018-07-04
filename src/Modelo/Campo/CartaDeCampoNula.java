package Modelo.Campo;

import javafx.scene.image.Image;

public class CartaDeCampoNula extends CartaDeCampo {
    CartaDeCampoNula(EfectoDeCampoNulo unEfectoDeCampoNulo) {
        super(unEfectoDeCampoNulo);
    }

    @Override
    public Image imagen() {
        return new Image("Vista/Imagenes/bocaNeutra.jpg");
    }
}
