import Excepciones.MonstruoNoPuedeAtacarError;
import javafx.scene.image.Image;

public class BocaAbajo implements Boca {

    public Botin atacar(CartaMonstruo cartaAtacante, Atacable cartaAtacada, Campo campoEnemigo){

        return new Botin();

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacada, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError {
        cartaAtacada.colocarBocaArriba();
        Botin unBotin = monstruoAtacante.atacar(monstruoAtacado);
        unBotin = miCampo.activarTrampa(monstruoAtacante, monstruoAtacado, unBotin);
        return unBotin;
    }

    @Override
    public boolean estaBocaArriba() {
        return false;
    }

    @Override
    public boolean estaBocaAbajo() {
        return true;
    }

    @Override
    public Image imagen(String nombre, String posicion) {

        return new Image("imagenes/bocaAbajo" + posicion + ".jpg");
    }

    @Override
    public String verNombre(String nombre) {
        return "?";
    }


}
