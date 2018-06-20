
public class CartaDeCampo extends Carta{

	private EfectoDeCampo efectoDeCampo;
	
	CartaDeCampo(EfectoDeCampo unEfectoDeCampo) {
		
		this.efectoDeCampo = unEfectoDeCampo;
		
	}
	
	public void colocarse(Campo unCampo) {
		
		unCampo.colocarCarta(this);
		
	}

	public void activar() {
		
		efectoDeCampo.activar();
	}

}
