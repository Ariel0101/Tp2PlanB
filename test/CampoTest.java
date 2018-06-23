import junit.framework.TestCase;

public class CampoTest extends TestCase {
    public void testCampoEstaCartaEsTrueCuandoDichaCartaFueColocadaEnCampo(){
        Campo unCampo = new Campo(new Cementerio());

        CartaMonstruo mokeyMokey = new CartaMonstruo(new Monstruo(300,100),3);
        CartaMonstruo goblinFalso = new CartaMonstruo(new Monstruo(400,400),1);
        unCampo.colocarCarta(mokeyMokey);

        assertTrue(unCampo.esta(mokeyMokey));
        assertFalse(unCampo.esta(goblinFalso));
    }
}
