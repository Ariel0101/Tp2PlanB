package Modelo.Campo;

public class EfectoSogen extends EfectoDeCampo {

    private int aumentoDeDefensaAMonstruosAmigos = 500;
    private int aumentoDeAtaqueAMonstruosEnemigos = 200;

    public EfectoSogen(Campo unCampo, Campo otroCampo) {
        super(unCampo, otroCampo);
    }

    public void activar() {
        this.activarEfectoEnCampoAmigo();
        this.activarEfectoEnCampoEnemigo();
    }

    private void activarEfectoEnCampoAmigo() {

        campoAmigo.setEfectoDeCampoPropio(new EfectoAumentarDefensa(aumentoDeDefensaAMonstruosAmigos));

    }

    private void activarEfectoEnCampoEnemigo() {

        campoEnemigo.setEfectoDeCampoEnemigo(new EfectoAumentarAtaque(aumentoDeAtaqueAMonstruosEnemigos));

    }
}
