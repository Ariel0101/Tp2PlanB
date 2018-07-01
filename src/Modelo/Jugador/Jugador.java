package Modelo.Jugador;

import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Combate.Atacable;
import Modelo.Combate.Botin;
import javafx.scene.image.Image;

public class Jugador implements Atacable {

    private int vida;
    private String nombre;
    private Partida partida;

    public Jugador(String nombre, int vida, Partida partida) {

        this.vida = vida;
        this.nombre = nombre;
        this.partida = partida;

    }

    public Botin recibirAtaque(CartaMonstruo monstruoAtacante, Campo miCampo) {

        Botin botin = new Botin();
        botin.setDanioAtacado(monstruoAtacante.conCuantosPuntosAtaca());
        botin.infligirDanioAtacado(this);
        if (this.vida <= 0){
            this.perder();
        }
        return new Botin();
    }

    public void recibirDanio(int vidaARestar) {

        this.vida -= vidaARestar;
        if (this.vida <= 0){
            this.perder();
        }
    }

    public int verVida() {
    	
    	return this.vida;
    }

    public void ganar() {
        this.partida.setGanador(this.nombre);
    }

    public void perder() {
        this.partida.setPerdedor(this.nombre);
    }

    public String toString(){
        return this.nombre;
    }

    @Override
    public Image imagen() {

        return new Image("Vista/Imagenes/bocaNeutra.jpg");

    }
}
