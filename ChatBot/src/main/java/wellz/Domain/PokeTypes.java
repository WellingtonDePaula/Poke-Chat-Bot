package wellz.Domain;

public enum PokeTypes {
    NORMAL("Normal"),
    FOGO("Fogo"),
    AGUA("Água"),
    PLANTA("Planta"),
    ELETRICO("Elétrico"),
    GELO("Gelo"),
    LUTADOR("Lutador"),
    VENENO("Veneno"),
    TERRA("Terra"),
    VOADOR("Voador"),
    PSIQUICO("Psíquico"),
    INSETO("Inseto"),
    PEDRA("Pedra"),
    FANTASMA("Fantasma"),
    DRAGAO("Dragão"),
    NOTURNO("Noturno"),
    METALICO("Metálico"),
    FADA("Fada");

    private final String value;

    PokeTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String[] getValues() {
        return java.util.Arrays.stream(PokeTypes.values())
                .map(PokeTypes::getValue)
                .toArray(String[]::new);
    }

}