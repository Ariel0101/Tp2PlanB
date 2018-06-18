import java.util.ArrayList;
import java.util.LinkedList;

public class Campo {

    private LinkedList<Carta> cartas;
    private Cementerio cementerio;

    public Campo(Cementerio unCementerio){
        this.cementerio = unCementerio;
        this.cartas = new LinkedList<Carta>();
    }

    public Campo() {

        this.cementerio = new Cementerio();
        this.cartas = new LinkedList<Carta>();

    }

    public boolean esta(Object unaCarta) {
        return this.cartas.contains(unaCarta);
    }


    public void destruir(Object unaCarta) {

        this.cementerio.enviar(unaCarta);
    }

    void colocarCarta(Carta carta){

        this.cartas.add(carta);
    }

}
