import javafx.scene.layout.HBox;

public class Turno {

    private  HBox activados;
    private  HBox desactivados;
    private  HBox refDesactivados;

    Turno(HBox botonesUno, HBox botonesOtro){

        this.activados = botonesUno;
        this.desactivados= botonesOtro;

        this.refDesactivados = botonesOtro;
        this.desactivados.setDisable(true);

    }

    void siguienteTurno(){

        this.desactivados = this.activados;
        this.activados = this.refDesactivados;
        this.refDesactivados = this.desactivados;

        this.activados.setDisable(false);
        this.desactivados.setDisable(true);

    }

}
