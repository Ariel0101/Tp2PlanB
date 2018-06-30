package Modelo.Combate;

import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Jugador.Jugador;

import java.util.LinkedList;

public class Botin {

    private int danioDeAtacado;
    private int danioDeAtacante;
    private LinkedList<Monstruo> muertos = new LinkedList<>();

    public void agregarMuerto(Monstruo m){

        this.muertos.add(m);

    }

    public void setDanioAtacado(int d){

        this.danioDeAtacado = d;

    }

    public void setDanioAtacante(int d){

        this.danioDeAtacante = d;

    }

    public void infligirDanios(Jugador atacante, Jugador atacado) {

        atacado.recibirDanio(this.danioDeAtacado);
        atacante.recibirDanio(this.danioDeAtacante);

    }

    public void infligirDanioAtacado(Jugador atacado) {

        atacado.recibirDanio(this.danioDeAtacado);
    }
    public void ejecutar(Campo c){

        for (Monstruo m : this.muertos){

            c.destruir(m.carta());

        }

    }
}
