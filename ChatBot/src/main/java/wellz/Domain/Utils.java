package wellz.Domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.text.Normalizer;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String chooseMessage(String[] messages) {
        int len = messages.length;
        int indexTarget = getRandInt(0, len - 1);
        return messages[indexTarget];
    }

    public static String formatText(String string) {
        String normalized = Normalizer.normalize(string, Normalizer.Form.NFD);
        String withoutAccents = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String withoutPunctuation = withoutAccents.replaceAll("\\p{Punct}", "");

        return withoutPunctuation.toLowerCase();
    }

    public static String toPlural(String word) {
        char plural = 's';

        return word + plural;
    }

    public static int getRandInt(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(min, max + 1);
    }


    public static <T> T loadFromJson(String resourcePath, TypeReference<T> typeReference) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Usando ClassLoader para localizar o arquivo no diretório resources
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new RuntimeException("Arquivo " + resourcePath + " não encontrado em resources.");
        }

        try {
            return objectMapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar o arquivo JSON: " + resourcePath, e);
        }
    }
}
