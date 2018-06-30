package Modelo.Campo;

public class EfectoWasteland extends EfectoDeCampo {
	
	private int aumentoDeAtaqueAMonstruosAmigos = 200;
	private int aumentoDeDefensaAMonstruosEnemigos = 300;
	
	public EfectoWasteland(Campo campoAmigo, Campo campoEnemigo) {
		
		super(campoAmigo, campoEnemigo);
		
	}
	
	public void activar() {
		
		this.activarEfectoEnCampoAmigo();
		this.activarEfectoEnCampoEnemigo();
		
	}
	
	private void activarEfectoEnCampoAmigo() {
		
		campoAmigo.setEfectoDeCampoPropio(new EfectoAumentarAtaque(aumentoDeAtaqueAMonstruosAmigos));

	}
	
	private void activarEfectoEnCampoEnemigo() {
		
		campoEnemigo.setEfectoDeCampoEnemigo(new EfectoAumentarDefensa(aumentoDeDefensaAMonstruosEnemigos));
		
	}
	
}
