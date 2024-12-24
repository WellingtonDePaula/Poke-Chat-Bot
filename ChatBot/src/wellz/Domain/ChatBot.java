package wellz.Domain;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatBot {
    private final List<Pokemon> pokemons = List.of(
//          new Pokemon("", new String[]{"", ""}, new String[]{"", ""}, ""),
            new Pokemon("Bulbasaur", new String[]{"Planta", "Veneno"}, new String[]{"Voador", "Fogo", "Gelo", "Psíquico"}, "Desde o dia em que nasceu possui uma semente estranha plantada em suas costas. O bulbo em suas costas está cheio de nutrientes. Nele, Bulbasaur armazena suas energias. O bulbo vai crescendo à medida que envelhece porque ele absorve os raios de sol."),
            new Pokemon("Charmander", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "A chama que possui na ponta de seu rabo mostra a força de sua vida. Se ele estiver fraco, a chama irá diminuir. Quando está saudável, a chama brilhará intensamente. Tem preferência por coisas quentes. Quando chove, diz-se que o vapor jorra da ponta da cauda. Sua vida acabaria se essa chama se apagasse."),
            new Pokemon("Charmeleon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Gosta muito de brigas, por isso busca constantemente por adversários. Ele ataca com suas garras afiadas e usando sua cauda como chicote de fogo. Pode soltar chamas azuis quando muito animado. Quando ele balança sua cauda em chamas, ele eleva a temperatura do ar a níveis insuportavelmente altos. Nas montanhas rochosas onde vive Charmeleon, suas caudas de fogo brilham à noite como estrelas."),
            new Pokemon("Charizard", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Pedra"}, "Seu fogo é quente o suficiente para derreter rochas. Quando nervoso, a chama em sua cauda queimará intensamente. É orgulhoso e voa pelos céus em busca de adversários poderosos. Suas asas podem transportar este pokémon até uma altitude de 1.400 metros. Expele fogo em temperaturas muito altas.")
    );

    private final String[] keyWords = {
            "tipo",
            "fraqueza",
            "fraco",
            "descricao",
    };

    private final String[] pokeTypes = {
            "Normal",
            "Fogo",
            "Água",
            "Grama",
            "Elétrico",
            "Gelo",
            "Lutador",
            "Veneno",
            "Terra",
            "Voador",
            "Psíquico",
            "Inseto",
            "Pedra",
            "Fantasma",
            "Dragão",
    };

    private final String[][] messages = {
            {
                "Não entendi, você poderia reformular sua frase?",
            },
    };
    private String question;
    private String[] questionSplitted;

    public void respond(String question) {
        init(question);
        ArrayList<ArrayList<String>> questionKeyWords = detectKeyWords(this.questionSplitted);
        if(questionKeyWords.get(0).size() >= 2) {
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

        for(int i = 0; i < text.length; i++) {
            for(int j = 0; j < pokemons.size(); j++) {
                pokemon = pokemons.get(j);
                pokeName = pokemon.getName();

                if(!keys.get(0).contains(pokeName)) {
                    if(formatText(pokeName).equals(formatText(text[i]))) {
                        keys.get(0).add(pokeName);
                    }
                }

//                Faz a verificação e adiciona os tipos de pokémons presentes na pergunta do usuário

//                Esse for percorre todo o array dos tipos de pokémons
                for(int k = 0; k < pokeTypes.length; k++) {
//                    Verifica se o arraylist keys ja possuí o tipo que está sendo verificado agora, para evitar repetições
                    if(!keys.get(1).contains(pokeTypes[k])) {
//                        Verifica se o tipo de pokémon é igual a palavra atual da pergunta do usuário
                        if(formatText(pokeTypes[k]).equals(formatText(text[i]))) {
//                            Adiciona o tipo para o arraylist keys
                            keys.get(1).add(pokeTypes[k]);
                        }
                    }
                }

                ////////////////////////////////////////////////////////////////////////////////////
            }

//            Esse for faz a verificação de palavras chaves como, 'fraqueza' no texto(pergunta) percorrido

//            Percorre todo os array de palavras chaves
            for(int j = 0; j < this.keyWords.length; j++) {
                /*
                Verficia se a palavra chave já esta no array chave(keys), e caso não esteja,
                verifica se pertence ás palavras chaves e a adiciona ao array chave(keys)
                */
                if(!keys.get(2).contains(this.keyWords[j])) {
                    if(formatText(text[i]).equals(keyWords[j]) || formatText(text[i]).equals(toPlural(keyWords[j]))) {
                        keys.get(2).add(keyWords[j]);
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
        if(pokeNamesKey.isEmpty() && pokeTypesKey.isEmpty() && utilKey.isEmpty()) {
            //Retorna uma mensagem de erro
            response = messages[0][0];
            return response;
        }

        if(!pokeNamesKey.isEmpty()) {
            for(int i = 0; i < pokeNamesKey.size(); i++) {
                Pokemon pokemon = pokemons.get(getPokemonIndex(pokeNamesKey.get(i)));
                if(!response.isEmpty()) {
                    response += "\n\n";
                }
                response += pokemon.getName() + ":";
                if(!utilKey.isEmpty()) {
                    for (int j = 0; j < utilKey.size(); j++) {
                        if(utilKey.get(j).equals("descricao")) {
                            response = getMessageOfDescription(response, pokemon);
                        }

                        if(utilKey.get(j).equals("fraqueza")) {
                            response = getMessageOfWeakeness(response, pokemon);
                        }

                        if(utilKey.get(j).equals("tipo")) {
                            response = getMessageOfType(response, pokemon);
                        }
                    }
                    return response;
                }
            }

        }

        if(!pokeTypesKey.isEmpty()) {
            if(!utilKey.isEmpty()) {
                for(int j = 0; j < utilKey.size(); j++) {
                    if(utilKey.get(j).equals("fraqueza") || utilKey.get(j).equals("fraco")) {
                        response = getMessageOfWeakestPokeOnType(response, pokeTypesKey);
                        return response;
                    }
                }
            }
        }
        response = messages[0][0];
        return response;
    }

    private String getMessageOfWeakestPokeOnType(String response, ArrayList<String> pokeTypesKey) {
        ArrayList<Pokemon> compatibles = getWeakestPokeOnType(pokeTypesKey);
        if(!response.isEmpty()) {
            response += "\n";
        }
        System.out.println("Os pokémons que se enquadram nos requisitos, são:");
        for(int i = 0; i < compatibles.size(); i++) {
            response += compatibles.get(i).getName();
            if(i < compatibles.size()-1) {
                response += "\n";
            }
        }
        return response;
    }

    private ArrayList<Pokemon> getWeakestPokeOnType(ArrayList<String> types) {
        ArrayList<Pokemon> targetPokemons = new ArrayList<>();

        for(int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            List<String> weaknesses = Arrays.stream(pokemon.getWeaknesses()).toList();

            boolean compatible = false;
            for(int j = 0; j < types.size(); j++) {

                if(weaknesses.contains(types.get(j))) {
                    compatible = true;
                    continue;
                }
                compatible = false;
                break;
            }
            if(compatible) {
                targetPokemons.add(pokemon);
            }
        }

        return targetPokemons;
    }

    private String getMessageOfType(String response, Pokemon pokemon) {
        if(!response.isEmpty()) {
            response += "\n";
        }
        response += "Este é um pokémon de tipo ";
        for(int i = 0; i < pokemon.getType().length; i++) {
            response += pokemon.getType()[i];
            if(i+1 == pokemon.getType().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfWeakeness(String response, Pokemon pokemon) {
        if(!response.isEmpty()) {
            response += "\n";
        }
        response += "É vulnerável a pokémons do tipo ";
        for(int i = 0; i < pokemon.getWeaknesses().length; i++) {
            response += pokemon.getWeaknesses()[i];
            if(i+1 == pokemon.getWeaknesses().length) {
                break;
            }
            response += "/";
        }
        return response;
    }

    private String getMessageOfDescription(String response, Pokemon pokemon) {
        if(!response.isEmpty()) {
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
        for(int i = 0; i < pokemons.size(); i++) {
            if(formatText(name).equals(formatText(pokemons.get(i).getName()))) {
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

    public String[][] getMessages() {
        return messages;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public String[] getPokeTypes() {
        return pokeTypes;
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
