import java.util.ArrayList;

public class Cementerio {

    private ArrayList<Object> cartas;

    public Cementerio(){
        this.cartas = new ArrayList<Object>();
    }

    public boolean esta(Object unaCarta) {
        return this.cartas.contains(unaCarta);
    }

    public void enviar(Object unaCarta) {
        this.cartas.add(unaCarta);
    }
}
