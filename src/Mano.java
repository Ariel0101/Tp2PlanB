import java.util.LinkedList;

public class Mano {
    private final String nombreJugador;
    private final Partida partida;
    private LinkedList<Carta> cartas;

    Mano(String nombreJugador, Partida unaPartida){
        this.nombreJugador = nombreJugador;
        this.partida = unaPartida;
        this.cartas = new LinkedList<Carta>();
    }

    public int cantidad() {
        return this.cartas.size();
    }

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public void armarExodia() {
        int contadorPartesExodia = 0;
        for (int i = 0; i<this.cartas.size(); i++){
            Carta unaCarta = this.cartas.get(i);
            if (unaCarta instanceof CartaMonstruoExodia){
                contadorPartesExodia += 1;
            }
        }
        if (contadorPartesExodia == 5){
            this.partida.setGanador(this.nombreJugador);
        }
    }
}
