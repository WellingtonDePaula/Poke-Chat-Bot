package wellz.Domain;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


public class ChatBot {
    private final List<Pokemon> pokemons = List.of(
//          new Pokemon("", new String[]{"", ""}, new String[]{"", ""}, ""),
            new Pokemon("Charmander", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "A chama que possui na ponta de seu rabo mostra a força de sua vida. Se ele estiver fraco, a chama irá diminuir. Quando está saudável, a chama brilhará intensamente. Tem preferência por coisas quentes. Quando chove, diz-se que o vapor jorra da ponta da cauda. Sua vida acabaria se essa chama se apagasse."),
            new Pokemon("Charmeleon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "Gosta muito de brigas, por isso busca constantemente por adversários. Ele ataca com suas garras afiadas e usando sua cauda como chicote de fogo. Pode soltar chamas azuis quando muito animado. Quando ele balança sua cauda em chamas, ele eleva a temperatura do ar a níveis insuportavelmente altos. Nas montanhas rochosas onde vive Charmeleon, suas caudas de fogo brilham à noite como estrelas."),
            new Pokemon("Charizard", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Rocha"}, "Seu fogo é quente o suficiente para derreter rochas. Quando nervoso, a chama em sua cauda queimará intensamente. É orgulhoso e voa pelos céus em busca de adversários poderosos. Suas asas podem transportar este pokémon até uma altitude de 1.400 metros. Expele fogo em temperaturas muito altas.")
    );

    private final String[] keyWords = {
            "tipo",
            "descricao",
            "fraqueza",
            "pokemon",
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

    private void init(String question) {
        this.question = question;
        this.questionSplitted = formatText(question).split("\\W+");
    }

    private ArrayList<ArrayList<String>> detectKeyWords(String[] text) {
        ArrayList<ArrayList<String>> keys = new ArrayList<>();
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        keys.add(new ArrayList<>());
        Pokemon pokemon;
        String name;
        String[] type;
        String[] weaknesses;

        for(int i = 0; i < text.length; i++) {
            if(keys.get(0).size() >= 2) {
                System.out.println("Você só pode digitar um pokémon por vez!");
                break;
            }
            for(int j = 0; j < pokemons.size(); j++) {
                pokemon = pokemons.get(j);
                name = pokemon.getName();
                type = pokemon.getType();
                weaknesses = pokemon.getWeaknesses();

                if(!keys.get(0).contains(name)) {
                    if(formatText(name).equals(formatText(text[i]))) {
                        keys.get(0).add(name);
                    }
                }
                for(int k = 0; k < type.length; k++) {
                    if(!keys.get(1).contains(type[k])) {
                        if(formatText(type[k]).equals(formatText(text[i]))) {
                            keys.get(1).add(type[k]);
                        }
                    }
                }
                for(int k = 0; k < weaknesses.length; k++) {
                    if(!keys.get(2).contains(weaknesses[k])) {
                        if(formatText(weaknesses[k]).equals(formatText(text[i]))) {
                            keys.get(2).add(weaknesses[k]);
                        }
                    }
                }
            }
            for(int j = 0; j < this.keyWords.length; j++) {
                if(!keys.get(3).contains(this.keyWords[j]) && formatText(text[i]).equals(keyWords[j])) {
                    keys.get(3).add(keyWords[j]);
                }
            }
        }
        return keys;
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
