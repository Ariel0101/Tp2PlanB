
public class EfectoAumentarDefensa implements Efecto {

	private int aumentoDeDefensa;
	
	EfectoAumentarDefensa (int unAumentoDeDefensa){
		
		this.aumentoDeDefensa = unAumentoDeDefensa;
		
	}
	
	public void activarEn(CartaMonstruo monstruo) {
		
		monstruo.aumentarDefensa(aumentoDeDefensa);
		
	}

	public void activarEn(Carta monstruo) {

	}

	@Override
	public void activarEn(Mano unaMano) {

	}

	public void activar(ListaMonstruos monstruos){

		for (CartaMonstruo m: monstruos){

			this.activarEn(m);

		}

	}

}