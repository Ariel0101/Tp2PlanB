package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.Efecto;

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
