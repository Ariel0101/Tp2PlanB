import javafx.scene.image.Image;

class CartaMonstruo implements Carta, Atacable {

    protected Monstruo monstruo;
    protected Boca boca;
    private int estrellas;
    protected Invocacion invocacion;
    String nombre;

    CartaMonstruo(Monstruo monstruo, int estrellas){

        monstruo.setCarta(this);
        this.monstruo = monstruo;
        this.boca = new BocaNeutra();
        this.estrellas = estrellas;
        this.invocacion = new InvocacionSacrificio(estrellas);
        this.nombre = "sin-nombre";
    }

    void colocarEnPosAtaque() {

        this.monstruo.colocarEnPosAtaque();

    }

    void colocarEnPosDefensa() {

        this.monstruo.colocarEnPosDefensa();

    }

    public void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    public void colocarBocaArriba() {

        this.boca = new BocaArriba();

    }

    Botin atacar(Atacable cartaAtacada, Campo campoEnemigo) throws MonstruoNoPuedeAtacarError {

        return this.boca.atacar(this, cartaAtacada, campoEnemigo);

    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError {
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }
    
    public void aumentarAtaque(int aumento) {
    	
    	this.monstruo.aumentarAtaque(aumento);
    }
    
    public void aumentarDefensa(int aumento) {
    	
    	this.monstruo.aumentarDefensa(aumento);
    }


    void destruir(Cementerio c) {

        c.enviar(this);

    }

    public void colocarse(Mano unaMano) {
        unaMano.agregar(this);
    }


    private void invocar(Campo miCampo) { 	
    	invocacion.activar(miCampo);

    }

    public boolean estaBocaArriba() {

        return this.boca.estaBocaArriba();

    }

    public CartaMonstruo monstruoConMenorAtaque(CartaMonstruo otra) {

        Monstruo m = this.monstruo.MonstruoConMenorAtaqueQue(otra.monstruo);

        if (m == this.monstruo){

            return this;

        }

        return otra;


    }

    public void desactivarTemporales() {
        this.monstruo.desactivarTemporales();
    }

    public void colocarse(Campo c) {
    	
    	this.invocar(c);
        c.agregarMonstruo(this);

    }

    public int conCuantosPuntosAtaca() {
        return monstruo.obtenerPuntos();
    }

    public void ponerNombre(String nombre){

        this.nombre = nombre;

    }

    @Override
    public String toString(){

        return this.nombre;

    }

    @Override
    public Image imagen() {

        return this.boca.imagen(this.nombre);
    }

}
