package Modelo.CartasMagiaTrampa;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;

public interface Trampa {
    Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin);
}
