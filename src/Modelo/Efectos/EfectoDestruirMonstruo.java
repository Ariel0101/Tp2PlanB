import Cartas.CartaMonstruo;

class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(CartaMonstruo m){

        this.campo.destruir(m);

    }


    public void activar(ListaMonstruos monstruos) { }


}
