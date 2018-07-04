package Modelo.Jugador;

import Modelo.Carta;
import Modelo.Excepciones.NoHayCartasError;

import java.util.LinkedList;

public class Mazo {
    private final Jugador jugador;
    private LinkedList<Carta> cartas;

    public Mazo(Jugador miJugador){
        this.jugador = miJugador;
        this.cartas = new LinkedList<Carta>();
    }

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int cantidad() {
        return this.cartas.size();
    }

    public void sacar(Mano unaMano) {
        if (this.cartas.size() == 0){
            throw new NoHayCartasError();
        }
        Carta unaCarta = this.cartas.remove();
        if (this.cartas.size() == 0){
            this.jugador.perder();
        }
        unaCarta.colocarse(unaMano);

    }
}
