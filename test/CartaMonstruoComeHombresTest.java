import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.CartaMonstruoComeHombres;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import junit.framework.TestCase;

public class CartaMonstruoComeHombresTest extends TestCase {
    public void testCartaMonstruoComeHombresBocaAbajoColocarBocaArribaDestruyeLaCartaSeleccionada(){
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Monstruo insecto = new Monstruo(450,600);
        CartaMonstruoComeHombres cartaInsectoComeHombres = new CartaMonstruoComeHombres(insecto,4, campoUno);
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        cartaInsectoComeHombres.seleccionar(cartaMokey);
        cartaMokey.colocarBocaArriba();
        cartaMokey.colocarEnPosAtaque();
        cartaMokey.colocarse(campoUno);
        cartaInsectoComeHombres.colocarBocaAbajo();
        cartaInsectoComeHombres.colocarEnPosDefensa();
        cartaInsectoComeHombres.colocarse(campoDos);

        cartaInsectoComeHombres.colocarBocaArriba();

        assertTrue(unCementerio.esta(cartaMokey));
    }

    public void testCartaMonstruoComeHombresColocarBocaArribaNoDestruyeLaCartaSeleccionadaSiNoEstabaPrimeroBocaAbajo(){
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Monstruo insecto = new Monstruo(450,600);
        CartaMonstruoComeHombres cartaInsectoComeHombres = new CartaMonstruoComeHombres(insecto,4,campoUno);
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        cartaInsectoComeHombres.seleccionar(cartaMokey);
        cartaMokey.colocarBocaArriba();
        cartaMokey.colocarEnPosAtaque();
        cartaMokey.colocarse(campoUno);
        cartaInsectoComeHombres.colocarBocaArriba();
        cartaInsectoComeHombres.colocarEnPosDefensa();
        cartaInsectoComeHombres.colocarse(campoDos);

        assertFalse(unCementerio.esta(cartaMokey));
    }

    public void testInsectoComeHombreEsAtacadoBocaAbajoPorOtroMonstruoElPrimeroSeVolteaDestruyendoAlSegundo() throws MonstruoNoPuedeAtacarError {
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);

        Monstruo alasDeLlamaPerversa = new Monstruo(700, 1000);
        Monstruo insectoComeHombres = new Monstruo(450,600);

        CartaMonstruo cartaAlasDeLLama = new CartaMonstruo(alasDeLlamaPerversa,1);
        CartaMonstruoComeHombres cartaComeHombres = new CartaMonstruoComeHombres(insectoComeHombres,2, campoUno);

        cartaAlasDeLLama.colocarBocaArriba();
        cartaAlasDeLLama.colocarEnPosAtaque();
        cartaComeHombres.colocarBocaAbajo();
        cartaComeHombres.colocarEnPosDefensa();

        campoUno.colocarCarta(cartaAlasDeLLama);
        campoDos.colocarCarta(cartaComeHombres);

        Botin unBotin = cartaAlasDeLLama.atacar(cartaComeHombres, campoDos);

        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);

        assertFalse(unCementerio.esta(cartaComeHombres));
        assertTrue(unCementerio.esta(cartaAlasDeLLama));
    }
}
