class SacrificioCreador {
    public static Sacrificio crear(int estrellas) {

        if (estrellas == 5 || estrellas == 6){

            return new Sacrificio(1);

        }

        if (estrellas > 6){

            return new Sacrificio(2);

        }

        return new Sacrificio(1);

    }
}
