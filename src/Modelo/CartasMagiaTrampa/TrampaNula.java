package Modelo.CartasMagiaTrampa;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;

public class TrampaNula implements Trampa {

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) {
        return unBotin;
    }
}
