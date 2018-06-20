
public class EfectoAumentarDefensa implements Efecto {

	private int aumentoDeDefensa;
	
	EfectoAumentarDefensa (int unAumentoDeDefensa){
		
		this.aumentoDeDefensa = unAumentoDeDefensa;
		
	}
	
	public void activar(CartaMonstruo monstruo) {
		
		monstruo.aumentarDefensa(aumentoDeDefensa);
		
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
