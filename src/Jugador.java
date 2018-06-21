
public class Jugador {

    private int vida;
    private String nombre;

    Jugador(String nombre, int vida) {
    	
        this.vida = vida;
        this.nombre = nombre;
        
    }

    void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;

    }

    int verVida() {
    	
    	return this.vida;

    }

}
