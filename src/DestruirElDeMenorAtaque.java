public class DestruirElDeMenorAtaque implements Efecto{

    Campo campo;

    DestruirElDeMenorAtaque(Campo campo) {

        this.campo = campo;
    }


    public void activarEn(Mano unaMano) {

    }

    public void activar(ListaMonstruos monstruos) {

        ListaMonstruos monstruosBocaArriba = monstruos.monstruosBocaArriba();
        CartaMonstruo monstruoConMenorAtaque = monstruosBocaArriba.monstruoConMenorAtaque();
        this.campo.destruir(monstruoConMenorAtaque);

    }
}
