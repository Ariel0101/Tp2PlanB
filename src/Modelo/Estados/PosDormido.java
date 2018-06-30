package Modelo.Estados;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;

public class PosDormido implements Posicion {

    public int obtenerPuntos(int danio, int defensa) throws MonstruoNoPuedeAtacarError {

        throw new MonstruoNoPuedeAtacarError();

    }

    public int danioDePersonaje(int dif) {

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) throws MonstruoNoPuedeAtacarError {

        throw new MonstruoNoPuedeAtacarError();

    }

    public void atacar() throws MonstruoNoPuedeAtacarError {

        throw new MonstruoNoPuedeAtacarError();

    }

    @Override
    public String enCaracteres() {
        return "Dormido";
    }

}
