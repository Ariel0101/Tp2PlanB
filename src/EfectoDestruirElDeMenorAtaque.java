public class EfectoDestruirElDeMenorAtaque implements Efecto{

    Campo campo;

    EfectoDestruirElDeMenorAtaque(Campo campo) {

        this.campo = campo;
    }


    public void activar(Mano unaMano) {

    }

    public void activar(ListaMonstruos monstruos) {

        ListaMonstruos monstruosBocaArriba = monstruos.monstruosBocaArriba();
        CartaMonstruo monstruoConMenorAtaque = monstruosBocaArriba.monstruoConMenorAtaque();
        this.campo.destruir(monstruoConMenorAtaque);

    }

    @Override
    public void activar() {

    }

    @Override
    public void activar(CartaMonstruo carta) {

    }
}
