import Cartas.Carta;
import Excepciones.NoHayCartasError;

import java.util.LinkedList;

public class Mazo {
    private final Jugador jugador;
    private LinkedList<Carta> cartas;

    Mazo(Jugador miJugador){
        this.jugador = miJugador;
        this.cartas = new LinkedList<Carta>();
    }

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int cantidad() {
        return this.cartas.size();
    }

    public Carta sacar() {
        if (this.cartas.size() == 0){
            throw new NoHayCartasError();
        }
        Carta unaCarta = this.cartas.remove();
        if (this.cartas.size() == 0){
            this.jugador.perder();
        }
        return unaCarta;

    }
}
