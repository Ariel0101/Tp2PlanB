package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main extends Application {

    private String colorDeFondoDeCampoJugador1 = "-fx-background-color: #336699;";
    private String colorDeFondoDeCampoJugador2 = "-fx-background-color: #336679;";


    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage ventanaPrincipal) throws Exception {
        ventanaPrincipal.setTitle("Al-Go-Oh");
        ventanaPrincipal.setFullScreen(true);
       // ventanaPrincipal.setFullScreenExitHint("");

        //Controlador.Partida
        Partida unaPartida = new Partida();
        unaPartida.setVentana(ventanaPrincipal);

        //Cementerio
        Cementerio cementerio = new Cementerio();

        //Cosas del jugador:
        Jugador jugador = new Jugador("Yugi Muto", 2000, unaPartida);
        Campo campo = new Campo(cementerio);
        Mano mano = new Mano(jugador);
        Mazo mazo = new Mazo(jugador);

        //Cosas del enemigo:
        Jugador enemigo = new Jugador("Seto Kaiba", 2000, unaPartida);
        Campo campoEnemigo = new Campo(cementerio);
        Mano manoEnemiga = new Mano(enemigo);
        Mazo mazoEnemigo = new Mazo(enemigo);


        //Sets de prueba
        //Constructor Cartas
        ConstructorDeCartas constructor = new ConstructorDeCartas();
        //Mazo con cartas de campo
        Mazo mazoConCartasDeCampo = new Mazo(jugador);
        mazoConCartasDeCampo.agregar(constructor.sogen(campo,campoEnemigo));
        mazoConCartasDeCampo.agregar(constructor.wasteland(campo,campoEnemigo));
        mazoConCartasDeCampo.agregar(constructor.goblinFalso());
        //Prueba sacar ultima carta del mazo
        Mazo mazoDeUnaCarta = new Mazo(jugador);
        mazoDeUnaCarta.agregar(constructor.goblinFalso());
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

        //Llenar manos
        for (int i = 0; i<5; i++){
            mazo.sacar(mano);
            mazoEnemigo.sacar(manoEnemiga);
        }

        //Contenedor de las Vista.imagenes de cosas del jugador:

        VBox jugadorVisualVBox = new VBox(10);
        ImageView imagenYugi = this.crearImagen("Vista/Imagenes/yugi.png", 150, 150);
        ControladorJugador controladorJugador = new ControladorJugador(jugador, jugadorVisualVBox, imagenYugi);

        HBox monstruosEnCampo = this.crearVistaDeSectorDeCampo(colorDeFondoDeCampoJugador1);
        ControladorCampoMonstruos controladorCampoMonstruos = new ControladorCampoMonstruos(campo,monstruosEnCampo);

        HBox magicasTrampasEnCampo = this.crearVistaDeSectorDeCampo(colorDeFondoDeCampoJugador1);
        ControladorCampoMagicasTrampas controladorCampoMagicasTrampas = new ControladorCampoMagicasTrampas(campo, magicasTrampasEnCampo);

        VBox slotCartaDeCampo = new VBox();
        ControladorCartaDeCampo controladorCartaDeCampo = new ControladorCartaDeCampo(campo, slotCartaDeCampo);

        //Contenedor de las Vista.imagenes de cosas del jugador enemigo:

        VBox jugadorEnemigoVisualVBox = new VBox(10);
        ImageView imagenSeto = this.crearImagen("Vista/Imagenes/seto.png", 150, 150);
        ControladorJugador controladorJugadorEnemigo = new ControladorJugador(enemigo, jugadorEnemigoVisualVBox, imagenSeto);

        HBox monstruosEnCampoEnemigo = this.crearVistaDeSectorDeCampo(colorDeFondoDeCampoJugador2);
        ControladorCampoMonstruos controladorCampoMonstruosEnemigo = new ControladorCampoMonstruos(campoEnemigo,monstruosEnCampoEnemigo);

        HBox magicasTrampasEnCampoEnemigo = this.crearVistaDeSectorDeCampo(colorDeFondoDeCampoJugador2);
        ControladorCampoMagicasTrampas controladorCampoMagicasTrampasEnemigo = new ControladorCampoMagicasTrampas(campoEnemigo, magicasTrampasEnCampoEnemigo);

        VBox slotCartaDeCampoEnemiga = new VBox();
        ControladorCartaDeCampo controladorCartaDeCampoEnemiga = new ControladorCartaDeCampo(campoEnemigo, slotCartaDeCampoEnemiga);

        //Actualizador de Representaciones
        LinkedList<Actualizable> representaciones = new LinkedList<>();
        representaciones.add(controladorCampoMonstruos);
        representaciones.add(controladorCampoMonstruosEnemigo);
        representaciones.add(controladorCampoMagicasTrampas);
        representaciones.add(controladorCampoMagicasTrampasEnemigo);
        representaciones.add(controladorJugador);
        representaciones.add(controladorJugadorEnemigo);
        representaciones.add(controladorCartaDeCampo);
        representaciones.add(controladorCartaDeCampoEnemiga);
        ActualizadorDeRepresentaciones actualizador = new ActualizadorDeRepresentaciones(representaciones);
        actualizador.actualizar();

        //Botones del jugador:
        Button botonColocarCarta = new Button("Colocar una carta");
        BotonColocarCarta botonColocarCartaHandler = new BotonColocarCarta(campo, mano, actualizador);
        botonColocarCarta.setOnAction(botonColocarCartaHandler);

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

        BotonCambiarBocaYPosicion botonCambiarBocaPosicionHandler = new BotonCambiarBocaYPosicion(campo, botonColocarCartaHandler, actualizador, campoEnemigo);
        Button botonCambiarBocaPosicionMonstruo = new Button("Cambiar Boca y Posicion");
        botonCambiarBocaPosicionMonstruo.setOnAction(botonCambiarBocaPosicionHandler);

        //Botones del enemigo:
        Button botonColocarEnemigo = new Button("Colocar una carta");
        BotonColocarCarta botonColocarCartaEnemigoHandler = new BotonColocarCarta(campoEnemigo, manoEnemiga, actualizador);
        botonColocarEnemigo.setOnAction(botonColocarCartaEnemigoHandler);

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

        BotonCambiarBocaYPosicion botonCambiarBocaPosicionHandlerEnemigo = new BotonCambiarBocaYPosicion(campoEnemigo, botonColocarCartaEnemigoHandler,actualizador, campo);
        Button botonCambiarBocaPosicionMonstruoEnemigo = new Button("Cambiar Boca y Posicion");
        botonCambiarBocaPosicionMonstruoEnemigo.setOnAction(botonCambiarBocaPosicionHandlerEnemigo);

        //Contenedor de botones de jugador:
        HBox contenedorHorizontal = new HBox(botonColocarCarta, botonCambiarBocaPosicionMonstruo,botonAtacar, verMano1, botonActivarMagica, botonAgarrarCarta);
        contenedorHorizontal.setSpacing(20);

        //Contenedor de botones de enemigo:
        HBox contenedorHorizontalEnem = new HBox(botonColocarEnemigo, botonCambiarBocaPosicionMonstruoEnemigo,botonEnemigoAtacar, verMano2, botonEnemActivarMagica, botonAgarrarCartaEnem);
        contenedorHorizontalEnem.setSpacing(20);

        //Box entero del jugador1
        VBox campoJugador1VBox = new VBox(5);
        campoJugador1VBox.getChildren().addAll(monstruosEnCampo, magicasTrampasEnCampo, contenedorHorizontal);
        HBox pantallaJugador1HBox = new HBox(5);
        pantallaJugador1HBox.getChildren().addAll(jugadorVisualVBox, campoJugador1VBox, slotCartaDeCampo);
        
     
        //Box entero del jugador2
        VBox campoJugador2VBox = new VBox(5);
        campoJugador2VBox.getChildren().addAll(monstruosEnCampoEnemigo, magicasTrampasEnCampoEnemigo, contenedorHorizontalEnem);
        HBox pantallaJugador2HBox = new HBox(5);
        pantallaJugador2HBox.getChildren().addAll(slotCartaDeCampoEnemiga, campoJugador2VBox, jugadorEnemigoVisualVBox);


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

      
        BackgroundImage imagenFondo = new BackgroundImage(new Image("Vista/Imagenes/background1.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(-1, -1, true, true, false, true));
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

    private HBox crearVistaDeSectorDeCampo(String colorDeFondoDeCampo) {

        HBox sectorDeCampo = new HBox();
        sectorDeCampo.setPadding(new Insets(5, 5, 5, 5));
        sectorDeCampo.setSpacing(10);
        sectorDeCampo.setPrefHeight(130);;
        sectorDeCampo.setStyle(colorDeFondoDeCampo);
        return sectorDeCampo;
    }

}