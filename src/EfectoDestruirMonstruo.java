import java.util.Collection;

class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(CartaMonstruo m){

        this.campo.destruir(m);

    }

    public void activarEn(Mano unaMano) {

    }


    public void activar(ListaMonstruos monstruos) {

        for (CartaMonstruo m: monstruos){

            this.activar(m);
        }

    }

}
