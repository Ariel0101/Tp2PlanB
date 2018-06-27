import javafx.stage.Stage;

public class Jugador {

    private int vida;
    private String nombre;
    private Partida partida;

    Jugador(String nombre, int vida) {
    	
        this.vida = vida;
        this.nombre = nombre;
        this.partida = new Partida();
    }


    Jugador(String nombre, int vida, Partida partida) {

        this.vida = vida;
        this.nombre = nombre;
        this.partida = partida;

    }

    void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;
        if (this.vida <= 0){
            this.perder();
        }

    }



    int verVida() {
    	
    	return this.vida;

    }

    public void ganar() {
        this.partida.setGanador(this.nombre);
    }

    public void perder() {
        this.partida.setPerdedor(this.nombre);
    }
}
