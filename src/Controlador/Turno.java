package Controlador;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.Iterator;
import java.util.LinkedList;

public class Turno {

    private final LinkedList<Reiniciable> aReiniciar;
    private final LinkedList<Button> botonesAHablitar;
    private  HBox activados;
    private  HBox desactivados;
    private  HBox refDesactivados;

    Turno(HBox botonesUno, HBox botonesOtro, LinkedList<Button> botonesAHabilitarAlTerminarElTurno, LinkedList<Reiniciable> reiniciablesAlTerminarTurno){

        this.activados = botonesUno;
        this.desactivados= botonesOtro;

        this.refDesactivados = botonesOtro;
        this.desactivados.setDisable(true);

        this.botonesAHablitar = botonesAHabilitarAlTerminarElTurno;
        this.aReiniciar = reiniciablesAlTerminarTurno;
    }

    void siguienteTurno(){

        this.desactivados = this.activados;
        this.activados = this.refDesactivados;
        this.refDesactivados = this.desactivados;

        this.activados.setDisable(false);
        this.desactivados.setDisable(true);

        Iterator<Button> iteratorBotones = this.botonesAHablitar.iterator();
        while (iteratorBotones.hasNext()){
            Button boton = iteratorBotones.next();
            boton.setDisable(false);
        }

        Iterator<Reiniciable> iteradorBotonesReiniciar = this.aReiniciar.iterator();
        while(iteradorBotonesReiniciar.hasNext()){
            Reiniciable boton = iteradorBotonesReiniciar.next();
            boton.reiniciar();
        }

    }

}
