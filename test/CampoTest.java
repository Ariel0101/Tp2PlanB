import Controlador.ConstructorDeCartas;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMagiaTrampa.AgujeroOscuro;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMagiaTrampa.CartaTrampa;
import Modelo.CartasMagiaTrampa.TrampaNula;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import junit.framework.TestCase;

public class CampoTest extends TestCase {
    public void testCampoEstaCartaEsTrueCuandoDichaCartaFueColocadaEnCampo(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Campo unCampo = new Campo(new Cementerio());

        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso();
        unCampo.colocarCarta(mokeyMokey);

        assertTrue(unCampo.esta(mokeyMokey));
        assertFalse(unCampo.esta(goblinFalso));
    }

    public void testCampoDestruirCartaEnviaDichaCartaAlCementarioYSiEsQueFueColocadaEnElCampoLaEliminaDelMismo(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);

        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso();
        CartaTrampa refuerzos = constructorDeCartas.refuerzos();
        CartaMagica agujeroOscuro = constructorDeCartas.agujeroOscuro(unCampo, unCampo);

        unCampo.colocarCarta(refuerzos);
        unCampo.colocarCarta(mokeyMokey);
        unCampo.colocarCarta(agujeroOscuro);

        unCampo.destruir(mokeyMokey);
        unCampo.destruir(refuerzos);
        unCampo.destruir(goblinFalso);
        unCampo.destruir(agujeroOscuro);

        assertFalse(unCampo.esta(mokeyMokey));
        assertTrue(unCementerio.esta(mokeyMokey));
        assertTrue(unCementerio.esta(goblinFalso));
        assertTrue(unCementerio.esta(refuerzos));
        assertTrue(unCementerio.esta(agujeroOscuro));
    }
}
