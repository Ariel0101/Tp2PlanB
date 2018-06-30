package Cartas;

import javafx.scene.image.Image;

public class CartaDeCampo implements Carta {

    private final BocaNeutra boca;
    private EfectoDeCampo efectoDeCampo;
	private String nombre;

	CartaDeCampo(EfectoDeCampo unEfectoDeCampo) {
		
		this.efectoDeCampo = unEfectoDeCampo;
		this.boca = new BocaNeutra();
		
	}


	public void colocarse(Mano unaMano) {
		unaMano.agregar(this);
	}

	public void colocarse(Campo unCampo) {
		
		unCampo.colocarCarta(this);

	}

	public void activar() {
		
		efectoDeCampo.activar();
	}


    public void colocarBocaAbajo() {

    }

    public void colocarBocaArriba() {
    }

    @Override
    public Image imagen() {
        
		return this.boca.imagen(this.nombre, "");
		
    }

	@Override
	public void ponerNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString(){
	    return this.nombre;
    }
}
