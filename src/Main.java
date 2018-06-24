import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage ventana) throws Exception {

        ventana.setTitle("Al-Go-Oh");

        ventana.show();

        /// prueba:

        Campo campo = new Campo(new Cementerio());
        Mano mano = new Mano(new Jugador("1", 2));
        Mazo mazo = new Mazo("1", new Partida());
        Monstruo m = new Monstruo(1,1);
        CartaMonstruo monstruo = new CartaMonstruo(m,1);
        mano.agregar(monstruo);

        Button cuantosCampo = new Button("Hay alguien en el campo?");
        cuantosCampo.setOnAction(e -> {

        if(campo.esta(monstruo)){
            System.out.print("si");
        }
        else {System.out.print("no");}}
        );



        Button boton = new Button("colocar una carta");
        BotonColocarMonstruo botonM = new BotonColocarMonstruo(campo, mano);
        boton.setOnAction(botonM);

        HBox contenedorHorizontal = new HBox(boton, cuantosCampo);
        contenedorHorizontal.setSpacing(8);

        VBox contenedorPrincipal = new VBox(contenedorHorizontal);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setPadding(new Insets(20));

        Scene scene = new Scene(contenedorPrincipal, 500, 550);

        ventana.setScene(scene);

        ventana.show();





    }
}