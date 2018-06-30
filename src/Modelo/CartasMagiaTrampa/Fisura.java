package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;
import Modelo.Campo.ListaMonstruos;

public class Fisura implements Magia {

    private final EfectoDestruirElDeMenorAtaque efecto;

    Campo campoOponente;

    public Fisura(Campo campoOponente){

        this.campoOponente = campoOponente;
        this.efecto = new EfectoDestruirElDeMenorAtaque(campoOponente);

    }

    @Override
    public void activar() {

        ListaMonstruos monstruos = this.campoOponente.listaMonstruos();
        this.efecto.activar(monstruos);

        /*
        this.campoOponente.aplicarEnMonstruos(this.efecto);
        */
    }


}