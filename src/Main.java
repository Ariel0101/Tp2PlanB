import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage ventanaPrincipal) throws Exception {
        ventanaPrincipal.setTitle("Al-Go-Oh");
        //ventanaPrincipal.setFullScreen(true);
       // ventanaPrincipal.setFullScreenExitHint("");

        //Partida
        Partida unaPartida = new Partida();
        unaPartida.setVentana(ventanaPrincipal);

        //Cosas del jugador:
        Jugador jugador = new Jugador("Yugi Muto", 8000, unaPartida);
        Campo campo = new Campo(new Cementerio());
        Mano mano = new Mano(jugador);
        Mazo mazo = new Mazo(jugador);

        //Cosas del enemigo:
        Jugador enemigo = new Jugador("Seto Kaiba", 8000, unaPartida);
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
        CartaMonstruoJinzo7 jinzo7 = constructor.jinzo7();
        mano.agregar(aitsu);
        mano.agregar(monkey);
        mano.agregar(agujero);
        mano.agregar(jinzo7);
        //Enemigo
        CartaMonstruo goblin = constructor.goblinFalso();
        CartaMonstruo agujaAsesina = constructor.agujaAsesina();
        CartaMonstruo alasDeLlamaPerversa = constructor.alasDeLlamaPerversa();
        CartaMonstruoComeHombres insectoComeHombres = constructor.insectoComeHombres(campo);
        manoEnemiga.agregar(goblin);
        manoEnemiga.agregar(agujaAsesina);
        manoEnemiga.agregar(alasDeLlamaPerversa);
        manoEnemiga.agregar(insectoComeHombres);

        //Sets de prueba
        //Mazo con cartas de campo
        Mazo mazoConCartasDeCampo = new Mazo(jugador);
        mazoConCartasDeCampo.agregar(constructor.sogen(campo,campoEnemigo));
        mazoConCartasDeCampo.agregar(constructor.wasteland(campo,campoEnemigo));
        mazoConCartasDeCampo.agregar(constructor.goblinFalso());
        //Prueba sacar ultima carta del mazo
        Mazo mazoDeUnaCarta = new Mazo(jugador);
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
        VBox jugadorVisualVBox = new VBox(10);
        ImageView imagenYugi = this.crearImagen("imagenes/yugi.png", 150, 150);
        ProgressBar barraDeVidaJugador1 = new ProgressBar();
        barraDeVidaJugador1.setProgress(1.0);
        barraDeVidaJugador1.setPrefSize(150, 20);
        Label nombreJ1 = new Label(jugador.toString() +" "+ (int)jugador.verVida() + "/" + (int)jugador.verVidaMaxima());
        nombreJ1.setStyle("-fx-font: 15 arial;");
        jugadorVisualVBox.setAlignment(Pos.TOP_LEFT);
        RepresentacionJugador representacionJugador = new RepresentacionJugador(jugador, jugadorVisualVBox, imagenYugi, barraDeVidaJugador1, nombreJ1);
        imagenYugi.autosize();

        HBox monstruosEnCampo = new HBox();
        RepresentacionCampoMonstruos representacionCampoMonstruos = new RepresentacionCampoMonstruos(campo,monstruosEnCampo);
        HBox magicasTrampasEnCampo = new HBox();
        RepresentacionCampoMagicasTrampas representacionCampoMagicasTrampas = new RepresentacionCampoMagicasTrampas(campo, magicasTrampasEnCampo);

        monstruosEnCampo.setPadding(new Insets(5, 5, 5, 5));
        monstruosEnCampo.setSpacing(10);
        monstruosEnCampo.setPrefHeight(130);;
        monstruosEnCampo.setStyle("-fx-background-color: #336699;");

        magicasTrampasEnCampo.setPadding(new Insets(5, 5, 5, 5));
        magicasTrampasEnCampo.setSpacing(10);
        magicasTrampasEnCampo.setPrefHeight(130);;

        magicasTrampasEnCampo.setStyle("-fx-background-color: #336699;");

        //Contenedor de las imagenes de cosas del jugador enemigo:
        VBox jugadorEnemigoVisualVBox = new VBox(10);
        jugadorEnemigoVisualVBox.setAlignment(Pos.TOP_LEFT);
        ImageView imagenSeto = this.crearImagen("imagenes/seto.png", 150, 150);
        //imagenSeto.autosize();
        ProgressBar barraDeVidaJugador2 = new ProgressBar();
        barraDeVidaJugador2.setProgress(1.0);
        barraDeVidaJugador2.setPrefSize(150, 20);
        Label nombreJ2 = new Label(enemigo.toString()+" "+ (int)enemigo.verVida() + "/" + (int)enemigo.verVidaMaxima());
        nombreJ2.setStyle("-fx-font: 15 arial;");

        RepresentacionJugador representacionJugadorEnemigo = new RepresentacionJugador(enemigo, jugadorEnemigoVisualVBox, imagenSeto, barraDeVidaJugador2, nombreJ2);
        HBox monstruosEnCampoEnemigo = new HBox();
        RepresentacionCampoMonstruos representacionCampoMonstruosEnemigo = new RepresentacionCampoMonstruos(campoEnemigo,monstruosEnCampoEnemigo);
        HBox magicasTrampasEnCampoEnemigo = new HBox();
        RepresentacionCampoMagicasTrampas representacionCampoMagicasTrampasEnemigo = new RepresentacionCampoMagicasTrampas(campoEnemigo, magicasTrampasEnCampoEnemigo);

        monstruosEnCampoEnemigo.setPadding(new Insets(5, 5, 5, 5));
        monstruosEnCampoEnemigo.setSpacing(10);
        monstruosEnCampoEnemigo.setPrefHeight(120);;

        monstruosEnCampoEnemigo.setStyle("-fx-background-color: #336679;");

        magicasTrampasEnCampoEnemigo.setPadding(new Insets(5, 5, 5, 5));
        magicasTrampasEnCampoEnemigo.setSpacing(10);
        magicasTrampasEnCampoEnemigo.setPrefHeight(120);;

        magicasTrampasEnCampoEnemigo.setStyle("-fx-background-color: #336679;");

        //Actualizador de Representaciones
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
        Button botonColocarCarta = new Button("Colocar una carta");
        BotonColocarCarta botonColocarCartaHandler = new BotonColocarCarta(campo, mano, actualizador);
        botonColocarCarta.setOnAction(botonColocarCartaHandler);

        Button botonAtacar = new Button("Atacar");
        BotonAtacar botonAtacarEventHandler = new BotonAtacar(campo, campoEnemigo, jugador, enemigo, actualizador, ventanaPrincipal);
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

        BotonCambiarBocaYPosicion botonCambiarBocaPosicionHandler = new BotonCambiarBocaYPosicion(campo, botonColocarCartaHandler, actualizador);
        Button botonCambiarBocaPosicionMonstruo = new Button("Cambiar Boca y Posicion");
        botonCambiarBocaPosicionMonstruo.setOnAction(botonCambiarBocaPosicionHandler);

        //Botones del enemigo:
        Button botonColocarEnemigo = new Button("Colocar una carta");
        BotonColocarCarta botonColocarCartaEnemigoHandler = new BotonColocarCarta(campoEnemigo, manoEnemiga, actualizador);
        botonColocarEnemigo.setOnAction(botonColocarCartaEnemigoHandler);

        Button botonEnemigoAtacar = new Button("Atacar");
        BotonAtacar botonEnemAtacarEventHandler = new BotonAtacar(campoEnemigo, campo, enemigo, jugador, actualizador, ventanaPrincipal);
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

        BotonCambiarBocaYPosicion botonCambiarBocaPosicionHandlerEnemigo = new BotonCambiarBocaYPosicion(campoEnemigo, botonColocarCartaEnemigoHandler,actualizador);
        Button botonCambiarBocaPosicionMonstruoEnemigo = new Button("Cambiar Boca y Posicion");
        botonCambiarBocaPosicionMonstruoEnemigo.setOnAction(botonCambiarBocaPosicionHandlerEnemigo);

        //Contenedor de botones de jugador:
        HBox contenedorHorizontal = new HBox(botonColocarCarta, botonCambiarBocaPosicionMonstruo,botonAtacar, verMano1, botonActivarMagica, botonAgarrarCarta);
        contenedorHorizontal.setSpacing(20);

        //Contenedor de botones de enemigo:
        HBox contenedorHorizontalEnem = new HBox(botonColocarEnemigo, botonCambiarBocaPosicionMonstruoEnemigo,botonEnemigoAtacar, verMano2, botonEnemActivarMagica, botonAgarrarCartaEnem);
        contenedorHorizontalEnem.setSpacing(20);

        //Grilla de jugador:
        VBox campoJugador1VBox = new VBox(5);
        campoJugador1VBox.getChildren().addAll(monstruosEnCampo, magicasTrampasEnCampo, contenedorHorizontal);
        HBox pantallaJugador1HBox = new HBox(5);
        pantallaJugador1HBox.getChildren().addAll(jugadorVisualVBox, campoJugador1VBox);
        
     
        /*GridPane gridDeJugador = new GridPane();
        gridDeJugador.setMinSize(300, 240);
        gridDeJugador.setPadding(new Insets(10, 10, 10, 10));
        gridDeJugador.setVgap(10);
        gridDeJugador.setHgap(10);
        gridDeJugador.setAlignment(Pos.TOP_LEFT);
        gridDeJugador.add(jugadorVisualVBox,0,1);
        gridDeJugador.add(contenedorHorizontal, 1, 2);
        gridDeJugador.add(monstruosEnCampo, 1, 0);
        gridDeJugador.add(magicasTrampasEnCampo, 1, 1);
        gridDeJugador.*/

        //Grilla de enemigo:
        
        VBox campoJugador2VBox = new VBox(5);
        campoJugador2VBox.getChildren().addAll(monstruosEnCampoEnemigo, magicasTrampasEnCampoEnemigo, contenedorHorizontalEnem);
        HBox pantallaJugador2HBox = new HBox(5);
        pantallaJugador2HBox.getChildren().addAll(campoJugador2VBox, jugadorEnemigoVisualVBox);
        /*GridPane gridDeEnemigo = new GridPane();
        gridDeEnemigo.setMinSize(300, 240);
        gridDeEnemigo.setPadding(new Insets(10, 10, 10, 10));
        gridDeEnemigo.setVgap(10);
        gridDeEnemigo.setHgap(10);
        gridDeEnemigo.setAlignment(Pos.BOTTOM_RIGHT);
        gridDeEnemigo.add(jugadorEnemigoVisualVBox,1, 1);
        gridDeEnemigo.add(contenedorHorizontalEnem, 0, 0);
        gridDeEnemigo.add(monstruosEnCampoEnemigo, 0, 1);
        gridDeEnemigo.add(magicasTrampasEnCampoEnemigo, 0, 2);*/

        // Objetos a reiniciar cuando termine el turno
        LinkedList<Reiniciable> reiniciablesAlTerminarTurno = new LinkedList<>();
        reiniciablesAlTerminarTurno.add(botonAtacarEventHandler);
        reiniciablesAlTerminarTurno.add(botonEnemAtacarEventHandler);
        reiniciablesAlTerminarTurno.add(botonColocarCartaHandler);
        reiniciablesAlTerminarTurno.add(botonColocarCartaEnemigoHandler);
        reiniciablesAlTerminarTurno.add(botonCambiarBocaPosicionHandler);
        reiniciablesAlTerminarTurno.add(botonCambiarBocaPosicionHandlerEnemigo);
        reiniciablesAlTerminarTurno.add(campo);
        reiniciablesAlTerminarTurno.add(campoEnemigo);

        // Botones a habilitar cuando termine el turno
        LinkedList<Button> botonesAHabilitarAlTerminarTurno = new LinkedList<>();
        botonesAHabilitarAlTerminarTurno.add(botonAgarrarCarta);
        botonesAHabilitarAlTerminarTurno.add(botonAgarrarCartaEnem);

        //Boton para cambiar de turno:
        Turno turno = new Turno(contenedorHorizontal, contenedorHorizontalEnem, botonesAHabilitarAlTerminarTurno, reiniciablesAlTerminarTurno);
        Button botonDeTurno = new Button("Siguiente turno");
        botonDeTurno.setOnAction(e -> turno.siguienteTurno());

        VBox contenedorPrincipal = new VBox(pantallaJugador1HBox, pantallaJugador2HBox, botonDeTurno);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(60));
        pantallaJugador1HBox.setAlignment(Pos.TOP_LEFT);
        pantallaJugador2HBox.setAlignment(Pos.BOTTOM_RIGHT);

      
        BackgroundImage imagenFondo = new BackgroundImage(new Image("imagenes/background1.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(-1, -1, true, true, false, true));
        Background fondo = new Background(imagenFondo);
        contenedorPrincipal.setBackground(fondo);

        Scene scene = new Scene(contenedorPrincipal, 1000, 850);

        ventanaPrincipal.setScene(scene);

        ventanaPrincipal.show();
    }

    public ImageView crearImagen(String url, int height, int width){
        Image img = new Image(url);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(height);
        imgView.setFitWidth(width);
        return imgView;
    }
}