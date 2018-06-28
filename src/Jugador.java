import Excepciones.NoSePuedeAtacarAJugadorError;

public class Jugador implements Atacable{

    private int vida;
    private String nombre;
    private Partida partida;
    private int vidaMaxima;

    Jugador(String nombre, int vida) {
    	
        this.vidaMaxima = vida;
        this.vida = vida;
        this.nombre = nombre;
        this.partida = new Partida();
    }


    Jugador(String nombre, int vida, Partida partida) {

        this.vidaMaxima = vida;
        this.vida = vida;
        this.nombre = nombre;
        this.partida = partida;

    }

    public Botin recibirAtaque(CartaMonstruo monstruoAtacante, Campo miCampo) throws NoSePuedeAtacarAJugadorError {

        if (miCampo.noHayMonstruos() == false) {
            throw new NoSePuedeAtacarAJugadorError();
        }
        Botin botin = new Botin();
        botin.setDanioAtacado(monstruoAtacante.conCuantosPuntosAtaca());
        botin.atacarJugador(this);
        if (this.vida <= 0){
            this.perder();
        }
        return botin;
    }

    void restarVida(int vidaARestar) {

        this.vida -= vidaARestar;
    }

    int verVida() {
    	
    	return this.vida;
    }

    public String toString(){

        return (this.nombre);

    }

    public void ganar() {
        this.partida.setGanador(this.nombre);
    }

    public void perder() {
        this.partida.setPerdedor(this.nombre);
    }

    public int verVidaMaxima() {
        return vidaMaxima;
    }
}
