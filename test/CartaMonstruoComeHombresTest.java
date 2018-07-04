import Controlador.ConstructorDeCartas;
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
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        CartaMonstruoComeHombres cartaInsectoComeHombres = constructorDeCartas.insectoComeHombres(campoUno);
        CartaMonstruo cartaMokey = constructorDeCartas.mokeyMokey();
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
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        CartaMonstruoComeHombres cartaInsectoComeHombres = constructorDeCartas.insectoComeHombres(campoUno);
        CartaMonstruo cartaMokey = constructorDeCartas.mokeyMokey();
        cartaInsectoComeHombres.seleccionar(cartaMokey);
        cartaMokey.colocarBocaArriba();
        cartaMokey.colocarEnPosAtaque();
        cartaMokey.colocarse(campoUno);
        cartaInsectoComeHombres.colocarBocaArriba();
        cartaInsectoComeHombres.colocarEnPosDefensa();
        cartaInsectoComeHombres.colocarse(campoDos);

        assertFalse(unCementerio.esta(cartaMokey));
    }

    public void testInsectoComeHombreEsAtacadoBocaAbajoPorOtroMonstruoElPrimeroSeVolteaDestruyendoAlSegundo() {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);

        Monstruo alasDeLlamaPerversa = new Monstruo(700, 1000);
        Monstruo insectoComeHombres = new Monstruo(450,600);

        CartaMonstruo cartaAlasDeLLama = constructorDeCartas.alasDeLlamaPerversa();
        CartaMonstruoComeHombres cartaComeHombres = constructorDeCartas.insectoComeHombres(campoUno);

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
