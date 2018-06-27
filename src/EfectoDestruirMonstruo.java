import java.util.Collection;
import java.util.Iterator;

class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(CartaMonstruo m){

        this.campo.destruir(m);

    }

    public void activar(Mano unaMano) {
    }


    public void activar(Monstruo m){

    }


    public void activar(ListaMonstruos monstruos) {

    }

    @Override
    public void activar() {

    }

    public void activarEn(CartaMonstruo carta) {

    }

}
