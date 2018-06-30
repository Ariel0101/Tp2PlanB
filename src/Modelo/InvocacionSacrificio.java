
public class InvocacionSacrificio extends Invocacion{
	
	private int monstruosASacrificar;
	
	InvocacionSacrificio(int estrellasDeCarta) {
		
		if (estrellasDeCarta == 5 || estrellasDeCarta == 6) {
			monstruosASacrificar = 1;
		} else if (estrellasDeCarta > 6) {
			monstruosASacrificar = 2;
		} else {
			monstruosASacrificar = 0;
		}

	}
	
	public void activar(Campo miCampo) {

		miCampo.sacrificar(monstruosASacrificar);

	}

}
