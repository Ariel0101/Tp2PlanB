public class Monstruo{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private Carta carta = new NoCarta();
    private int aumentosTemporales;

    Monstruo(int danio, int defensa){

        this.danio = danio;
        this.defensa = defensa;
        this.posicion = new PosDormido();
        this.aumentosTemporales = 0;

    }

    void setCarta(Carta c){

        this.carta = c;

    }

    void colocarEnPosAtaque(){

        this.posicion = new PosAtaque();


    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }

    private int obtenerPuntos() throws MonstruoNoPuedeAtacarError {
    	
        return this.posicion.obtenerPuntos(this.danio, this.defensa);
    }
    
    int obtenerPuntosDeAtaque() {
    	
    	return this.danio;
    }
    
    int obtenerPuntosDeDefensa() {
    	
    	return this.defensa;
    }

    void aumentarAtaque(int aumento) {

        this.danio += aumento;

    }

    void aumentarDefensa(int aumento) {

        this.defensa += aumento;

    }

    Botin atacar(Monstruo enemigo) throws MonstruoNoPuedeAtacarError {

        this.posicion.atacar();
        return enemigo.recibirAtaque(this);
    }

    public Botin recibirAtaque(Monstruo enemigo) throws MonstruoNoPuedeAtacarError{

        Botin botin = new Botin();

        int dif = this.obtenerPuntos() - enemigo.obtenerPuntos();

        if(dif >= 0){

            this.matar(enemigo, botin);
            botin.setDanioAtacante(enemigo.posicion.danioDePersonaje(dif));

        }
        if(dif <= 0){

            enemigo.matar(this, botin);
            botin.setDanioAtacado(this.posicion.danioDePersonaje(dif));

        }

        return botin;

    }

    private void matar(Monstruo enemigo, Botin b) throws MonstruoNoPuedeAtacarError {

        this.posicion.matar(enemigo, b);

    }

    public Carta carta() {

        return this.carta;

    }

    public void agregarAumentoTemporal(int aumento) {
        this.aumentosTemporales += aumento;
        this.aumentarAtaque(aumento);
    }

    public Monstruo MonstruoConMenorAtaqueQue(Monstruo monstruo) {

        if (this.danio < monstruo.danio){

            return this;

        }
        return monstruo;
    }

    public void desactivarTemporales() {
        this.danio -= this.aumentosTemporales;
        this.aumentosTemporales = 0;
    }
}
