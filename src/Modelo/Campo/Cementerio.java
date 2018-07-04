package Modelo.Campo;

import Modelo.Carta;
import Modelo.CartasMagiaTrampa.Magia;
import Modelo.CartasMonstruo.Monstruo;

import java.util.ArrayList;

public class Cementerio {

    private ArrayList<Carta> cartas;

    public Cementerio(){

        this.cartas = new ArrayList<>();

    }

    public boolean esta(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    public void enviar(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }
}
