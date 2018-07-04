import Modelo.Campo.EfectoAumentarAtaque;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Efecto;
import junit.framework.TestCase;

public class EfectoAumentarAtaqueTest extends TestCase {
    public void testEfectoAumentarAtaqueAumentaElAtaqueDeLaCartaMonstruoRecidaEnElAumentoInicializado(){
        CartaMonstruo unaCartaMonstruo = new CartaMonstruo("", new Monstruo(0,0),1);
        unaCartaMonstruo.colocarEnPosAtaque();
        unaCartaMonstruo.colocarBocaArriba();

        int aumento = 100;
        Efecto efectoAumentarAtaque = new EfectoAumentarAtaque(aumento);
        efectoAumentarAtaque.activar(unaCartaMonstruo);

        assertEquals(aumento, unaCartaMonstruo.conCuantosPuntosAtaca());
    }

    public void testEfectoAumentarAtaqueAumentaElAtaqueDeTodosLosMonstruosEnLaListaMonstruosRecibida(){
        CartaMonstruo unaCartaMonstruo = new CartaMonstruo("", new Monstruo(0,0),1);
        CartaMonstruo otraCartaMonstruo = new CartaMonstruo("", new Monstruo(0,0),1);
        unaCartaMonstruo.colocarEnPosAtaque();
        unaCartaMonstruo.colocarBocaArriba();
        otraCartaMonstruo.colocarEnPosAtaque();
        otraCartaMonstruo.colocarBocaArriba();
        ListaMonstruos unaListaMonstruos = new ListaMonstruos();
        unaListaMonstruos.agregar(unaCartaMonstruo);
        unaListaMonstruos.agregar(otraCartaMonstruo);

        int aumento = 100;
        Efecto efectoAumentarAtaque = new EfectoAumentarAtaque(aumento);
        efectoAumentarAtaque.activar(unaListaMonstruos);

        assertEquals(aumento, unaCartaMonstruo.conCuantosPuntosAtaca());
        assertEquals(aumento, otraCartaMonstruo.conCuantosPuntosAtaca());
    }
}
