import java.util.LinkedList;

public class Mazo {
    private LinkedList<Carta> cartas;

    Mazo(){
        this.cartas = new LinkedList<Carta>();
    }

    public void agregar(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int cantidad() {
        return this.cartas.size();
    }

    public Carta sacar() {
        return this.cartas.remove();
    }
}
