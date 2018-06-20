public class Partida {
    private String ganador;
    private String perdedor;

    Partida(){
        this.perdedor = "";
        this.ganador = "";
    }

    public String verGanador() {

        return this.ganador;

    }

    public void setGanador(String nombreJugador) {

        this.ganador = nombreJugador;

    }

    public String verPerdedor() {

        return this.perdedor;

    }

    public void setPerdedor(String nombreJugador) {

        this.perdedor = nombreJugador;

    }
}
