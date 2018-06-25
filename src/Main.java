import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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

        //
        //Constructor de Cartas
        ConstructorDeCartas constructor = new ConstructorDeCartas();

        //Cosas del jugador:
        Campo campoAmigo = new Campo(new Cementerio());
        Mano mano = new Mano(new Jugador("1", 2));
        Mazo mazo = new Mazo(new Jugador("2", 3));
        Jugador jugadorAmigo = new Jugador("pepe", 7000);

        //Cartas para probar
        CartaMonstruo aitsu = constructor.aitsu();
        CartaMonstruo monkey = constructor.mokeyMokey();
        mano.agregar(aitsu);
        mano.agregar(monkey);

        //Cosas del enemigo:
        Jugador jugadorEnemigo = new Jugador("coco", 7000);
        Campo campoEnemigo = new Campo(new Cementerio());
        Mano manoEnemiga = new Mano(jugadorEnemigo);

        //Cartas para probar
        CartaMonstruo goblin = constructor.goblinFalso();
        CartaMonstruo agujaAsesina = constructor.agujaAsesina();
        manoEnemiga.agregar(goblin);
        manoEnemiga.agregar(agujaAsesina);

        CartaMonstruo aitsu2 = constructor.aitsu();
        aitsu2.colocarEnPosAtaque();
        aitsu2.colocarBocaArriba();
        aitsu2.colocarse(campoAmigo);

        CartaMonstruo mokey = constructor.mokeyMokey();
        mokey.colocarEnPosAtaque();
        mokey.colocarBocaArriba();
        mokey.colocarse(campoEnemigo);

        //Boton atacar
        BotonElegirMonstruo botonElegirMonstruoAtacante = new BotonElegirMonstruo(campoAmigo, "Elegir monstruo atacante :");
        Button botonElegirMonstruoAtacanteWrapper = new Button("Elegir Monstruo Atacante");
        botonElegirMonstruoAtacanteWrapper.setOnAction(botonElegirMonstruoAtacante);

        BotonElegirMonstruo botonElegirMonstruoAtacado = new BotonElegirMonstruo(campoEnemigo, "Elegir monstruo atacado :");
        Button botonElegirMonstruoAtacadoWrapper = new Button("Elegir Monstruo Atacado");
        botonElegirMonstruoAtacadoWrapper.setOnAction(botonElegirMonstruoAtacado);

        BotonAtacar botonAtacar = new BotonAtacar(jugadorAmigo, campoAmigo, botonElegirMonstruoAtacante, jugadorEnemigo, campoEnemigo, botonElegirMonstruoAtacado);
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
        VBox campoDeBatalaVBox = new VBox(campoEnemigoMasBotonElegirAtacadoHBox, campoEnemigoMasBotonElegirAtacanteHBox, botonAtacarWrapper);

        Scene escenaDeBatalla = new Scene(campoDeBatalaVBox, 500, 550);


        //Boton cambiar a Escena Campo de Batalla
        Button botonAPelear = new Button("A Pelear !!!");
        botonAPelear.setOnAction(actionEvent -> {
            ventana.setScene(escenaDeBatalla);
        });


        Button aitsuEnCampo = new Button("Esta aitsu en el campo?");

        aitsuEnCampo.setOnAction(e -> {    //Este boton es solo para probar si funciona

                    if (campoAmigo.esta(aitsu)) {

                        System.out.print("si.");

                    } else {
                        System.out.print("no.");
                    }
                }
        );                                  //.


        HBox monstruosEnCampo = new HBox();
        monstruosEnCampo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampo.setSpacing(10);
        monstruosEnCampo.setStyle("-fx-background-color: #336699;");

        Button boton = new Button("Colocar una carta");
        BotonColocarMonstruo botonM = new BotonColocarMonstruo(campoAmigo, mano, monstruosEnCampo);
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
    }

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
=======
        HBox monstruosEnCampoEnemigo = new HBox();
        monstruosEnCampoEnemigo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampoEnemigo.setSpacing(10);
        monstruosEnCampoEnemigo.setAlignment(Pos.BASELINE_CENTER);
        monstruosEnCampoEnemigo.setStyle("-fx-background-color: #336679;");
>>>>>>> origin/master


        //Botones del jugador:

        Button boton = new Button("Colocar una carta");
        BotonColocarMonstruo botonM = new BotonColocarMonstruo(campo, mano, monstruosEnCampo);
        boton.setOnAction(botonM);

        Button botonAtacar = new Button("Atacar");
        BotonAtacar botonAtacarEventHandler = new BotonAtacar(campo, campoEnemigo, jugador, enemigo);
        botonAtacar.setOnAction(botonAtacarEventHandler);

        //Botones del enemigo:

        Button botonColocarEnemigo = new Button("Colocar una carta");
        BotonColocarMonstruo botonEnemigoHandler = new BotonColocarMonstruo(campoEnemigo, manoEnemiga, monstruosEnCampoEnemigo);
        botonColocarEnemigo.setOnAction(botonEnemigoHandler);

        Button botonEnemigoAtacar = new Button("Atacar");
        BotonAtacar botonEnemAtacarEventHandler = new BotonAtacar(campoEnemigo, campo, enemigo, jugador);
        botonEnemigoAtacar.setOnAction(botonEnemAtacarEventHandler);


        //Contenedor de botones de jugador:
        HBox contenedorHorizontal = new HBox(boton, botonAtacar);
        contenedorHorizontal.setSpacing(8);

        //Contenedor de botones de enemigo:
        HBox contenedorHorizontalEnem = new HBox(botonColocarEnemigo, botonEnemigoAtacar);
        contenedorHorizontalEnem.setSpacing(20);

        //Grilla de jugador:
        GridPane gridDeJugador = new GridPane();
        gridDeJugador.setMinSize(300, 100);
        gridDeJugador.setPadding(new Insets(10, 10, 10, 10));
        gridDeJugador.setVgap(5);
        gridDeJugador.setHgap(5);
        gridDeJugador.setAlignment(Pos.TOP_CENTER);
        gridDeJugador.add(contenedorHorizontal, 0, 1);
        gridDeJugador.add(monstruosEnCampo, 0, 2);

        //Grilla de enemigo:
        GridPane gridDeEnemigo = new GridPane();
        gridDeEnemigo.setMinSize(300, 100);
        gridDeEnemigo.setPadding(new Insets(10, 10, 10, 10));
        gridDeEnemigo.setVgap(10);
        gridDeEnemigo.setHgap(10);
        gridDeEnemigo.setAlignment(Pos.BOTTOM_CENTER);
        gridDeEnemigo.add(contenedorHorizontalEnem, 0, 1);
        gridDeEnemigo.add(monstruosEnCampoEnemigo, 0, 2);



        VBox contenedorPrincipal = new VBox(gridDeJugador, gridDeEnemigo);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setPadding(new Insets(40));

        Scene scene = new Scene(contenedorPrincipal, 500, 550); //

        ventana.setScene(scene);

        ventana.show();





    }
    */
}