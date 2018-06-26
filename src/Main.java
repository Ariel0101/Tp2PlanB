import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.LinkedList;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage ventana) throws Exception {
        ventana.setTitle("Al-Go-Oh");

        /// PRUEBA APARTE:
        ConstructorDeCartas constructor = new ConstructorDeCartas();

        //Cosas del jugador:
        Campo campo = new Campo(new Cementerio());
        Mano mano = new Mano(new Jugador("1", 2));
        Mazo mazo = new Mazo(new Jugador("2", 3));
        Jugador jugador = new Jugador("pepe", 7000);

        //Cartas para probar
        CartaMonstruo aitsu = constructor.aitsu();
        CartaMonstruo monkey = constructor.mokeyMokey();

        mano.agregar(aitsu);
        mano.agregar(monkey);

        //Cosas del enemigo:
        Jugador enemigo = new Jugador("coco", 7000);
        Campo campoEnemigo = new Campo(new Cementerio());
        Mano manoEnemiga = new Mano(enemigo);
        Mazo mazoEnemigo = new Mazo(enemigo);

        //Cartas para probar
        CartaMonstruo goblin = constructor.goblinFalso();
        CartaMonstruo agujaAsesina = constructor.agujaAsesina();
        manoEnemiga.agregar(goblin);
        manoEnemiga.agregar(agujaAsesina);
        CartaMagica agujero = constructor.agujeroNegro(campo, campoEnemigo);
        mano.agregar(agujero);


        //Llenar mazos:
        RandomizadorCartas randomizador = new RandomizadorCartas(campoEnemigo, campo, mano, mazo);
        randomizador.llenarMazo(mazo);
        RandomizadorCartas randomizadorEnem = new RandomizadorCartas(campo, campoEnemigo, manoEnemiga, mazoEnemigo);
        randomizadorEnem.llenarMazo(mazoEnemigo);

        //Contenedor de las imagenes de las cartas en campo del jugador:
        CampoMonstruosHBox monstruosEnCampo = new CampoMonstruosHBox(campo);
        monstruosEnCampo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampo.setSpacing(10);
        monstruosEnCampo.setStyle("-fx-background-color: #336699;");

        CampoMonstruosHBox monstruosEnCampoEnemigo = new CampoMonstruosHBox(campoEnemigo);
        monstruosEnCampoEnemigo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampoEnemigo.setSpacing(10);
        monstruosEnCampoEnemigo.setAlignment(Pos.BASELINE_CENTER);
        monstruosEnCampoEnemigo.setStyle("-fx-background-color: #336679;");
        //Actualizador de Representaciones (actualiza el campo de batalla)
        LinkedList<Actualizable> representaciones = new LinkedList<>();
        representaciones.add(monstruosEnCampo);
        representaciones.add(monstruosEnCampoEnemigo);
        ActualizadorDeRepresentaciones actualizador = new ActualizadorDeRepresentaciones(representaciones);
        //Botones del jugador:
        Button boton = new Button("Colocar una carta");
        BotonColocarMonstruo botonM = new BotonColocarMonstruo(campo, mano, actualizador);
        boton.setOnAction(botonM);

        Button botonAtacar = new Button("Atacar");
        BotonAtacar botonAtacarEventHandler = new BotonAtacar(campo, campoEnemigo, jugador, enemigo, actualizador);
        botonAtacar.setOnAction(botonAtacarEventHandler);

        Button verMano1 = new Button("Ver mano");
        BotonVerMano accionVerMano1 = new BotonVerMano(mano);
        verMano1.setOnAction(accionVerMano1);

        Button botonActivarMagica = new Button("Activar carta Magica");
        BotonActivarMagica activarMagicaHandler = new BotonActivarMagica(campo);
        botonActivarMagica.setOnAction(activarMagicaHandler);

        //Botones del enemigo:
        Button botonColocarEnemigo = new Button("Colocar una carta");
        BotonColocarMonstruo botonEnemigoHandler = new BotonColocarMonstruo(campoEnemigo, manoEnemiga, actualizador);
        botonColocarEnemigo.setOnAction(botonEnemigoHandler);

        Button botonEnemigoAtacar = new Button("Atacar");
        BotonAtacar botonEnemAtacarEventHandler = new BotonAtacar(campoEnemigo, campo, enemigo, jugador, actualizador);
        botonEnemigoAtacar.setOnAction(botonEnemAtacarEventHandler);

        Button verMano2 = new Button("Ver mano");
        BotonVerMano accionVerMano2 = new BotonVerMano(manoEnemiga);
        verMano2.setOnAction(accionVerMano2);

        Button botonEnemActivarMagica = new Button("Activar carta Magica");
        BotonActivarMagica activarMagicaEnemHandler = new BotonActivarMagica(campoEnemigo);
        botonEnemActivarMagica.setOnAction(activarMagicaEnemHandler);

        //Contenedor de botones de jugador:
        HBox contenedorHorizontal = new HBox(boton, botonAtacar, verMano1, botonActivarMagica );
        contenedorHorizontal.setSpacing(8);

        //Contenedor de botones de enemigo:
        HBox contenedorHorizontalEnem = new HBox(botonColocarEnemigo, botonEnemigoAtacar, verMano2, botonEnemActivarMagica);
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


        //Boton para cambiar de turno:
        Turno turno = new Turno(contenedorHorizontal, contenedorHorizontalEnem);
        Button botonDeTurno = new Button("Siguiente turno");
        botonDeTurno.setOnAction(e -> turno.siguienteTurno());

        VBox contenedorPrincipal = new VBox(gridDeJugador, gridDeEnemigo, botonDeTurno);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setPadding(new Insets(40));

        Scene scene = new Scene(contenedorPrincipal, 500, 550); //

        ventana.setScene(scene);

        ventana.show();
    }


}