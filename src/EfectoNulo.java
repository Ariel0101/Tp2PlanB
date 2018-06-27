
public class EfectoNulo implements Efecto {

	public void activar(CartaMonstruo carta) { }


	public void activar(ListaMonstruos monstruos){

		for (CartaMonstruo m: monstruos){

			this.activar(m);

		}

	}

}
