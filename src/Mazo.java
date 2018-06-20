import java.util.LinkedList;

public class Mazo {
    private final String nombreJugador;
    private final Partida partida;
    private LinkedList<Carta> cartas;

    Mazo(String nombreJugador, Partida unaPartida){
        this.nombreJugador = nombreJugador;
        this.partida = unaPartida;
        this.cartas = new LinkedList<Carta>();
    }

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int cantidad() {
        return this.cartas.size();
    }

    public Carta sacar() {
        Carta unaCarta = this.cartas.remove();
        if (this.cartas.size() == 0){
            this.partida.setPerdedor(this.nombreJugador);
        }
        return unaCarta;

    }
}
