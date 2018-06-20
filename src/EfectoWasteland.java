public class EfectoWasteland extends EfectoDeCampo {
	
	private int aumentoDeAtaqueAMonstruosAmigos = 200;
	private int aumentoDeDefensaAMonstruosEnemigos = 300;
	
	EfectoWasteland (Campo campoAmigo, Campo campoEnemigo) {
		
		super(campoAmigo, campoEnemigo);
		
	}
	
	public void activar() {
		
		this.activarEfectoEnCampoAmigo();
		this.activarEfectoEnCampoEnemigo();
		
	}
	
	private void activarEfectoEnCampoAmigo() {
		
		campoAmigo.setEfectoDeCampo(new EfectoAumentarAtaque(aumentoDeAtaqueAMonstruosAmigos));

	}
	
	private void activarEfectoEnCampoEnemigo() {
		
		campoEnemigo.setEfectoDeCampo(new EfectoAumentarDefensa(aumentoDeDefensaAMonstruosEnemigos));
		
	}
	
}
