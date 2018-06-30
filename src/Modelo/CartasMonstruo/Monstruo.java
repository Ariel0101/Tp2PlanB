package Modelo.CartasMonstruo;

import Modelo.Combate.Botin;
import Modelo.Estados.PosAtaque;
import Modelo.Estados.PosDefensa;
import Modelo.Estados.PosDormido;
import Modelo.Estados.Posicion;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;

public class Monstruo{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private CartaMonstruo carta = null;
    private int aumentosAtaqueTemporales;

    public Monstruo(int danio, int defensa){

        this.danio = danio;
        this.defensa = defensa;
        this.posicion = new PosDormido();
        this.aumentosAtaqueTemporales = 0;

    }

    void setCarta(CartaMonstruo c){

        this.carta = c;

    }

    public void colocarEnPosAtaque(){

        this.posicion = new PosAtaque();


    }

    public void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }

    public int obtenerPuntos() throws MonstruoNoPuedeAtacarError {
    	
        return this.posicion.obtenerPuntos(this.danio, this.defensa);
    }
    
    public int obtenerPuntosDeAtaque() {
    	
    	return this.danio;
    }
    
    public int obtenerPuntosDeDefensa() {
    	
    	return this.defensa;
    }

    public void aumentarAtaque(int aumento) {

        this.danio += aumento;

    }

    public void aumentarDefensa(int aumento) {

        this.defensa += aumento;

    }

    public Botin atacar(Monstruo enemigo)  {

        this.posicion.atacar();
        return enemigo.recibirAtaque(this);
    }

    public Botin recibirAtaque(Monstruo enemigo) {

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

    private void matar(Monstruo enemigo, Botin b) {

        this.posicion.matar(enemigo, b);

    }

    public CartaMonstruo carta() {

        return this.carta;

    }

    public void agregarAumentoAtaqueTemporal(int aumento) {
        this.aumentosAtaqueTemporales += aumento;
        this.aumentarAtaque(aumento);
    }

    public void desactivarTemporales() {
        this.danio -= this.aumentosAtaqueTemporales;
        this.aumentosAtaqueTemporales= 0;
    }

    public Monstruo MonstruoConMenorAtaqueQue(Monstruo monstruo) {

        if (this.danio < monstruo.danio){

            return this;

        }
        return monstruo;
    }


    public String posicionEnCaracteres() {
        return this.posicion.enCaracteres();
    }
}
