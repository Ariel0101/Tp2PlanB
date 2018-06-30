package Modelo.Campo;

import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Efecto;

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

    public int cantidad(){
        return this.monstruos.size();
    }


    public ListaMonstruos monstruosBocaArriba(){

        ListaMonstruos nuevaLista = new ListaMonstruos();

        for (CartaMonstruo m: this.monstruos) {

            if (m.estaBocaArriba()){
                nuevaLista.agregar(m);
            }

        }

        return nuevaLista;

    }

    public CartaMonstruo monstruoConMenorAtaque() {

        CartaMonstruo monstruo = this.monstruos.peekFirst();

        for (CartaMonstruo otro : this.monstruos) {

            monstruo = otro.monstruoConMenorAtaque(monstruo);

        }

        return monstruo;
    }

	public LinkedList<CartaMonstruo> obtenerTodas(CartaMonstruo monstruoBuscado) {

		LinkedList<CartaMonstruo> listaADevolver = new LinkedList<CartaMonstruo>();
		for(CartaMonstruo monstruo : monstruos) {
			if (monstruo.getClass() == monstruoBuscado.getClass()) {
				listaADevolver.add(monstruo);
			}
		}
		return listaADevolver;
		
	}

    public boolean esta(CartaMonstruo unaCartaMonstruo) {

        return this.monstruos.contains(unaCartaMonstruo);

    }

    public void aplicar(Efecto efecto) {
        LinkedList<CartaMonstruo> copiaMonstruos = new LinkedList<>();

        for(CartaMonstruo c : this.monstruos){

            copiaMonstruos.add(c);

        }

        for(CartaMonstruo c : copiaMonstruos){

            efecto.activar(c);

        }

    }

    public boolean estaVacia() {

        return monstruos.isEmpty();
    }
}
