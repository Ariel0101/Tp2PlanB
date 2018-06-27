
public class Fisura implements Magia {

    private final EfectoDestruirElDeMenorAtaque efecto;

    Campo campoOponente;

    Fisura(Campo campoOponente){

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