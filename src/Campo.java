import java.util.ArrayList;
import java.util.LinkedList;

public class Campo {

    private LinkedList<CartaMonstruo> monstruos;
    private LinkedList<CartaMagica> magicas;
    private Cementerio cementerio;
    private CartaDeCampo cartaCampo;

    Campo(Cementerio c){

        this.monstruos = new LinkedList<>();
        this.magicas = new LinkedList<>();
        this.cementerio = c;

    }

    void destruir(Carta unaCarta) {

        this.cementerio.enviar(unaCarta);

    }

    void colocarCarta(CartaMonstruo carta){

        this.monstruos.add(carta);

    }

    void colocarCarta(CartaMagica carta){

        this.magicas.add(carta);

    }

    void colocarCarta(CartaDeCampo carta){

        carta.activar();
        this.cartaCampo = carta;

    }

    LinkedList<CartaMonstruo> monstruos() {

        return this.monstruos;

    }

    void agregarEfecto(Aumento aumentoAtaque) {
    }
}
