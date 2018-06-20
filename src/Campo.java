import java.util.ArrayList;
import java.util.LinkedList;

public class Campo {

    private LinkedList<CartaMonstruo> monstruos;
    private LinkedList<CartaMagica> magicas;
    private Cementerio cementerio;
    private CartaDeCampo cartaDeCampo;
    private AplicadorEfecto efectoDeCampo;
    
    Campo(Cementerio c){

        this.monstruos = new LinkedList<>();
        this.magicas = new LinkedList<>();
        this.cementerio = c;
        this.efectoDeCampo = new EfectoNulo();

    }

    void destruir(Carta unaCarta) {

        this.cementerio.enviar(unaCarta);

    }

    void colocarCarta(CartaMonstruo carta){
    	
    	efectoDeCampo.activarEn(carta);
        this.monstruos.add(carta);

    }

    void colocarCarta(CartaMagica carta){

        this.magicas.add(carta);

    }

    LinkedList<CartaMonstruo> monstruos() {

        return this.monstruos;

    }

	public void colocarCarta(CartaDeCampo unaCartaDeCampo) {
		
		this.cartaDeCampo = unaCartaDeCampo;
		cartaDeCampo.activar();
		
	}


	private void aplicarEnTodosLosMonstruos(AplicadorEfecto unEfecto) {
		
		for(CartaMonstruo monstruo: monstruos){
			unEfecto.activarEn(monstruo);
		}		
		
	}

	public void setEfectoDeCampo(AplicadorEfecto unEfectoDeCampo) {
		
		this.efectoDeCampo = unEfectoDeCampo;
		this.aplicarEnTodosLosMonstruos(efectoDeCampo);

		
	}

}
