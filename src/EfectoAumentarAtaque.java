
public class EfectoAumentarAtaque implements Efecto {
	
	private int aumentoDeAtaque;
	
	EfectoAumentarAtaque (int unAumentoDeAtaque){
		
		this.aumentoDeAtaque = unAumentoDeAtaque;
		
	}
	
	public void activar(CartaMonstruo monstruo) {
		
		monstruo.aumentarAtaque(aumentoDeAtaque);
		
	}


	@Override
	public void activar(Mano unaMano) {

	}

	public void activar(ListaMonstruos monstruos){

		for (CartaMonstruo m: monstruos){

			this.activar(m);

		}

	}

	@Override
	public void activar() {

	}
}
