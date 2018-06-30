package Modelo.CartasMagiaTrampa;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;

public class CilindroMagico implements Trampa {

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) {
        Botin nuevoBotin = new Botin();
        nuevoBotin.setDanioAtacante(monstruoAtacante.obtenerPuntosDeAtaque());
        return nuevoBotin;
    }
}
