
public class EfectoAumentarDefensa implements Efecto {

	private int aumentoDeDefensa;
	
	EfectoAumentarDefensa (int unAumentoDeDefensa){
		
		this.aumentoDeDefensa = unAumentoDeDefensa;
		
	}
	
	public void activar(CartaMonstruo monstruo) {
		
		monstruo.aumentarDefensa(aumentoDeDefensa);
		
	}


	public void activar(ListaMonstruos monstruos){

		for (CartaMonstruo m: monstruos){

			this.activar(m);

		}

	}

}
