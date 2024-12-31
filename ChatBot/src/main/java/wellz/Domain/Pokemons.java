package wellz.Domain;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public enum Pokemons {
    POKEMONS(Utils.loadFromJson("pokemons.json", new TypeReference<List<Pokemon>>() {}));

    public final List<Pokemon> VALUE;
    Pokemons(List<Pokemon> value) {
        this.VALUE = value;
    }
}
