import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
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

    public void testCampoDestruirCartaEnviaDichaCartaAlCementarioYSiEsQueFueColocadaEnElCampoLaEliminaDelMismo(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);

        CartaMonstruo mokeyMokey = new CartaMonstruo(new Monstruo(300,100),3);
        CartaMonstruo goblinFalso = new CartaMonstruo(new Monstruo(400,400),1);
        unCampo.colocarCarta(mokeyMokey);

        unCampo.destruir(mokeyMokey);

        assertFalse(unCampo.esta(mokeyMokey));
        assertTrue(unCementerio.esta(mokeyMokey));

        unCampo.destruir(goblinFalso);

        assertTrue(unCementerio.esta(goblinFalso));
    }
}
