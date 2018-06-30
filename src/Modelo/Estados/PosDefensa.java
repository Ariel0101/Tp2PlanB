package Modelo.Estados;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;

public class PosDefensa implements Posicion {

    public int obtenerPuntos(int danio, int defensa){

        return defensa;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return 0;

    }

    public void matar(Monstruo enemigo, Botin b) {
    }

    public void atacar() throws MonstruoNoPuedeAtacarError {

        throw new MonstruoNoPuedeAtacarError();

    }

    @Override
    public String enCaracteres() {
        return "Defensa";
    }
}
