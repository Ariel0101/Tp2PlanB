class AumentoAtaque implements Aumento{

    private final int aumento;

    AumentoAtaque(int i) {

        this.aumento = i;
    }

    void activar(ListaMonstruos monstruos){

        for (CartaMonstruo m: monstruos){

            m.aumentarAtaque(this.aumento);

        }

    }

    void activarEn(CartaMonstruo m){

        m.aumentarAtaque(this.aumento);

    }
}
