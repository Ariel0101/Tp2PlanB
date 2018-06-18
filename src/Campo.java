import java.util.LinkedList;

class Campo {

    private LinkedList<Carta> cartas = new LinkedList<>();

    void colocarCarta(Carta c) {

        cartas.add(c);

    }

    void destruirTodas(Cementerio c) {

        for (Carta m : this.cartas){

            m.destruir(c);

        }

    }
}
