package wellz.Domain;

import static wellz.Domain.Utils.formatText;

public class Pokemon {
    private String name;
    private String[] type;
    private String[] weaknesses;
    private String description;

    public static int getPokemonIndex(String name) {
        for (int i = 0; i < Pokemons.POKEMONS.VALUE.size(); i++) {
            if (formatText(name).equals(formatText(Pokemons.POKEMONS.VALUE.get(i).getName()))) {
                return i;
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String[] weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
