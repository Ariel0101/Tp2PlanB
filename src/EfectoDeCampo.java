
public abstract class EfectoDeCampo {
	
	protected Campo campoAmigo;
	protected Campo campoEnemigo;

	EfectoDeCampo (Campo unCampo, Campo otroCampo) {
		
		this.campoAmigo = unCampo;
		this.campoEnemigo = otroCampo;
		
	}
	
	public abstract void activar();
	
}
