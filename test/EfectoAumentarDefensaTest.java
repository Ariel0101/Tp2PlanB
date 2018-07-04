import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.Campo.EfectoAumentarDefensa;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Efecto;
import junit.framework.TestCase;

import java.util.List;

public class EfectoAumentarDefensaTest extends TestCase {
    public void testEfectoAumentarDefensaAumentaLaDefensaDeLaCartaMonstruoRecidaEnElAumentoInicializado(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        CartaMonstruo unaCartaMonstruo = new CartaMonstruo(new Monstruo(0,0),1);
        CartaMonstruo unaCartaMonstruoConUnPuntoMasDeDefensa = new CartaMonstruo(new Monstruo(0,0),1);
        CartaMonstruo otraCartaMonstruo = new CartaMonstruo(new Monstruo(100,0),1);
        unaCartaMonstruo.colocarEnPosDefensa();
        unaCartaMonstruo.colocarBocaArriba();
        unaCartaMonstruoConUnPuntoMasDeDefensa.colocarEnPosDefensa();
        unaCartaMonstruoConUnPuntoMasDeDefensa.colocarBocaArriba();
        otraCartaMonstruo.colocarEnPosAtaque();
        otraCartaMonstruo.colocarBocaArriba();

        int aumento = 100;
        Efecto efectoAumentarDefensa = new EfectoAumentarDefensa(aumento);
        efectoAumentarDefensa.activar(unaCartaMonstruo);
        efectoAumentarDefensa.activar(unaCartaMonstruoConUnPuntoMasDeDefensa);

        Botin unBotin = otraCartaMonstruo.atacar(unaCartaMonstruo, unCampo);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(unaCartaMonstruo));
        assertFalse(unCementerio.esta(unaCartaMonstruoConUnPuntoMasDeDefensa));
    }

    public void testEfectoAumentarDefensaAumentaLaDefensaTodasLasCartaMonstruoEnUnaListaMonstruos(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        CartaMonstruo unaCartaMonstruo = new CartaMonstruo(new Monstruo(0,0),1);
        CartaMonstruo unaCartaMonstruoConUnPuntoMasDeDefensa = new CartaMonstruo(new Monstruo(0,0),1);
        CartaMonstruo otraCartaMonstruo = new CartaMonstruo(new Monstruo(100,0),1);
        unaCartaMonstruo.colocarEnPosDefensa();
        unaCartaMonstruo.colocarBocaArriba();
        unaCartaMonstruoConUnPuntoMasDeDefensa.colocarEnPosDefensa();
        unaCartaMonstruoConUnPuntoMasDeDefensa.colocarBocaArriba();
        otraCartaMonstruo.colocarEnPosAtaque();
        otraCartaMonstruo.colocarBocaArriba();
        ListaMonstruos unaListaMonstruos = new ListaMonstruos();
        unaListaMonstruos.agregar(unaCartaMonstruo);
        unaListaMonstruos.agregar(unaCartaMonstruoConUnPuntoMasDeDefensa);

        int aumento = 100;
        Efecto efectoAumentarDefensa = new EfectoAumentarDefensa(aumento);
        efectoAumentarDefensa.activar(unaListaMonstruos);

        Botin unBotin = otraCartaMonstruo.atacar(unaCartaMonstruo, unCampo);
        unBotin.ejecutar(unCampo);

        assertTrue(unCementerio.esta(unaCartaMonstruo));
        assertFalse(unCementerio.esta(unaCartaMonstruoConUnPuntoMasDeDefensa));
    }
}
