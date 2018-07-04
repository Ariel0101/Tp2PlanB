package Modelo.Campo;

import Modelo.Carta;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaNeutra;
import Modelo.Jugador.Mano;
import javafx.scene.image.Image;

public class CartaDeCampo implements Carta {

    private Boca boca;
    protected EfectoDeCampo efectoDeCampo;
	private String nombre;

	public CartaDeCampo(String nombre, EfectoDeCampo unEfectoDeCampo) {

		this.nombre = nombre;
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


    public void colocarBocaAbajo() { }

    public void colocarBocaArriba() { }

    public Image imagen() {
        
		return this.boca.imagen(this.nombre, "");
		
    }

	public String toString(){
	    return this.nombre;
    }
}
