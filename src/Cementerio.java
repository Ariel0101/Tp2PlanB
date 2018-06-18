import java.util.ArrayList;

public class Cementerio {

    private ArrayList<Carta> cartas;

    public Cementerio(){

        this.cartas = new ArrayList<>();

    }

    boolean esta(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    void enviar(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }
}
