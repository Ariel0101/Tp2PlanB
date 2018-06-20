public class CartaDeCampo implements Carta {

	private EfectoDeCampo efectoDeCampo;
	
	CartaDeCampo(EfectoDeCampo unEfectoDeCampo) {
		
		this.efectoDeCampo = unEfectoDeCampo;
		
	}


	public void colocarse(Mano unaMano) {
		unaMano.agregar(this);
	}

	public void colocarse(Campo unCampo) {
		
		unCampo.colocarCarta(this);
		
	}

	public void activar() {
		
		efectoDeCampo.activar();
	}


    public void colocarBocaAbajo() {

    }

    public void colocarBocaArriba() {

    }
}
