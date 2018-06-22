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

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int contarCartas(Class unTipo) {
        int cantidad = 0;
        for (int i = 0; i<this.cartas.size(); i++){
            Carta cadaCarta = this.cartas.get(i);
            if (unTipo.isAssignableFrom(cadaCarta.getClass())) {
                cantidad += 1;
            }
        }
        return cantidad;
    }

    public void ganar() {
        Class claseExodia = CartaMonstruoExodia.class;
        int cantidadDePartesDeExodia = this.contarCartas(claseExodia);
        if (cantidadDePartesDeExodia == 5){
            this.partida.setGanador(this.nombreJugador);
        }
    }
}
