package wellz.Domain;

import com.fasterxml.jackson.core.type.TypeReference;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChatBot {
    private final List<Pokemon> pokemons = Utils.loadFromJson("pokemons.json", new TypeReference<List<Pokemon>>(){});
    private final String[] messages = Utils.loadFromJson("messages.json", new TypeReference<String[]>(){});

    private String question;
    private String[] questionSplitted;

    public void run() {
        initMessage();
        loopResponse(this);
    }

    private void initMessage() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--- Seja bem-vindo ao chatbot de pokémon mais incrível do planeta, aproveite bem!! ---");
        System.out.println("--- Gostaria de ressaltar, que o chat não funcionará caso tente colocar mais de um ---");
        System.out.println("---              Pokémon por vez! Digite 'sair' para parar o programa              ---");
        System.out.println("--------------------------------------------------------------------------------------");
    }
    private void stopMessage() {
        System.out.println("                     |------------------------------------------|                     ");
        System.out.println("--------------------|                                            |--------------------");
        System.out.println("|                    Finalizando programa, obrigado por testá-lo!                    |");
        System.out.println("--------------------|                                            |--------------------");
        System.out.println("                     |------------------------------------------|                     ");
    }

    private void loopResponse(ChatBot cb) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("--> ");
            String input = sc.nextLine();
            if(formatText(input).equals("sair")) {
                stopMessage();
                break;
            }

            cb.respond(input);
        }
    }

    public void respond(String question) {
        init(question);
        ArrayList<ArrayList<String>> questionKeyWords = detectKeyWords(this.questionSplitted);
        if (questionKeyWords.get(0).size() >= 2) {
            System.out.println("Não pode ser digitado mais de um pokémon por vez");
            return;
        }
        String resposta = generateResponse(questionKeyWords);
        System.out.println(resposta);
    }

    //    Este método inicia o objeto para elaborar a resposta com a pergunta reinicializando a pergunta
    private void init(String question) {
        this.question = question;
//        Formata a pergunta tirando pontuações e deixando em caixa baixa
        this.questionSplitted = formatText(question).split("\\W+");
    }

    private ArrayList<ArrayList<String>> detectKeyWords(String[] text) {
        ArrayList<ArrayList<String>> keys = new ArrayList<>();
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        Pokemon pokemon;
        String pokeName;

        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < pokemons.size(); j++) {
                pokemon = pokemons.get(j);
                pokeName = pokemon.getName();

                if (!keys.get(0).contains(pokeName)) {
                    if (formatText(pokeName).equals(formatText(text[i]))) {
                        keys.get(0).add(pokeName);
                    }
                }

//                Faz a verificação e adiciona os tipos de pokémons presentes na pergunta do usuário
                for(PokeTypes pokeTypes : PokeTypes.values()) {
                    if (!keys.get(1).contains(pokeTypes.VALUE)) {
//                        Verifica se o tipo de pokémon é igual à palavra atual da pergunta do usuário
                        if (formatText(pokeTypes.VALUE).equals(formatText(text[i]))) {
//                            Adiciona o tipo para o arraylist keys
                            keys.get(1).add(pokeTypes.VALUE);
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
            }

//            Esse for faz a verificação de palavras chaves como, 'fraqueza' no texto(pergunta) percorrido

//            Percorre todo os array de palavras chaves
            for(KeyWords keyWords : KeyWords.values()) {
//                Verifica se a palavra chave já esta no array chave(keys), e caso não esteja,
//                verifica se pertence às palavras chaves e a adiciona ao array chave(keys)
                if (!keys.get(2).contains(keyWords.VALUE)) {
                    if (formatText(text[i]).equals(keyWords.VALUE) || formatText(text[i]).equals(toPlural(keyWords.VALUE))) {
                        keys.get(2).add(keyWords.VALUE);
                    }
                }
            }
        }
        return keys;
    }

    private String generateResponse(ArrayList<ArrayList<String>> questionKeyWords) {
        ArrayList<String> pokeNamesKey = questionKeyWords.get(0);
        ArrayList<String> pokeTypesKey = questionKeyWords.get(1);
        ArrayList<String> utilKey = questionKeyWords.get(2);
        String response = "";

        //Verifica se há alguma palavra chave
        if (pokeNamesKey.isEmpty() && pokeTypesKey.isEmpty() && utilKey.isEmpty()) {
            //Retorna uma mensagem de erro
            response = Utils.chooseMessage(messages);
            return response;
        }

        if (!pokeNamesKey.isEmpty()) {
            for (int i = 0; i < pokeNamesKey.size(); i++) {
                Pokemon pokemon = pokemons.get(getPokemonIndex(pokeNamesKey.get(i)));
                if (!response.isEmpty()) {
                    response += "\n\n";
                }
                response += pokemon.getName() + ":";
                if (!utilKey.isEmpty()) {
                    for (int j = 0; j < utilKey.size(); j++) {
                        if (utilKey.get(j).equals("descricao")) {
                            response = getMessageOfDescription(response, pokemon);
                        }

                        if (utilKey.get(j).equals("fraqueza")) {
                            response = getMessageOfWeakeness(response, pokemon);
                        }

                        if (utilKey.get(j).equals("tipo")) {
                            response = getMessageOfType(response, pokemon);
                        }
                    }
                    return response;
                }
            }

        }

        if (!pokeTypesKey.isEmpty()) {
            if (!utilKey.isEmpty()) {
                for (int j = 0; j < utilKey.size(); j++) {
                    if (utilKey.get(j).equals("fraqueza") || utilKey.get(j).equals("fraco")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "weakness");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                    if (utilKey.get(j).equals("tipo")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "type");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                }
            }
        }
        response = Utils.chooseMessage(messages);
        return response;
    }

    private String generateMessage(String response, ArrayList<Pokemon> compatibles) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        System.out.println("Os pokémons que se enquadram nos requisitos, são:");
        for (int i = 0; i < compatibles.size(); i++) {
            response += compatibles.get(i).getName();
            if (i < compatibles.size() - 1) {
                response += "\n";
            }
        }
        return response;
    }

    private ArrayList<Pokemon> getPoke(ArrayList<String> keys, String characteristic) {
        ArrayList<Pokemon> targetPokemons = new ArrayList<>();

        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            List<String> key;
            switch (characteristic) {
                case "type":
                    key = Arrays.stream(pokemon.getType()).toList();
                    break;
                case "weakness":
                    key = Arrays.stream(pokemon.getWeaknesses()).toList();
                    break;
                default:
                    key = Arrays.stream(pokemon.getType()).toList();
                    break;
            }

            boolean compatible = false;
            for (int j = 0; j < keys.size(); j++) {

                if (key.contains(keys.get(j))) {
                    compatible = true;
                    continue;
                }
                compatible = false;
                break;
            }
            if (compatible) {
                targetPokemons.add(pokemon);
            }
        }

        return targetPokemons;
    }

    private String getMessageOfType(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += "Este é um pokémon de tipo ";
        for (int i = 0; i < pokemon.getType().length; i++) {
            response += pokemon.getType()[i];
            if (i + 1 == pokemon.getType().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfWeakeness(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += "É vulnerável a pokémons do tipo ";
        for (int i = 0; i < pokemon.getWeaknesses().length; i++) {
            response += pokemon.getWeaknesses()[i];
            if (i + 1 == pokemon.getWeaknesses().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfDescription(String response, Pokemon pokemon) {
        if (!response.isEmpty()) {
            response += "\n";
        }
        response += pokemon.getDescription();

        return response;
    }

    private String toPlural(String word) {
        char plural = 's';

        return word + plural;
    }

    private int getPokemonIndex(String name) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (formatText(name).equals(formatText(pokemons.get(i).getName()))) {
                return i;
            }
        }
        return 0;
    }

    private String formatText(String string) {
        String normalized = Normalizer.normalize(string, Normalizer.Form.NFD);
        String withoutAccents = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String withoutPunctuation = withoutAccents.replaceAll("\\p{Punct}", "");

        return withoutPunctuation.toLowerCase();
    }

    public String[] getMessages() {
        return messages;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getQuestionSplitted() {
        return questionSplitted;
    }

    public void setQuestionSplitted(String[] questionSplitted) {
        this.questionSplitted = questionSplitted;
    }
}
