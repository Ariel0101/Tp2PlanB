import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Turno {

    private final Button boton1;
    private final Button boton2;
    private  HBox activados;
    private  HBox desactivados;
    private  HBox refDesactivados;

    Turno(HBox botonesUno, HBox botonesOtro, Button boton1, Button boton2){

        this.activados = botonesUno;
        this.desactivados= botonesOtro;

        this.refDesactivados = botonesOtro;
        this.desactivados.setDisable(true);

        this.boton1 = boton1;
        this.boton2 = boton2;

    }

    void siguienteTurno(){

        this.desactivados = this.activados;
        this.activados = this.refDesactivados;
        this.refDesactivados = this.desactivados;

        this.activados.setDisable(false);
        this.desactivados.setDisable(true);

        this.boton1.setDisable(false);
        this.boton2.setDisable(false);

    }

}
