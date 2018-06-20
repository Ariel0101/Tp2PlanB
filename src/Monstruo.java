public class Monstruo{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private Efecto efecto;
    private Carta carta;

    Monstruo(int danio, int defensa){

        this.danio = danio;
        this.defensa = defensa;
        this.posicion = new PosDormido();

    }

    Monstruo(int danio, int defensa, Efecto e){

        this.danio = danio;
        this.defensa = defensa;
        this.posicion = new PosDormido();
        this.efecto = e;

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

    private int obtenerPuntos() {

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

    Botin atacar(Monstruo enemigo) {

        this.posicion.atacar();
        Botin botin = new Botin();

        int dif = this.obtenerPuntos() - enemigo.obtenerPuntos();

        if(dif >= 0){

            this.matar(enemigo, botin);
            botin.setDanioAtacado(enemigo.posicion.danioDePersonaje(dif));

        }
        if(dif <= 0){

            enemigo.matar(this, botin);
            botin.setDanioAtacante(this.posicion.danioDePersonaje(dif));

        }

        return botin;

    }

    private void matar(Monstruo enemigo, Botin b) {

        this.posicion.matar(enemigo, b);

    }

    void activarEfecto(){

        this.efecto.activar();
    }

    public Efecto efecto() {

        return this.efecto;

    }

    public Carta carta() {

        return this.carta;

    }
}
