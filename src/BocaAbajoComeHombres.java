import javafx.scene.image.Image;

public class BocaAbajoComeHombres implements Boca {

    public Botin atacar(CartaMonstruo cartaMonstruo, CartaMonstruo cartaM, Campo campoEnemigo) {
        return new Botin();
    }

    public Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) {
        miCarta.colocarBocaArriba();
        return new Botin();
    }

    public boolean estaBocaArriba() {
        return false;
    }

    @Override
    public boolean estaBocaAbajo() {
        return true;
    }

    @Override
    public Image imagen(String nombre, String posicion) {

        return new Image("imagenes/bocaAbajo " + posicion + ".jpg");
    }

    @Override
    public String verNombre(String nombre) {
        return "?";
    }
}
