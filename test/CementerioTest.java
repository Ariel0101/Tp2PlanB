import junit.framework.TestCase;

public class CementerioTest extends TestCase {
    public void testCementerioEstaMokeyMokeyEsFalseCuandoCreoCementerio(){
        Cementerio unCementerio = new Cementerio();
        Monstruo unMokey = new Monstruo(1,1,1);

        assertFalse(unCementerio.esta(unMokey));
    }

    public void testCementerioEstaMokeyMokeyEsTrueCuandoEnvioMokeyMokeyAlCementerio(){
        Cementerio unCementerio = new Cementerio();
        Monstruo unMokey = new Monstruo(1,1,1);

        unCementerio.enviar(unMokey);

        assertTrue(unCementerio.esta(unMokey));
    }
}
