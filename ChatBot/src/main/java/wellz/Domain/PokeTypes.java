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

    public final String VALUE;

    PokeTypes(String value) {
        this.VALUE = value;
    }


}