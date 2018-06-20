import junit.framework.TestCase;

public class MazoTest extends TestCase {
    public void testMazoSacarLevantaErrorCuandoNoQuedanMasCartas(){
        Mazo unMazo = new Mazo("", new Partida());
        boolean lanzoError = false;
        try {
            unMazo.sacar();
        } catch (NoHayCartasError e){
            lanzoError = true;
        }
        assertTrue(lanzoError);
    }

    public void testMazoCantidadEsCeroAlCrearse(){
        Mazo unMazo = new Mazo("",new Partida());

        assertEquals(0, unMazo.cantidad());
    }

    public void testMazoCantidadEs4CuandoAgrego4Cartas(){
        Mazo unMazo = new Mazo("", new Partida());
        CartaMonstruo cartaMonstruo = new CartaMonstruo(new Monstruo(1,1),2);
        CartaMagica cartaMagica = new CartaMagica(new MagiaNula());
        CartaTrampa cartaTrampa = new CartaTrampa(new TrampaNula());
        CartaDeCampo cartaDeCampo = new CartaDeCampo(new EfectoDeCampoNulo(new Campo(), new Campo()));
        unMazo.agregar(cartaMonstruo);
        unMazo.agregar(cartaMagica);
        unMazo.agregar(cartaTrampa);
        unMazo.agregar(cartaDeCampo);

        assertEquals(4, unMazo.cantidad());
    }

    public void testMazoSacarUltimaCartaSeteaEnPartidaAlPerdedor(){
        Partida unaPartida = new Partida();
        Mazo unMazo = new Mazo("Jugador 1", unaPartida);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        unMazo.agregar(cartaAitsu);
        unMazo.sacar();

        assertEquals("Jugador 1", unaPartida.verPerdedor());

    }
}
