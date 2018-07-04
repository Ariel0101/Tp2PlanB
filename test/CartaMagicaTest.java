import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.Carta;
import Modelo.CartasMagiaTrampa.AgujeroOscuro;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMagiaTrampa.Fisura;
import Modelo.CartasMagiaTrampa.OllaDeLaCodicia;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import junit.framework.TestCase;

public class CartaMagicaTest extends TestCase {
    public void testCartaMagicaToStringDevuelveElNombreConQueSeinializoCuandoSeCrea(){
        String nombre = "nombre";
        CartaMagica unaCarta = new CartaMagica(nombre, new AgujeroOscuro(new Campo(new Cementerio()), new Campo(new Cementerio())));

        assertEquals(nombre, unaCarta.toString());
    }

    public void testCartaMagicaToStringDevuelveElNombreConQueSeCreaCuandoEstaBocaArriba(){
        String nombre = "nombre";
        CartaMagica unaCarta = new CartaMagica(nombre, new AgujeroOscuro(new Campo(new Cementerio()), new Campo(new Cementerio())));
        unaCarta.colocarBocaArriba();

        assertEquals(nombre, unaCarta.toString());
    }

    public void testCartaMagicaToStringDevuelveELNombreConQueSeCreoCuandoEstaBocaAbajo(){
        String nombre = "nombre";
        CartaMagica unaCarta = new CartaMagica(nombre, new AgujeroOscuro(new Campo(new Cementerio()), new Campo(new Cementerio())));
        unaCarta.colocarBocaAbajo();

        assertEquals(nombre, unaCarta.toString());
    }

    public void testColocarAgujeroOscuroBocaArribaMataATodosLosMonstruosDeTodoElCampo(){

        Cementerio cementerio = new Cementerio();
        Campo campoUno = new Campo(cementerio);
        Campo campoDos = new Campo(cementerio);
        AgujeroOscuro agujero = new AgujeroOscuro(campoUno, campoDos);
        CartaMagica agujeroOscuro = new CartaMagica("",agujero);
        Monstruo a = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo("", a, 4);
        Monstruo m = new Monstruo(300,100);
        CartaMonstruo mokeyMokey = new CartaMonstruo("", m,3);
        campoUno.colocarCarta(aitsu);
        campoDos.colocarCarta(mokeyMokey);
        campoUno.colocarCarta(agujeroOscuro);
        agujeroOscuro.colocarBocaArriba();

        assertTrue(cementerio.esta(aitsu));
        assertTrue(cementerio.esta(mokeyMokey));

    }

    public void testOllaDeLaCodiciaActivarSacaDosCartasDelMazoYlasColocaEnLaMano(){
        Campo unCampo = new Campo(new Cementerio());
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mazo unMazo = new Mazo(unJugador);
        unMazo.agregar(new CartaMonstruo("", new Monstruo(1,1),1));
        unMazo.agregar(new CartaMagica("", new AgujeroOscuro(unCampo, unCampo)));
        Mano unaMano = new Mano(unJugador);
        OllaDeLaCodicia unaOlla = new OllaDeLaCodicia(unaMano, unMazo);
        CartaMagica cartaOlla = new CartaMagica("", unaOlla);
        cartaOlla.colocarBocaAbajo();
        cartaOlla.colocarse(unCampo);
        cartaOlla.colocarBocaArriba();

        assertEquals(2,unaMano.contarCartas(Carta.class));
        assertEquals(0, unMazo.cantidad());

    }

    public void testActivarCartaFisuraDestruyeMonstruoDeMenorAtaqueEnemigoBocaArriba() {

        Cementerio cementerio = new Cementerio();
        Campo unCampo = new Campo(new Cementerio());
        Campo otroCampo = new Campo(cementerio);
        Fisura fisura = new Fisura(otroCampo);
        CartaMagica cartaFisura = new CartaMagica("", fisura);

        Monstruo muchoAtaque = new Monstruo(400, 0);
        Monstruo pocoAtaque = new Monstruo(30, 12);
        Monstruo poquisimoAtaque = new Monstruo(5, 0);
        CartaMonstruo cartaMonstruoUno = new CartaMonstruo("", muchoAtaque, 1);
        CartaMonstruo cartaMonstruoDos = new CartaMonstruo("", pocoAtaque, 2);
        CartaMonstruo cartaMonstruoTres = new CartaMonstruo("", poquisimoAtaque, 2);

        cartaMonstruoUno.colocarse(otroCampo);
        cartaMonstruoDos.colocarse(otroCampo);
        cartaMonstruoTres.colocarse(otroCampo);
        cartaMonstruoUno.colocarBocaArriba();
        cartaMonstruoDos.colocarBocaArriba();
        cartaMonstruoTres.colocarBocaAbajo(); //Fisura no la tiene que contar. Solo mira las boca Arriba

        cartaFisura.colocarse(unCampo);
        cartaFisura.colocarBocaArriba();

        assertFalse(cementerio.esta(cartaMonstruoUno));
        assertTrue(cementerio.esta(cartaMonstruoDos));
        assertFalse(cementerio.esta(cartaMonstruoTres));

    }
}
