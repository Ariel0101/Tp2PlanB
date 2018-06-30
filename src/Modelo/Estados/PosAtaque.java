package Modelo.Estados;

import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;

public class PosAtaque implements Posicion {

    public int obtenerPuntos(int danio, int defensa){

        return danio;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return Math.abs(resultadoDeBatalla);

    }

    public void matar(Monstruo enemigo, Botin b) {

        b.agregarMuerto(enemigo);

    }

    public void atacar() {

    }

    @Override
    public String enCaracteres() {
        return "Ataque";
    }

}