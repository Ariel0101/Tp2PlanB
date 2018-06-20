
public class EfectoAumentarDefensa implements AplicadorEfecto {

	private int aumentoDeDefensa;
	
	EfectoAumentarDefensa (int unAumentoDeDefensa){
		
		this.aumentoDeDefensa = unAumentoDeDefensa;
		
	}
	
	public void activarEn(CartaMonstruo monstruo) {
		
		monstruo.aumentarDefensa(aumentoDeDefensa);
		
	}

}
