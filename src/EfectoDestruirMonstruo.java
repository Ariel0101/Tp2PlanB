import java.util.Collection;

class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(){

    }

    public void activarEn(Carta monstruo) {

    }

    public void activar(Monstruo m){

        this.campo.destruir(m.carta());

    }

    public void activarEn(Mano unaMano) {

    }


    public void activar(Collection<Monstruo> monstruos) {

    }

}
