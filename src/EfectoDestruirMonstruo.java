import java.util.LinkedList;

class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(){

    }

    public void activarEn(Carta m){

        this.campo.destruir(m);

    }

}