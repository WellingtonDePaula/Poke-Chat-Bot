package wellz.Domain;

public enum KeyWords {
    TIPO("tipo"),
    FRAQUEZA("fraqueza"),
    FRACO("fraco"),
    DESCRICAO("descricao");

    private final String value;
    KeyWords(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String[] getValues() {
        return java.util.Arrays.stream(KeyWords.values())
                .map(KeyWords::getValue)
                .toArray(String[]::new);
    }
}
