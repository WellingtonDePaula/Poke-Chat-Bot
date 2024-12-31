package wellz.Domain;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static wellz.Domain.Utils.*;

public class ChatBot {
    private final String[] messages = loadFromJson("messages.json", new TypeReference<String[]>() {
    });

    private String question;
    private String[] questionSplitted;

    // Método de inicialização do chatbot
    public void run() {
        initMessage();
        loopResponse();
        stopMessage();
    }

    private void initMessage() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--- Seja bem-vindo ao chatbot de pokémon mais incrível do planeta, aproveite bem!! ---");
        System.out.println("--- Gostaria de ressaltar, que o chat não funcionará caso tente colocar mais de um ---");
        System.out.println("---              Pokémon por vez! Digite 'sair' para parar o programa              ---");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private void stopMessage() {
        System.out.println("|--                  |------------------------------------------|                  --|");
        System.out.println("|  |----------------|                                            |----------------|  |");
        System.out.println("|                    Finalizando programa, obrigado por testá-lo!                    |");
        System.out.println("|  |----------------|                                            |----------------|  |");
        System.out.println("|--                  |------------------------------------------|                  --|");
    }

    // Método que fica esperando uma pergunta do usuário, até ele decidir sair do sistema
    private void loopResponse() {
        Scanner sc = new Scanner(System.in);
        // Começa o loop
        while (true) {
            System.out.print("--> ");
            // Pede o input
            String input = sc.nextLine();
            // Verifica se o usuário deseja sair, e caso true, para o while loop
            if (formatText(input).equals("sair")) {
                break;
            }
            // Chama o método de geração da resposta
            respond(input);
        }
    }

    // Método que gera a resposta
    public void respond(String question) {
        // Cria um array list das palavras chaves detectadas na pergunta
        ArrayList<ArrayList<String>> questionKeyWords;
        // Cria uma string, onde será trabalhada a resposta para o usuário
        String resposta;
        // Transformando a pergunta em um array de cada palavra da pergunta
        this.questionSplitted = splitQuestion(question);

        // Chama o método que detecta palavras chaves no array passado como parâmetro
        questionKeyWords = detectKeyWords(this.questionSplitted);

        // Detecta se foi digitado mais de um pokémon, caso true ele retorna e para a geração da resposta
        if (questionKeyWords.get(0).size() >= 2) {
            System.out.println("Não pode ser digitado mais de um pokémon por vez");
            return;
        }

        // Chama o método que gera a resposta com base nas palavras chaves encontradas no texto
        resposta = generateResponse(questionKeyWords);
        System.out.println(resposta);
    }

    // Este método inicia o objeto para elaborar a resposta com a pergunta reinicializando a pergunta
    private String[] splitQuestion(String question) {
        this.question = question;
        // Formata a pergunta tirando pontuações e deixando em caixa baixa
        return formatText(question).split("\\W+");
    }

    private ArrayList<ArrayList<String>> detectKeyWords(String[] text) {
        // Cria um array das 'chaves' que podem ter
        ArrayList<ArrayList<String>> keys = new ArrayList<>();
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());

        // String do nome do pokémon que pode ser detectado nas palavras chaves
        String pokeName;

        // Esse loop percorre toda a pergunta
        for (String string : text) {
            // Esse loop percorre todo o array de pokemons
            for (Pokemon pokemon : Pokemons.POKEMONS.VALUE) {
                // Armazena o nome do pokémon da iteração atual na variavel pokeName
                pokeName = pokemon.getName();

                // Verifica o array de palavras chaves para saber se ele já contém o nome do pokémon da iteração atual
                if (!keys.get(0).contains(pokeName)) {
                    // Verifica se o nome do pokémon da iteração atual se iguala à palavra atual da pergunta
                    if (formatText(pokeName).equals(formatText(string))) {
                        // Adiciona o nome do pokémon nas palavras chaves
                        keys.get(0).add(pokeName);
                    }
                }

                // Faz a verificação e adiciona os tipos de pokémons presentes na pergunta do usuário
                for (PokeTypes pokeTypes : PokeTypes.values()) {
                    if (!keys.get(1).contains(pokeTypes.VALUE)) {
                        // Verifica se o tipo de pokémon é igual à palavra atual da pergunta do usuário
                        if (formatText(pokeTypes.VALUE).equals(formatText(string))) {
                            // Adiciona o tipo para o arraylist keys
                            keys.get(1).add(pokeTypes.VALUE);
                        }
                    }
                }
            }

            // Esse for faz a verificação de palavras chaves como, 'fraqueza' no texto (pergunta) percorrido
            // Percorre todo o array de palavras chaves
            for (KeyWords keyWords : KeyWords.values()) {
                // Verifica se a palavra chave já esta no array chave (keys), e caso não esteja,
                // verifica se pertence às palavras chaves e a adiciona ao array chave (keys)
                if (!keys.get(2).contains(keyWords.VALUE)) {
                    if (formatText(string).equals(keyWords.VALUE) || formatText(string).equals(toPlural(keyWords.VALUE))) {
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

        // Verifica se há alguma palavra chave, caso nao haja ele executa o bloco
        if (pokeNamesKey.isEmpty() && pokeTypesKey.isEmpty() && utilKey.isEmpty()) {
            // Retorna uma mensagem de erro
            response = chooseMessage(messages);
            return response;
        }

        if (!pokeNamesKey.isEmpty()) {
            for (String name : pokeNamesKey) {
                Pokemon pokemon = Pokemons.POKEMONS.VALUE.get(Pokemon.getPokemonIndex(name));
                if (!response.isEmpty()) {
                    response += "\n\n";
                }
                response += pokemon.getName() + ":";
                if (!utilKey.isEmpty()) {
                    for (String string : utilKey) {
                        if (string.equals("descricao")) {
                            response = getMessageOfDescription(response, pokemon);
                        }

                        if (string.equals("fraqueza")) {
                            response = getMessageOfWeakeness(response, pokemon);
                        }

                        if (string.equals("tipo")) {
                            response = getMessageOfType(response, pokemon);
                        }
                    }
                    return response;
                }
            }

        }

        if (!pokeTypesKey.isEmpty()) {
            if (!utilKey.isEmpty()) {
                for (String string : utilKey) {
                    if (string.equals("fraqueza") || string.equals("fraco")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "weakness");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                    if (string.equals("tipo")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "type");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                }
            }
        }
        response = chooseMessage(messages);
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

        for (int i = 0; i < Pokemons.POKEMONS.VALUE.size(); i++) {
            Pokemon pokemon = Pokemons.POKEMONS.VALUE.get(i);
            List<String> key;
            switch (characteristic) {
                case "type":
                    key = Arrays.stream(pokemon.getType()).toList();
                    break;
                case "weakness":
                    key = Arrays.stream(pokemon.getWeaknesses()).toList();
                    break;
                default:
                    key = null;
                    break;
            }

            boolean compatible = false;
            for (String string : keys) {

                if (key.contains(string)) {
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

    public String[] getMessages() {
        return messages;
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