package Modelo.CartasMonstruo;

import Modelo.Campo.Campo;

public class InvocacionFusion implements Invocacion {

	private CartaMonstruo cartaMonstruoAFusionar;
	private int cantidadAFusionar;
	
	public InvocacionFusion(CartaMonstruo unaCartaMonstruo, int cantidadDeCartas) {
		
		cartaMonstruoAFusionar = unaCartaMonstruo;
		cantidadAFusionar = cantidadDeCartas;
	}

	public void activar(Campo unCampo) {
		unCampo.fusionar(cartaMonstruoAFusionar, cantidadAFusionar);
	}

}
