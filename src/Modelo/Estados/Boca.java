package Modelo.Estados;

import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Atacable;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import javafx.scene.image.Image;

public interface Boca {

    Botin atacar(CartaMonstruo cartaAtacante, Atacable cartaAtacada, Campo campoEnemigo) throws MonstruoNoPuedeAtacarError;

    Botin recibirAtaque(CartaMonstruo miCarta, Monstruo monstruoAtacado, Monstruo monstruoAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError;

    boolean estaBocaArriba();

    boolean estaBocaAbajo();

    Image imagen(String nombre, String posicion);

    String verNombre(String nombre);
}
