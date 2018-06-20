
public class EfectoAumentarAtaque implements AplicadorEfecto {
	
	private int aumentoDeAtaque;
	
	EfectoAumentarAtaque (int unAumentoDeAtaque){
		
		this.aumentoDeAtaque = unAumentoDeAtaque;
		
	}
	
	public void activarEn(CartaMonstruo monstruo) {
		
		monstruo.aumentarAtaque(aumentoDeAtaque);
		
	}

}
