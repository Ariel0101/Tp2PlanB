public class ConstructorDeCartas {

    //Cartas Monstruo
    public CartaMonstruo aitsu(){
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo aitsuCart =  new CartaMonstruo(aitsu, 5);
        aitsuCart.ponerNombre("Aitsu");
        return aitsuCart;
    }

    public CartaMonstruo mokeyMokey(){
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo monkey = new CartaMonstruo(mokeyMokey,3);
        monkey.ponerNombre("Mokey Mokey");
        return monkey;

    }

    public CartaMonstruo goblinFalso(){
        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblinFalso = new CartaMonstruo(goblinFalso, 1);
        cartaGoblinFalso.ponerNombre("Goblin Falso");
        return cartaGoblinFalso;
    }

    public CartaMonstruo agujaAsesina(){
        Monstruo agujaAsesina = new Monstruo(1200,1000);
        CartaMonstruo cartaAgugaAsesina = new CartaMonstruo(agujaAsesina,4);
        cartaAgugaAsesina.ponerNombre("Aguja Asesina");
        return cartaAgugaAsesina;
    }

    public CartaMonstruo agresorOscuro(){
        Monstruo agresorOscuro = new Monstruo(1200,1200);
        CartaMonstruo carta = new CartaMonstruo(agresorOscuro,4);
        carta.ponerNombre("Agresor Oscuro");
        return carta;
    }

    public CartaMonstruo alasDeLlamaPerversa(){
        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600);
        CartaMonstruo carta = new CartaMonstruo(alasDeLlamaPerversa, 2);
        carta.ponerNombre("Alas De La Llama Perversa");
        return carta;
    }

    public CartaMonstruoJinzo7 jinzo7(){
        Monstruo jinzo7 = new Monstruo(500,400);
        CartaMonstruoJinzo7 carta = new CartaMonstruoJinzo7(jinzo7,2);
        carta.ponerNombre("Jinzo 7");
        return carta;
    }

    public CartaMonstruoComeHombres insectoComeHombres(Campo campoEnemigo){
        Monstruo insectoComeHombres = new Monstruo(450, 600);
        CartaMonstruoComeHombres carta = new CartaMonstruoComeHombres(insectoComeHombres,2, campoEnemigo);
        carta.ponerNombre("Insecto Come Hombres");
        return carta;
    }

    public CartaMonstruoExodia cabezaDeExodia(){
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        CartaMonstruoExodia carta = new CartaMonstruoExodia(cabezaExodia,3);
        carta.ponerNombre("Cabeza De Exodia");
        return carta;
    }

    public CartaMonstruoExodia brazoDerechoExodia(){
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia(brazoDerechoExodia,3);
        carta.ponerNombre("Brazo Derecho De Exodia");
        return carta;
    }

    public CartaMonstruoExodia brazoIzquierdoExodia(){
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia(brazoIzquierdoExodia,3);
        carta.ponerNombre("Brazo Izquierdo De Exodia");
        return carta;
    }

    public CartaMonstruoExodia piernaDerechaExodia(){
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia(piernaDerechaExodia,3);
        carta.ponerNombre("Pierna Derecha De Exodia");
        return carta;
    }

    public CartaMonstruoExodia piernaizquierdaExodia(){
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia(piernaIzquierdaExodia,3);
        carta.ponerNombre("Pierna Izquiera De Exodia");
        return carta;
    }

    public CartaMonstruoDragon dragonDeOjosAzules(){
        CartaMonstruoDragon carta = new CartaMonstruoDragon();
        carta.ponerNombre("Dragon De Ojos Azules");
        return carta;
    }

    public CartaMonstruoDragonDefinitivo dragonDefinitivoDeOjosAzules(){
        CartaMonstruoDragonDefinitivo carta = new CartaMonstruoDragonDefinitivo();
        carta.ponerNombre("Dragon Definitivo");
        return carta;
    }

    //Cartas Magicas
    public CartaMagica agujeroNegro(Campo unLadoDelCampo, Campo otroLadoDelCampo){
        AgujeroOscuro agujeroOscuro = new AgujeroOscuro(unLadoDelCampo, otroLadoDelCampo);
        CartaMagica cartaAgujero = new CartaMagica(agujeroOscuro);
        cartaAgujero.ponerNombre("Agujero Oscuro");
        return cartaAgujero;

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
