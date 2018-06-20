import java.util.Collection;

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

    public void activarEn(Carta unaCarta) {

        this.campo.destruir(unaCarta);

    }

    public void activar(Monstruo m){

    }


    public void activar(ListaMonstruos monstruos) {

        for (CartaMonstruo m: monstruos){

            this.activar(m);
        }

    }

    @Override
    public void activar() {

    }

    public void activarEn(CartaMonstruo carta) {

    }

}
