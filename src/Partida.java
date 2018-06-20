public class Partida {
    private String ganador;

    Partida(){
        this.ganador = "";
    }

    public String verGanador() {
        return this.ganador;
    }

    public void setGanador(String nombreJugador) {
        this.ganador = nombreJugador;
    }
}
