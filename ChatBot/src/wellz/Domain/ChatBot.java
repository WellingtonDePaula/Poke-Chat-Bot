package wellz.Domain;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


public class ChatBot {
    private final List<Pokemon> pokemons = List.of(
//          new Pokemon("", new String[]{"", ""}, new String[]{"", ""}, ""),
            new Pokemon("Charmander", new String[]{"Fogo", "Água"}, new String[]{"Água", "Terra", "Pedra"}, "A chama que possui na ponta de seu rabo mostra a força de sua vida. Se ele estiver fraco, a chama irá diminuir. Quando está saudável, a chama brilhará intensamente. Tem preferência por coisas quentes. Quando chove, diz-se que o vapor jorra da ponta da cauda. Sua vida acabaria se essa chama se apagasse."),
            new Pokemon("Charmeleon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Pedra"}, "Gosta muito de brigas, por isso busca constantemente por adversários. Ele ataca com suas garras afiadas e usando sua cauda como chicote de fogo. Pode soltar chamas azuis quando muito animado. Quando ele balança sua cauda em chamas, ele eleva a temperatura do ar a níveis insuportavelmente altos. Nas montanhas rochosas onde vive Charmeleon, suas caudas de fogo brilham à noite como estrelas."),
            new Pokemon("Charizard", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Pedra"}, "Seu fogo é quente o suficiente para derreter rochas. Quando nervoso, a chama em sua cauda queimará intensamente. É orgulhoso e voa pelos céus em busca de adversários poderosos. Suas asas podem transportar este pokémon até uma altitude de 1.400 metros. Expele fogo em temperaturas muito altas.")
    );

    private final String[] keyWords = {
            "pokemon",
            "tipo",
            "fraqueza",
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
        ArrayList<ArrayList<String>> textKeyWords = detectKeyWords(this.questionSplitted);
        System.out.println(textKeyWords);
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
        String name;

        for(int i = 0; i < text.length; i++) {
//            Verifica se está sendo digitado mais de um pokémon na pergunta
//            if(keys.get(0).size() >= 2) {
//                System.out.println("Você só pode digitar um pokémon por vez!");
//                break;
//            }


            for(int j = 0; j < pokemons.size(); j++) {
                pokemon = pokemons.get(j);
                name = pokemon.getName();

                if(!keys.get(0).contains(name)) {
                    if(formatText(name).equals(formatText(text[i]))) {
                        keys.get(0).add(name);
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

    private String toPlural(String word) {
        char plural = 's';

        return word + plural;
    }

    private void printPokemonAllAtributes(Pokemon pokemon) {
        System.out.print("O " + pokemon.getName() + " é um pokemon tipo ");
        for(int i = 0; i < pokemon.getType().length; i++) {
            System.out.print(pokemon.getType()[i]);
            if(i+1 == pokemon.getType().length) {
                break;
            }
            System.out.print("/");
        }
        System.out.print(" e é fraco contra pokemons tipo ");
        for(int i = 0; i < pokemon.getWeaknesses().length; i++) {
            System.out.print(pokemon.getWeaknesses()[i]);
            if(i+1 == pokemon.getWeaknesses().length) {
                break;
            }
            System.out.print("/");
        }
        System.out.print(".");
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
}
