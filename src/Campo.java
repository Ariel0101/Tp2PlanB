import java.util.ArrayList;
import java.util.LinkedList;

public class Campo {

    private LinkedList<Carta> cartas;
    private Cementerio cementerio;

    Campo(Cementerio c){

        this.cementerio = c;

    }

    void destruir(Carta unaCarta) {

        this.cementerio.enviar(unaCarta);

    }

    void colocarCarta(Carta carta){

        this.cartas.add(carta);

    }

    void destruirTodas() {

        for (Carta c : this.cartas){

            this.destruir(c);

        }

    }
}
