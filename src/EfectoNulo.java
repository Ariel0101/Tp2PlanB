
public class EfectoNulo implements Efecto {

	public void activarEn(CartaMonstruo carta) {

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
