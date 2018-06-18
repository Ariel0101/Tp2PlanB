import java.util.LinkedList;

class Botin {

    private int danioDeAtacado;
    private int danioDeAtacante;
    private LinkedList<Monstruo> muertos = new LinkedList<>();

    void agregarMuerto(Monstruo m ){

        this.muertos.add(m);

    }

    void setDanioAtacado(int d){

        this.danioDeAtacado = d;

    }

    void setDanioAtacante(int d){

        this.danioDeAtacante = d;

    }

    void infligirDanios(Jugador atacante, Jugador atacado) {

        atacado.recibirAtaque(this.danioDeAtacado);
        atacante.recibirAtaque(this.danioDeAtacante);

    }

    void ejecutar(Cementerio c){

        for (Monstruo m : this.muertos){

            c.enviar(m);

        }

    }
}
