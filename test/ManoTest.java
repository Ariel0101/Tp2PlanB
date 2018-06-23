import junit.framework.TestCase;

public class ManoTest extends TestCase {
    public void testManoContarCartasDevuelveLaCantidadDeCartasAgregadasALaManoDelTipoRecibido(){
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        CartaMonstruoExodia cartaCabeza = new CartaMonstruoExodia(cabezaExodia,3);
        CartaMonstruoExodia cartaBrazoDerecho = new CartaMonstruoExodia(brazoDerechoExodia,3);
        CartaMonstruoExodia cartaBrazoIzquierdo = new CartaMonstruoExodia(brazoIzquierdoExodia,3);
        CartaMonstruoExodia cartaPiernaDerecha = new CartaMonstruoExodia(piernaDerechaExodia,3);
        CartaMonstruoExodia cartaPiernaIzquierda = new CartaMonstruoExodia(piernaIzquierdaExodia,3);
        cartaCabeza.colocarse(unaMano);
        cartaBrazoDerecho.colocarse(unaMano);
        cartaBrazoIzquierdo.colocarse(unaMano);
        cartaPiernaDerecha.colocarse(unaMano);
        cartaPiernaIzquierda.colocarse(unaMano);
        CartaMonstruo cartaAitsu = new CartaMonstruo(new Monstruo(100,100),5);
        cartaAitsu.colocarse(unaMano);

        int cantidadCartasMonstruo = unaMano.contarCartas(cartaAitsu.getClass());
        int cantidadCartasMonstruoExodia = unaMano.contarCartas(cartaCabeza.getClass());

        assertEquals(6, cantidadCartasMonstruo);
        assertEquals(5, cantidadCartasMonstruoExodia);
    }

    public void testManoGanarSeteaASuJugadorComoGanadorEnPartidaCuandoTodasLasPartesDeExodiaEstanEnLaMano(){
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        CartaMonstruoExodia cartaCabeza = new CartaMonstruoExodia(cabezaExodia,3);
        CartaMonstruoExodia cartaBrazoDerecho = new CartaMonstruoExodia(brazoDerechoExodia,3);
        CartaMonstruoExodia cartaBrazoIzquierdo = new CartaMonstruoExodia(brazoIzquierdoExodia,3);
        CartaMonstruoExodia cartaPiernaDerecha = new CartaMonstruoExodia(piernaDerechaExodia,3);
        CartaMonstruoExodia cartaPiernaIzquierda = new CartaMonstruoExodia(piernaIzquierdaExodia,3);
        cartaCabeza.colocarse(unaMano);
        cartaBrazoDerecho.colocarse(unaMano);
        cartaBrazoIzquierdo.colocarse(unaMano);
        cartaPiernaDerecha.colocarse(unaMano);
        cartaPiernaIzquierda.colocarse(unaMano);

        unaMano.ganar();

        assertEquals(nombreJugador, unaPartida.verGanador());
    }
    public void testManoGanarNoHaceNadaCuandoNoTodasLasPartesDeExodiaEstanEnLaMano(){
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);

        unaMano.ganar();

        assertEquals("", unaPartida.verGanador());
    }

    public void testManoAgregarLas5PartesDeExodiaHaceGanarAlJugadorDeLaMano(){
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        CartaMonstruoExodia cartaCabeza = new CartaMonstruoExodia(cabezaExodia,3);
        CartaMonstruoExodia cartaBrazoDerecho = new CartaMonstruoExodia(brazoDerechoExodia,3);
        CartaMonstruoExodia cartaBrazoIzquierdo = new CartaMonstruoExodia(brazoIzquierdoExodia,3);
        CartaMonstruoExodia cartaPiernaDerecha = new CartaMonstruoExodia(piernaDerechaExodia,3);
        CartaMonstruoExodia cartaPiernaIzquierda = new CartaMonstruoExodia(piernaIzquierdaExodia,3);
        cartaCabeza.colocarse(unaMano);
        cartaBrazoDerecho.colocarse(unaMano);
        cartaBrazoIzquierdo.colocarse(unaMano);
        cartaPiernaDerecha.colocarse(unaMano);
        cartaPiernaIzquierda.colocarse(unaMano);

        assertEquals("Jugador 1",unaPartida.verGanador());

    }
}
