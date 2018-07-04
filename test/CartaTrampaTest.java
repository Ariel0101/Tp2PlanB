import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMagiaTrampa.*;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Jugador.Jugador;
import junit.framework.TestCase;

public class CartaTrampaTest extends TestCase {
    public void testCartaTrampaToStringDevuelveElNombreConQueSeinializoCuandoSeCrea(){
        String nombre = "nombre";
        CartaTrampa unaCarta = new CartaTrampa(nombre, new TrampaNula());

        assertEquals(nombre, unaCarta.toString());
    }

    public void testCartaTrampaToStringDevuelveElNombreConQueSeCreaCuandoEstaBocaArriba(){
        String nombre = "nombre";
        CartaTrampa unaCarta = new CartaTrampa(nombre, new TrampaNula());
        unaCarta.colocarBocaArriba();

        assertEquals(nombre, unaCarta.toString());
    }

    public void testCartaTrampaToStringDevuelveELNombreConQueSeCreoCuandoEstaBocaAbajo(){
        String nombre = "nombre";
        CartaTrampa unaCarta = new CartaTrampa(nombre, new TrampaNula());
        unaCarta.colocarBocaAbajo();

        assertEquals(nombre, unaCarta.toString());
    }

    public void testCartaTrampaCilindroMagicoNiegaElAtaqueDelOponenteYLoReflejaTotalmenteSobreElJugadorEnemigo() {
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000, new Partida());
        Jugador jugadorDos = new Jugador("2",1000, new Partida());
        Monstruo mokeyMokey = new Monstruo(300,100);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo("", mokeyMokey,3);
        CartaMonstruo cartaAitsu = new CartaMonstruo("", aitsu,4);
        Trampa cilindroMagico = new CilindroMagico();
        CartaTrampa cartaCilindroMagico = new CartaTrampa("",cilindroMagico);
        cartaMokeyMokey.colocarEnPosAtaque();
        cartaMokeyMokey.colocarBocaArriba();
        cartaMokeyMokey.colocarse(campoUno);
        cartaAitsu.colocarEnPosAtaque();
        cartaAitsu.colocarBocaArriba();
        cartaAitsu.colocarse(campoDos);

        cartaCilindroMagico.colocarse(campoDos);
        Botin unBotin = cartaMokeyMokey.atacar(cartaAitsu, campoDos);
        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);
        unBotin.infligirDanios(jugadorUno,jugadorDos);

        assertEquals(1000-300, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
        assertTrue(unCementerio.esta(cartaCilindroMagico));
        assertFalse(unCementerio.esta(cartaMokeyMokey));
        assertFalse(unCementerio.esta(cartaAitsu));

    }

    public void testCartaTrampaRefuerzosAumentaElAtaqueDelMonstruoAtacadoEn100HastaElFinalDelTurno() {
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000, new Partida());
        Jugador jugadorDos = new Jugador("2",1000, new Partida());

        Monstruo alasDeLlamaPerversa = new Monstruo(700,600);
        CartaMonstruo cartaAlasDeLlamaPerversa = new CartaMonstruo("", alasDeLlamaPerversa,4);
        cartaAlasDeLlamaPerversa.colocarEnPosAtaque();
        cartaAlasDeLlamaPerversa.colocarBocaArriba();
        cartaAlasDeLlamaPerversa.colocarse(campoDos);

        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo("", mokeyMokey,3);
        cartaMokeyMokey.colocarEnPosAtaque();
        cartaMokeyMokey.colocarBocaArriba();
        cartaMokeyMokey.colocarse(campoUno);

        Trampa refuerzos = new Refuerzos();
        CartaTrampa cartaRefuerzos = new CartaTrampa("", refuerzos);
        cartaRefuerzos.colocarse(campoDos);

        Botin unBotin = cartaAlasDeLlamaPerversa.atacar(cartaMokeyMokey, campoDos);
        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);
        unBotin.infligirDanios(jugadorUno,jugadorDos);

        assertEquals(1000-100, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
        assertTrue(unCementerio.esta(cartaRefuerzos));
        assertFalse(unCementerio.esta(cartaMokeyMokey));
        assertTrue(unCementerio.esta(cartaAlasDeLlamaPerversa));
    }
}
