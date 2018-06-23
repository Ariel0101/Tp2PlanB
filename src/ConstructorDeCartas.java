public class ConstructorDeCartas {

    //Cartas Monstruo
    public CartaMonstruo aitsu(){
        Monstruo aitsu = new Monstruo(100,100);
        return new CartaMonstruo(aitsu, 5);
    }

    public CartaMonstruo mokeyMokey(){
        Monstruo mokeyMokey = new Monstruo(300,100);
        return new CartaMonstruo(mokeyMokey,3);
    }

    public CartaMonstruo goblinFalso(){
        Monstruo goblinFalso = new Monstruo(400,400);
        return new CartaMonstruo(goblinFalso, 1);
    }

    public CartaMonstruo agujaAsesina(){
        Monstruo agujaAsesina = new Monstruo(1200,1000);
        return new CartaMonstruo(agujaAsesina,4);
    }

    public CartaMonstruo agresorOscuro(){
        Monstruo agresorOscuro = new Monstruo(1200,1200);
        return new CartaMonstruo(agresorOscuro,4);
    }

    public CartaMonstruo alasDeLlamaPerversa(){
        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600);
        return new CartaMonstruo(alasDeLlamaPerversa, 2);
    }

    public CartaMonstruoJinzo7 jinzo7(){
        Monstruo jinzo7 = new Monstruo(500,400);
        return new CartaMonstruoJinzo7(jinzo7,2);
    }

    public CartaMonstruoComeHombres insectoComeHombres(Campo campoEnemigo){
        Monstruo insectoComeHombres = new Monstruo(450, 600);
        EfectoDestruirMonstruo efectoDestruirMonstruo = new EfectoDestruirMonstruo(campoEnemigo);
        return new CartaMonstruoComeHombres(insectoComeHombres,2, efectoDestruirMonstruo);
    }

    public CartaMonstruoExodia cabezaDeExodia(){
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        return  new CartaMonstruoExodia(cabezaExodia,3);
    }

    public CartaMonstruoExodia brazoDerechoExodia(){
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        return new CartaMonstruoExodia(brazoDerechoExodia,3);
    }

    public CartaMonstruoExodia brazoIzquierdoExodia(){
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        return new CartaMonstruoExodia(brazoIzquierdoExodia,3);
    }

    public CartaMonstruoExodia piernaDerechaExodia(){
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        return new CartaMonstruoExodia(piernaDerechaExodia,3);
    }

    public CartaMonstruoExodia piernaizquierdaExodia(){
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        return new CartaMonstruoExodia(piernaIzquierdaExodia,3);
    }

    public CartaMonstruoDragon dragonDeOjosAzules(){
        return new CartaMonstruoDragon();
    }

    public CartaMonstruoDragonDefinitivo dragonDefinitivoDeOjosAzules(){
        return new CartaMonstruoDragonDefinitivo();
    }

    //Cartas Magicas
    public CartaMagica agujeroNegro(Campo unLadoDelCampo, Campo otroLadoDelCampo){
        AgujeroOscuro agujeroOscuro = new AgujeroOscuro(unLadoDelCampo, otroLadoDelCampo);
        return new CartaMagica(agujeroOscuro);
    }

    public CartaMagica ollaDeLaCodicia(Mano miMano, Mazo miMazo){
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia(miMano, miMazo);
        return new CartaMagica(ollaDeLaCodicia);
    }

    public CartaMagica fisura(Campo campoEnemigo){
        Fisura fisura = new Fisura(campoEnemigo);
        return new CartaMagica(fisura);
    }

    //Cartas Trampa

    public CartaTrampa refuerzos(){
        Refuerzos refuerzos = new Refuerzos();
        return new CartaTrampa(refuerzos);
    }

    public CartaTrampa cilindroMagico(){
        CilindroMagico cilindroMagico = new CilindroMagico();
        return  new CartaTrampa(cilindroMagico);
    }

    // Cartas de Campo

    public CartaDeCampo wasteland(Campo campoAmigo, Campo campoEnemigo){
        EfectoWasteland efectoWasteland = new EfectoWasteland(campoAmigo, campoEnemigo);
        return new CartaDeCampo(efectoWasteland);
    }

    public CartaDeCampo sogen(Campo campoAmigo, Campo campoEnemigo){
        EfectoSogen efectoSogen = new EfectoSogen(campoAmigo,campoEnemigo);
        return new CartaDeCampo(efectoSogen);
    }
}
