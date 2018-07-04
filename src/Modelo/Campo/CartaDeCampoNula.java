package Modelo.Campo;

import javafx.scene.image.Image;

public class CartaDeCampoNula extends CartaDeCampo {
    CartaDeCampoNula(String nombre ,EfectoDeCampoNulo unEfectoDeCampoNulo) {
        super(nombre, unEfectoDeCampoNulo);
    }

    public Image imagen() {
        return new Image("Vista/Imagenes/bocaNeutra.jpg");
    }
}
