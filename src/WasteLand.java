class WasteLand {

    private Campo campoAmigo;
    private Campo campoEnemigo;

    WasteLand(Campo campoAmigo, Campo campoEnemigo) {

        this.campoAmigo = campoAmigo;
        this.campoEnemigo = campoEnemigo;

    }


    void activar() {

        this.campoAmigo.agregarEfecto(new AumentoAtaque(200));
        this.campoEnemigo.agregarEfecto(new AumentoDefensa(300));

    }
}
