package Modelo.Jugador;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.CartasMonstruo.CartaMonstruoExodia;

import java.util.LinkedList;

public class Mano {
    private final Jugador jugador;
    private LinkedList<Carta> cartas;

    public Mano(Jugador miJugador){
        this.jugador = miJugador;
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
            this.jugador.ganar();
        }
    }

    public LinkedList<Carta> cartas(){

        return this.cartas;

    }

    public void colocar(Carta unaCarta, Campo unCampo) {
        unaCarta.colocarse(unCampo);
        this.cartas.remove(unaCarta);
    }
}
