package Modelo.Campo;

import Modelo.Carta;
import Modelo.CartasMagiaTrampa.Magia;
import Modelo.CartasMonstruo.Monstruo;

import java.util.ArrayList;

public class Cementerio {

    private ArrayList<Carta> cartas;
    private ArrayList<Monstruo> monstruos;
    private ArrayList<Magia> magicas;

    public Cementerio(){

        this.cartas = new ArrayList<>();
        this.monstruos = new ArrayList<Monstruo>();
        this.magicas = new ArrayList<Magia>();
    }

    public boolean esta(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    public void enviar(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }

    public void enviar(Monstruo m) {

        this.monstruos.add(m);

    }

    void enviar(Magia m) {

        this.magicas.add(m);

    }

    public boolean esta(Monstruo otro) {

        return this.monstruos.contains(otro);

    }

    public boolean esta(Magia carta) {
        return this.magicas.contains(carta);
    }
}
