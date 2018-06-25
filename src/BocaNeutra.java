import javafx.scene.image.Image;

public class BocaNeutra implements Boca {


    public Botin atacar(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, Campo campoEnemigo) {


        return new Botin();


    }


    public Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) {


        return new Botin();


    }

    @Override
    public boolean estaBocaArriba() {
        return false;
    }

    @Override
    public boolean estaBocaAbajo() {
        return false;
    }

    @Override
    public Image imagen(String nombre) {
        return new Image("imagenes/" + nombre + ".jpg");
    }
}
