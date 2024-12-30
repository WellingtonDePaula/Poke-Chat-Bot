package wellz.Domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String chooseMessage(String[] messages) {
        int len = messages.length;
        int indexTarget = getRandInt(0, len-1);
        return messages[indexTarget];
    }

    public static int getRandInt(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(min, max + 1);
    }

    public static List<Pokemon> getPokemonsFromJson() {
        ObjectMapper conversor = new ObjectMapper();

        Path jsonTarget = Paths.get("src/main/resources/pokemons.json");

        List<Pokemon> pokemons = null;
        try {
            pokemons = conversor.readValue(jsonTarget.toFile(), new TypeReference<List<Pokemon>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pokemons;
    }
}
