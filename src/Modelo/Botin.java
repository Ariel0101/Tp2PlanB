import java.util.LinkedList;

public class Botin {

    private int danioDeAtacado;
    private int danioDeAtacante;
    private LinkedList<Monstruo> muertos = new LinkedList<>();

    void agregarMuerto(Monstruo m ){

        this.muertos.add(m);

    }

    protected void setDanioAtacado(int d){

        this.danioDeAtacado = d;

    }

    void setDanioAtacante(int d){

        this.danioDeAtacante = d;

    }

    void infligirDanios(Jugador atacante, Jugador atacado) {

        atacado.recibirDanio(this.danioDeAtacado);
        atacante.recibirDanio(this.danioDeAtacante);

    }

    protected void infligirDanioAtacado(Jugador atacado) {

        atacado.recibirDanio(this.danioDeAtacado);
    }
    void ejecutar(Campo c){

        for (Monstruo m : this.muertos){

            c.destruir(m.carta());

        }

    }
}
