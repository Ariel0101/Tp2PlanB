import java.util.Iterator;
import java.util.LinkedList;

public class ListaMonstruos implements Iterable<CartaMonstruo>{

    LinkedList<CartaMonstruo> monstruos;

    ListaMonstruos(){

        this.monstruos = new LinkedList<CartaMonstruo>();
    }

    void agregar(CartaMonstruo monstruo){

        this.monstruos.add(monstruo);

    }

    void eliminar(CartaMonstruo monstruo){

        this.monstruos.remove(monstruo);

    }

    public Iterator<CartaMonstruo> iterator(){

        return this.monstruos.iterator();

    }


    ListaMonstruos monstruosBocaArriba(){

        ListaMonstruos nuevaLista = new ListaMonstruos();

        for (CartaMonstruo m: this.monstruos) {

            if (m.estaBocaArriba()){
                nuevaLista.agregar(m);
            }

        }

        return nuevaLista;

    }

    CartaMonstruo monstruoConMenorAtaque() {

        CartaMonstruo monstruo = this.monstruos.peekFirst();

        for (CartaMonstruo otro : this.monstruos) {

            monstruo = otro.monstruoConMenorAtaque(monstruo);

        }

        return monstruo;
    }

	/*public boolean contiene(int cantidadBuscada, CartaMonstruo monstruoBuscado) {
		
		int contador = 0;
		for(CartaMonstruo monstruo : monstruos) {
			if (monstruo.getClass() == monstruoBuscado.getClass()) contador++;

		}
		if (contador == cantidadBuscada) {
			return true;
		} else {
			return false;
		}
	}*/

	public LinkedList<CartaMonstruo> obtenerTodas(CartaMonstruo monstruoBuscado) {

		LinkedList<CartaMonstruo> listaADevolver = new LinkedList<CartaMonstruo>();
		for(CartaMonstruo monstruo : monstruos) {
			if (monstruo.getClass() == monstruoBuscado.getClass()) {
				listaADevolver.add(monstruo);
			}
		}
		return listaADevolver;
		
	}

}
