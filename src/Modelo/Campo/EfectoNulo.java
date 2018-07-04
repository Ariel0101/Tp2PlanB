package Modelo.Campo;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Efecto;

public class EfectoNulo implements Efecto {

	public void activar(CartaMonstruo carta) { }


	public void activar(ListaMonstruos monstruos){

		for (CartaMonstruo m: monstruos){

			this.activar(m);

		}

	}

}
