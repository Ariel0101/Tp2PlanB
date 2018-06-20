class CartaMonstruo implements Carta{

    private Monstruo monstruo;
    private Boca boca;
    private int estrellas;

    CartaMonstruo(Monstruo m, int estrellas){

        m.setCarta(this);
        this.monstruo = m;
        this.boca = new BocaNeutra();
        this.estrellas = estrellas;

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

    void activarEfecto(){

        this.monstruo.activarEfecto();
    }
    
    public void aumentarAtaque(int aumento) {
    	
    	this.monstruo.aumentarAtaque(aumento);
    }
    
    public void aumentarDefensa(int aumento) {
    	
    	this.monstruo.aumentarDefensa(aumento);
    }
    
    Botin atacar(CartaMonstruo m) {

        return this.boca.pelear(this.monstruo, m.monstruo);

    }

    void destruir(Cementerio c) {

        c.enviar(this);

    }


    public void colocarse(Campo c) {

        this.invocar(c);
        c.colocarCarta(this);

    }

    private void invocar(Campo c) {

    }

}
