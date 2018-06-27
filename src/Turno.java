import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.Iterator;
import java.util.LinkedList;

public class Turno {

    private final Button boton1;
    private final Button boton2;
    private final LinkedList<Reiniciable> botonesAReiniciar;
    private  HBox activados;
    private  HBox desactivados;
    private  HBox refDesactivados;

    Turno(HBox botonesUno, HBox botonesOtro, Button boton1, Button boton2, LinkedList<Reiniciable> botonesAReiniciar){

        this.activados = botonesUno;
        this.desactivados= botonesOtro;

        this.refDesactivados = botonesOtro;
        this.desactivados.setDisable(true);

        this.boton1 = boton1;
        this.boton2 = boton2;

        this.botonesAReiniciar = botonesAReiniciar;
    }

    void siguienteTurno(){

        this.desactivados = this.activados;
        this.activados = this.refDesactivados;
        this.refDesactivados = this.desactivados;

        this.activados.setDisable(false);
        this.desactivados.setDisable(true);

        this.boton1.setDisable(false);
        this.boton2.setDisable(false);

        Iterator<Reiniciable> iteradorBotonesReiniciar = this.botonesAReiniciar.iterator();
        while(iteradorBotonesReiniciar.hasNext()){
            Reiniciable boton = iteradorBotonesReiniciar.next();
            boton.reiniciar();
        }

    }

}
