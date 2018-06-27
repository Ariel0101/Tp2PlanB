import junit.framework.TestCase;

public class BocaArribaTest extends TestCase {
    public void testBocaArribaAtacarDevuelveBotinConResultadoDeLaBatalla(){
        Cementerio unCementerio = new Cementerio();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        cartaMokey.colocarEnPosAtaque();

        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblin = new CartaMonstruo(goblinFalso,3);
        cartaGoblin.colocarEnPosAtaque();

        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        cartaMokey.colocarse(campoAmigo);
        cartaGoblin.colocarse(campoEnemigo);
        Boca bocaArriba = new BocaArriba();

        Botin botinVacio = bocaArriba.recibirAtaque(cartaMokey, mokeyMokey,goblinFalso, campoAmigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertFalse(campoAmigo.esta(cartaMokey));
        assertTrue(unCementerio.esta(cartaMokey));
        assertTrue(campoEnemigo.esta(cartaGoblin));
    }

    public void testBocaArribaRecibirAtaqueDevuelveBotinConResultadoDeLaBatalla(){
        Cementerio unCementerio = new Cementerio();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        cartaMokey.colocarEnPosAtaque();

        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblin = new CartaMonstruo(goblinFalso,3);
        cartaGoblin.colocarEnPosAtaque();

        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        cartaMokey.colocarse(campoAmigo);
        cartaGoblin.colocarse(campoEnemigo);
        Boca bocaArriba = new BocaArriba();

        Botin botinVacio = bocaArriba.recibirAtaque(cartaMokey, mokeyMokey,goblinFalso, campoAmigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertFalse(campoAmigo.esta(cartaMokey));
        assertTrue(unCementerio.esta(cartaMokey));
        assertTrue(campoEnemigo.esta(cartaGoblin));
    }

    public void testBocaArribaEstaBocaArribaDevuelveTrue(){
        Boca bocaArriba = new BocaArriba();

        assertTrue(bocaArriba.estaBocaArriba());
    }

    public void testBocaArribaEstaBocaAbajoDevuelveFalse(){
        Boca bocaArriba = new BocaArriba();


        assertFalse(bocaArriba.estaBocaAbajo());
    }

}