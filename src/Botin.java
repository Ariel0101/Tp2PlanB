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

        atacado.restarVida(this.danioDeAtacado);
        atacante.restarVida(this.danioDeAtacante);

    }

    void atacarJugador(Jugador atacado) {

        atacado.restarVida(this.danioDeAtacado);
    }
    void ejecutar(Campo c){

        for (Monstruo m : this.muertos){

            c.destruir(m.carta());

        }

    }
}
