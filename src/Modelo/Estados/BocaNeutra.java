package Modelo.Estados;

import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Atacable;
import Modelo.Combate.Botin;
import javafx.scene.image.Image;

public class BocaNeutra implements Boca {


    public Botin atacar(CartaMonstruo cartaAtacante, Atacable cartaAtacada, Campo campoEnemigo) {

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
    public Image imagen(String nombre, String posicion) {
        return new Image("Vista/imagenes/" + nombre + posicion +".jpg");

    }

    @Override
    public String verNombre(String nombre) {
        return nombre;
    }

}
