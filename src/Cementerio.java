import java.util.ArrayList;

public class Cementerio {

    private ArrayList<Carta> cartas;
    private ArrayList<Monstruo> monstruos;
    private ArrayList<Magica> magicas;

    public Cementerio(){

        this.cartas = new ArrayList<>();
        this.monstruos = new ArrayList<Monstruo>();
        this.magicas = new ArrayList<Magica>();
    }

    boolean esta(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    void enviar(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }

    void enviar(Monstruo m) {

        this.monstruos.add(m);

    }

    void enviar(Magica m) {

        this.magicas.add(m);

    }

    public boolean esta(Monstruo otro) {

        return this.monstruos.contains(otro);

    }

    public boolean esta(Magica carta) {
        return this.magicas.contains(carta);
    }
}
