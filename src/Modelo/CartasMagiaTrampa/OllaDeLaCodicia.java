package Modelo.CartasMagiaTrampa;

import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;

public class OllaDeLaCodicia implements Magia {
    private final Mano mano;
    private final Mazo mazo;

    public OllaDeLaCodicia(Mano unaMano, Mazo unMazo) {
        this.mano = unaMano;
        this.mazo = unMazo;
    }

    public void activar() {
        int cartasASacar = 2;
        for (int i=0; i<cartasASacar; i++){
            this.mano.agregar(this.mazo.sacar());
        }
    }
}
