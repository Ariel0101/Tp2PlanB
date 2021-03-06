package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Efecto;

public class EfectoDestruirElDeMenorAtaque implements Efecto {

    Campo campo;

    EfectoDestruirElDeMenorAtaque(Campo campo) {

        this.campo = campo;
    }

    public void activar(ListaMonstruos monstruos) {

        ListaMonstruos monstruosBocaArriba = monstruos.monstruosBocaArriba();
        CartaMonstruo monstruoConMenorAtaque = monstruosBocaArriba.monstruoConMenorAtaque();
        this.campo.destruir(monstruoConMenorAtaque);

    }

    @Override
    public void activar(CartaMonstruo carta) { }
}
