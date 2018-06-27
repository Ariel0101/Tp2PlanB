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

    public void start(Stage ventana) throws Exception {
        ventana.setTitle("Al-Go-Oh");

        //Partida
        Partida unaPartida = new Partida();
        unaPartida.setVentana(ventana);

        //Cosas del jugador:
        Jugador jugador = new Jugador("Yugi-1", 100, unaPartida);
        Campo campo = new Campo(new Cementerio());
        Mano mano = new Mano(jugador);
        Mazo mazo = new Mazo(jugador);

        //Cosas del enemigo:
        Jugador enemigo = new Jugador("Yugi-2", 100, unaPartida);
        Campo campoEnemigo = new Campo(new Cementerio());
        Mano manoEnemiga = new Mano(enemigo);
        Mazo mazoEnemigo = new Mazo(enemigo);

        //Cartas para probar
        //Constructor Cartas
        ConstructorDeCartas constructor = new ConstructorDeCartas();
        //Amigo
        CartaMonstruo aitsu = constructor.aitsu();
        CartaMonstruo monkey = constructor.mokeyMokey();
        CartaMagica agujero = constructor.agujeroNegro(campo, campoEnemigo);
        mano.agregar(aitsu);
        mano.agregar(monkey);
        mano.agregar(agujero);
        //Enemigo
        CartaMonstruo goblin = constructor.goblinFalso();
        CartaMonstruo agujaAsesina = constructor.agujaAsesina();
        CartaMonstruo alasDeLlamaPerversa = constructor.alasDeLlamaPerversa();
        manoEnemiga.agregar(goblin);
        manoEnemiga.agregar(agujaAsesina);
        manoEnemiga.agregar(alasDeLlamaPerversa);
        //Sets de prueba
        //Prueba sacar ultima carta del mazo
        Mazo mazoDeUnaCarta = new Mazo(jugador);
        CartaMonstruoJinzo7 jinzo7= constructor.jinzo7();
        mazoDeUnaCarta.agregar(jinzo7);
        //Prueba colocar 5 partes de exodia en la mano;
        Mazo mazoConUltimaParteDeExodia = new Mazo(jugador);
        mazoConUltimaParteDeExodia.agregar(constructor.cabezaDeExodia());
        mazoConUltimaParteDeExodia.agregar(constructor.goblinFalso());
        Mano manoConCuatroPartesDeExodia = new Mano(jugador);
        manoConCuatroPartesDeExodia.agregar(constructor.brazoDerechoExodia());
        manoConCuatroPartesDeExodia.agregar(constructor.brazoIzquierdoExodia());
        manoConCuatroPartesDeExodia.agregar(constructor.piernaDerechaExodia());
        manoConCuatroPartesDeExodia.agregar(constructor.piernaizquierdaExodia());

        //Llenar mazos:
        RandomizadorCartas randomizador = new RandomizadorCartas(campoEnemigo, campo, mano, mazo);
        randomizador.llenarMazo(mazo);
        RandomizadorCartas randomizadorEnem = new RandomizadorCartas(campo, campoEnemigo, manoEnemiga, mazoEnemigo);
        randomizadorEnem.llenarMazo(mazoEnemigo);

        //Contenedor de las imagenes de cosas del jugador:
        HBox jugadorVisualHBox = new HBox();
        RepresentacionJugador representacionJugador = new RepresentacionJugador(jugador, jugadorVisualHBox);
        HBox monstruosEnCampo = new HBox();
        RepresentacionCampoMonstruos representacionCampoMonstruos = new RepresentacionCampoMonstruos(campo,monstruosEnCampo);
        HBox magicasTrampasEnCampo = new HBox();
        RepresentacionCampoMagicasTrampas representacionCampoMagicasTrampas = new RepresentacionCampoMagicasTrampas(campo, magicasTrampasEnCampo);

        monstruosEnCampo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampo.setSpacing(10);
        monstruosEnCampo.setStyle("-fx-background-color: #336699;");

        magicasTrampasEnCampo.setPadding(new Insets(10, 12, 44, 12));
        magicasTrampasEnCampo.setSpacing(10);
        magicasTrampasEnCampo.setStyle("-fx-background-color: #336699;");

        //Contenedor de las imagenes de cosas del jugador enemigo:
        HBox jugadorEnemigoVisualHBox = new HBox();
        RepresentacionJugador representacionJugadorEnemigo = new RepresentacionJugador(enemigo, jugadorEnemigoVisualHBox);
        HBox monstruosEnCampoEnemigo = new HBox();
        RepresentacionCampoMonstruos representacionCampoMonstruosEnemigo = new RepresentacionCampoMonstruos(campoEnemigo,monstruosEnCampoEnemigo);
        HBox magicasTrampasEnCampoEnemigo = new HBox();
        RepresentacionCampoMagicasTrampas representacionCampoMagicasTrampasEnemigo = new RepresentacionCampoMagicasTrampas(campoEnemigo, magicasTrampasEnCampoEnemigo);

        monstruosEnCampoEnemigo.setPadding(new Insets(10, 12, 44, 12));
        monstruosEnCampoEnemigo.setSpacing(10);
        monstruosEnCampoEnemigo.setStyle("-fx-background-color: #336679;");

        magicasTrampasEnCampoEnemigo.setPadding(new Insets(10, 12, 44, 12));
        magicasTrampasEnCampoEnemigo.setSpacing(10);
        magicasTrampasEnCampoEnemigo.setStyle("-fx-background-color: #336679;");

        //Actualizador de Representaciones (actualiza el campo de batalla)
        LinkedList<Actualizable> representaciones = new LinkedList<>();
        representaciones.add(representacionCampoMonstruos);
        representaciones.add(representacionCampoMonstruosEnemigo);
        representaciones.add(representacionCampoMagicasTrampas);
        representaciones.add(representacionCampoMagicasTrampasEnemigo);
        representaciones.add(representacionJugador);
        representaciones.add(representacionJugadorEnemigo);
        ActualizadorDeRepresentaciones actualizador = new ActualizadorDeRepresentaciones(representaciones);
        actualizador.actualizar();

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
        BotonActivarMagica activarMagicaHandler = new BotonActivarMagica(campo, actualizador);
        botonActivarMagica.setOnAction(activarMagicaHandler);

        Button botonAgarrarCarta = new Button("Sacar carta del mazo");
        BotonSacarCartaDeMazo botonAgarrarCartaHandler = new BotonSacarCartaDeMazo(mazo, mano, botonAgarrarCarta);
        botonAgarrarCarta.setOnAction(botonAgarrarCartaHandler);

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
        BotonActivarMagica activarMagicaEnemHandler = new BotonActivarMagica(campoEnemigo, actualizador);
        botonEnemActivarMagica.setOnAction(activarMagicaEnemHandler);

        Button botonAgarrarCartaEnem = new Button("Sacar carta del mazo");
        BotonSacarCartaDeMazo botonAgarrarCartaEnemHandler = new BotonSacarCartaDeMazo(mazoEnemigo, manoEnemiga, botonAgarrarCartaEnem);
        botonAgarrarCartaEnem.setOnAction(botonAgarrarCartaEnemHandler);


        //Contenedor de botones de jugador:
        HBox contenedorHorizontal = new HBox(boton, botonAtacar, verMano1, botonActivarMagica, botonAgarrarCarta);
        contenedorHorizontal.setSpacing(20);

        //Contenedor de botones de enemigo:
        HBox contenedorHorizontalEnem = new HBox(botonColocarEnemigo, botonEnemigoAtacar, verMano2, botonEnemActivarMagica, botonAgarrarCartaEnem);
        contenedorHorizontalEnem.setSpacing(20);

        //Grilla de jugador:
        GridPane gridDeJugador = new GridPane();
        gridDeJugador.setMinSize(300, 240);
        gridDeJugador.setPadding(new Insets(10, 10, 10, 10));
        gridDeJugador.setVgap(10);
        gridDeJugador.setHgap(10);
        gridDeJugador.setAlignment(Pos.TOP_CENTER);
        gridDeJugador.add(jugadorVisualHBox,0,0);
        gridDeJugador.add(contenedorHorizontal, 0, 1);
        gridDeJugador.add(monstruosEnCampo, 0, 2);
        gridDeJugador.add(magicasTrampasEnCampo, 0, 3);


        //Grilla de enemigo:
        GridPane gridDeEnemigo = new GridPane();
        gridDeEnemigo.setMinSize(300, 240);
        gridDeEnemigo.setPadding(new Insets(10, 10, 10, 10));
        gridDeEnemigo.setVgap(10);
        gridDeEnemigo.setHgap(10);
        gridDeEnemigo.setAlignment(Pos.BOTTOM_CENTER);
        gridDeEnemigo.add(jugadorEnemigoVisualHBox,0,0);
        gridDeEnemigo.add(contenedorHorizontalEnem, 0, 1);
        gridDeEnemigo.add(monstruosEnCampoEnemigo, 0, 2);
        gridDeEnemigo.add(magicasTrampasEnCampoEnemigo, 0, 3);

        //Boton para cambiar de turno:
        Turno turno = new Turno(contenedorHorizontal, contenedorHorizontalEnem, botonAgarrarCarta, botonAgarrarCartaEnem);
        Button botonDeTurno = new Button("Siguiente turno");
        botonDeTurno.setOnAction(e -> turno.siguienteTurno());

        VBox contenedorPrincipal = new VBox(gridDeJugador, gridDeEnemigo, botonDeTurno);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setPadding(new Insets(40));

        Scene scene = new Scene(contenedorPrincipal, 1000, 850); //

        ventana.setScene(scene);

        ventana.show();
    }


}