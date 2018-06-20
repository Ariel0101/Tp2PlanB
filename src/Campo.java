import java.util.LinkedList;

public class Campo {

    private LinkedList<CartaMonstruo> monstruos;
    private LinkedList<CartaMagica> magicas;
    private LinkedList<CartaTrampa> trampas;
    private Cementerio cementerio;
    private CartaDeCampo cartaDeCampo;
    private Efecto efectoDeCampoPropio;
    private Efecto efectoDeCampoEnemigo;
    private ListaMonstruos listaMonstruos;


    Campo(Cementerio c){

        this.monstruos = new LinkedList<>();
        this.magicas = new LinkedList<>();
        this.trampas = new LinkedList<>();
        this.cementerio = c;
        this.efectoDeCampoPropio = new EfectoNulo();
        this.efectoDeCampoEnemigo = new EfectoNulo();
        this.listaMonstruos = new ListaMonstruos();

    }

    void destruir(Carta unaCarta) {

        this.cementerio.enviar(unaCarta);

    }

    void colocarCarta(CartaMonstruo carta){
    	
    	efectoDeCampoPropio.activar(carta);
    	efectoDeCampoEnemigo.activar(carta);
        this.monstruos.add(carta);
        this.listaMonstruos.agregar(carta);

    }

    void colocarCarta(CartaMagica carta){

        this.magicas.add(carta);

    }


    LinkedList<CartaMonstruo> monstruos() {

        return this.monstruos;

    }

    ListaMonstruos listaMonstruos(){

        return this.listaMonstruos;

    }

    void aplicarEnMonstruos(Efecto efecto){

        efecto.activar(this.listaMonstruos);

    }

	public void colocarCarta(CartaDeCampo unaCartaDeCampo) {
		
		this.cartaDeCampo = unaCartaDeCampo;
		cartaDeCampo.activar();
		
	}


	public void setEfectoDeCampoPropio(Efecto unEfectoDeCampo) {
		
		this.efectoDeCampoPropio = unEfectoDeCampo;
		this.aplicarEnMonstruos(unEfectoDeCampo);

	}

    public void setEfectoDeCampoEnemigo(Efecto unEfectoDeCampo) {

        this.efectoDeCampoEnemigo = unEfectoDeCampo;
        this.aplicarEnMonstruos(unEfectoDeCampo);

    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        this.trampas.add(cartaTrampa);
    }

    public Botin activarTrampa(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) {
        if (this.trampas.size() == 0){
            CartaTrampa unaCartaTrampa = new CartaTrampa(new TrampaNula());
            return unaCartaTrampa.activar(monstruoAtacante, monstruoAtacado, unBotin);
        }
        CartaTrampa unaCartaTrampa = this.trampas.remove();
        this.cementerio.enviar(unaCartaTrampa);
        return unaCartaTrampa.activar(monstruoAtacante, monstruoAtacado, unBotin);

    }
}
