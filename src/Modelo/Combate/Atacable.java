package Modelo.Combate;

import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import javafx.scene.image.Image;

public interface Atacable {

    Botin recibirAtaque(CartaMonstruo atacante, Campo miCampo) throws MonstruoNoPuedeAtacarError;

    Image imagen();
}
