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
        //Constructor de Cartas
        ConstructorDeCartas unConstructor = new ConstructorDeCartas();
        CartaMonstruo aitsu2 = unConstructor.aitsu();
        aitsu2.colocarEnPosAtaque();
        aitsu2.colocarBocaArriba();
        CartaMonstruo mokey = unConstructor.mokeyMokey();
        mokey.colocarEnPosAtaque();
        mokey.colocarBocaArriba();
        //Partida
        Partida unaPartida = new Partida();
        //Enemigo
        Campo campoEnemigo = new Campo(new Cementerio());
        Jugador jugadorEnemigo = new Jugador("J-Amigo",8000,unaPartida);
        mokey.colocarse(campoEnemigo);

        //Amigo
        Campo campoAmigo = new Campo(new Cementerio());
        Jugador jugadorAmigo = new Jugador("J-Enemigo",8000,unaPartida);
        aitsu2.colocarse(campoAmigo);

        //Boton atacar
        BotonElegirMonstruo botonElegirMonstruoAtacante = new BotonElegirMonstruo(campoAmigo, "Elegir monstruo atacante :");
        Button botonElegirMonstruoAtacanteWrapper = new Button("Elegir Monstruo Atacante");
        botonElegirMonstruoAtacanteWrapper.setOnAction(botonElegirMonstruoAtacante);

        BotonElegirMonstruo botonElegirMonstruoAtacado = new BotonElegirMonstruo(campoEnemigo, "Elegir monstruo atacado :");
        Button botonElegirMonstruoAtacadoWrapper = new Button("Elegir Monstruo Atacado");
        botonElegirMonstruoAtacadoWrapper.setOnAction(botonElegirMonstruoAtacado);

        BotonAtacar botonAtacar = new BotonAtacar(jugadorAmigo,campoAmigo,botonElegirMonstruoAtacante, jugadorEnemigo, campoEnemigo, botonElegirMonstruoAtacado);
        Button botonAtacarWrapper = new Button("Atacar");
        botonAtacarWrapper.setOnAction(botonAtacar);

        //Campo de Batalla
        CampoMonstruosHBox campoMonstruosHBoxAmigo = new CampoMonstruosHBox(campoAmigo);
        campoMonstruosHBoxAmigo.setPadding(new Insets(10, 12, 44, 12));
        campoMonstruosHBoxAmigo.setSpacing(10);
        campoMonstruosHBoxAmigo.actualizar();
        campoMonstruosHBoxAmigo.setStyle("-fx-background-color: #336699;");
        CampoMonstruosHBox campoMonstruosHBoxEnemigo = new CampoMonstruosHBox(campoEnemigo);
        campoMonstruosHBoxEnemigo.setPadding(new Insets(10, 12, 44, 12));
        campoMonstruosHBoxEnemigo.setSpacing(10);
        campoMonstruosHBoxEnemigo.setStyle("-fx-background-color: #336699;");
        campoMonstruosHBoxEnemigo.actualizar();

        HBox campoEnemigoMasBotonElegirAtacadoHBox = new HBox(campoMonstruosHBoxEnemigo, botonElegirMonstruoAtacadoWrapper);
        campoEnemigoMasBotonElegirAtacadoHBox.setPadding(new Insets(10, 12, 44, 12));
        campoEnemigoMasBotonElegirAtacadoHBox.setSpacing(10);
        HBox campoEnemigoMasBotonElegirAtacanteHBox = new HBox(campoMonstruosHBoxAmigo, botonElegirMonstruoAtacanteWrapper);
        campoEnemigoMasBotonElegirAtacanteHBox.setPadding(new Insets(10, 12, 44, 12));
        campoEnemigoMasBotonElegirAtacanteHBox.setSpacing(10);
        VBox campoDeBatalaVBox = new VBox(campoEnemigoMasBotonElegirAtacadoHBox, campoEnemigoMasBotonElegirAtacanteHBox, botonAtacarWrapper );

        Scene escenaDeBatalla = new Scene(campoDeBatalaVBox, 500,550);


        //Boton cambiar a Escena Campo de Batalla
        Button botonAPelear = new Button("A Pelear !!!");
        botonAPelear.setOnAction(actionEvent -> {
            ventana.setScene(escenaDeBatalla);
        });

        Campo campo = new Campo(new Cementerio());
        Mano mano = new Mano(new Jugador("1", 2));
        Mazo mazo = new Mazo(new Jugador("2", 3));

        ConstructorDeCartas constructor = new ConstructorDeCartas();  //se ponen dos cartas en la mano
        CartaMonstruo aitsu = constructor.aitsu();
        CartaMonstruo monkey = constructor.mokeyMokey();
        mano.agregar(aitsu);
        mano.agregar(monkey);

        Button aitsuEnCampo = new Button("Esta aitsu en el campo?");

        aitsuEnCampo.setOnAction(e -> {    //Este boton es solo para probar si funciona

            if(campo.esta(aitsu)){

                System.out.print("si.");

            }
            else {System.out.print("no.");}}
        );                                  //.


        HBox monstruosEnCampo = new HBox();
        monstruosEnCampo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampo.setSpacing(10);
        monstruosEnCampo.setStyle("-fx-background-color: #336699;");

        Button boton = new Button("Colocar una carta");
        BotonColocarMonstruo botonM = new BotonColocarMonstruo(campo, mano, monstruosEnCampo);
        boton.setOnAction(botonM);

        //Contenedor de botones:
        HBox contenedorHorizontal = new HBox(boton, aitsuEnCampo, botonAPelear);
        contenedorHorizontal.setSpacing(8);


        VBox contenedorPrincipal = new VBox(contenedorHorizontal, monstruosEnCampo);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setPadding(new Insets(20));

        Scene scene = new Scene(contenedorPrincipal, 500, 550); //

        ventana.setScene(scene);

        ventana.show();

     /*   //Grilla
        GridPane grilla = new GridPane();
        grilla.setAlignment(Pos.CENTER);
        grilla.setHgap(10);
        grilla.setVgap(10);
        grilla.setPadding(new Insets(25,25,25,25));
        grilla.setGridLinesVisible(true);

        //Oponente
        Button botonOponente = new Button("Oponente");
        grilla.add(botonOponente,2,0);

        //Cartas Magicas/Trampa (MT) Oponente
        Button botonMT1Oponente = new Button("MT1O");
        grilla.add(botonMT1Oponente, 0, 1);

        Button botonMT2Oponente = new Button("MT2O");
        grilla.add(botonMT2Oponente, 1, 1);

        Button botonMT3Oponente = new Button("MT3O");
        grilla.add(botonMT3Oponente, 2, 1);

        Button botonMT4Oponente = new Button("MT4O");
        grilla.add(botonMT4Oponente, 3, 1);

        Button botonMT5Oponente = new Button("MT5O");
        grilla.add(botonMT5Oponente, 4, 1);


        //Cartas Monstruo Oponente
        Button botonM1Oponente = new Button("M1O");
        grilla.add(botonM1Oponente, 0,2);

        Button botonM2Oponente = new Button("M2O");
        grilla.add(botonM2Oponente, 1,2);

        Button botonM3Oponente = new Button("M3O");
        grilla.add(botonM3Oponente, 2,2);

        Button botonM4Oponente = new Button("M4O");
        grilla.add(botonM4Oponente, 3,2);

        Button botonM5Oponente = new Button("M5O");
        grilla.add(botonM5Oponente, 4,2);

        //Cartas Monstruo Aliadas
        Button botonM1Aliado = new Button("M1A");
        grilla.add(botonM1Aliado, 0,3);

        Button botonM2Aliado = new Button("M2A");
        grilla.add(botonM2Aliado, 1,3);

        Button botonM3Aliado = new Button("M3A");
        grilla.add(botonM3Aliado, 2,3);

        Button botonM4Aliado = new Button("M4A");
        grilla.add(botonM4Aliado, 3,3);

        Button botonM5Aliado = new Button("M5A");
        grilla.add(botonM5Aliado, 4,3);

        //Cartas Magicas/Trampa (MT) Aliadas
        Button botonMT1Aliada = new Button("MT1A");
        grilla.add(botonMT1Aliada, 0, 4);

        Button botonMT2Aliada = new Button("MT2A");
        grilla.add(botonMT2Aliada, 1, 4);

        Button botonMT3Aliada = new Button("MT3A");
        grilla.add(botonMT3Aliada, 2, 4);

        Button botonMT4Aliada = new Button("MT4A");
        grilla.add(botonMT4Aliada, 3, 4);

        Button botonMT5Aliada = new Button("MT5A");
        grilla.add(botonMT5Aliada, 4, 4);

        //Cartas Mano Mi Jugador
        Button botonMano1 = new Button("Mano 1");
        grilla.add(botonMano1,0,5);

        Button botonMano2 = new Button("Mano 2");
        grilla.add(botonMano2,1,5);

        Button botonMano3 = new Button("Mano 3");
        grilla.add(botonMano3,2,5);

        Button botonMano4 = new Button("Mano 4");
        grilla.add(botonMano4,3,5);

        Button botonMano5 = new Button("Mano 5");
        grilla.add(botonMano5,4,5);

        //Mi jugador
        Button botonMiJugador = new Button("MiJugador");
        grilla.add(botonMiJugador,2,6);

        //Escena inicial
        Scene escenaInicial = new Scene(grilla, 600, 600);
        ventana.setScene(escenaInicial);
        ventana.show();
*/

    }
}