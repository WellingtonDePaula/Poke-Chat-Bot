package wellz.Domain;
import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatBot {
    private final List<Pokemon> pokemons = List.of(
//          new Pokemon("", new String[]{"", ""}, new String[]{"", ""}, ""),
            new Pokemon("Bulbasaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "Um Pokémon inicial com uma semente em suas costas que cresce com ele."),
            new Pokemon("Ivysaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "A evolução de Bulbasaur com um botão maior nas costas."),
            new Pokemon("Venusaur", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "Quando completamente desenvolvido, carrega uma grande flor em suas costas."),
            new Pokemon("Charmander", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "Uma salamandra de fogo cujo rabo arde constantemente."),
            new Pokemon("Charmeleon", new String[]{"Fogo"}, new String[]{"Água", "Terra", "Rocha"}, "A evolução de Charmander, mais feroz e com uma chama maior."),
            new Pokemon("Charizard", new String[]{"Fogo", "Voador"}, new String[]{"Água", "Elétrico", "Rocha"}, "Um dragão que pode voar e expele fogo ardente."),
            new Pokemon("Squirtle", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "Uma pequena tartaruga que esguicha água para se proteger."),
            new Pokemon("Wartortle", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "A evolução de Squirtle, com cauda e orelhas peludas."),
            new Pokemon("Blastoise", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "Um Pokémon com canhões de água em seu casco."),
            new Pokemon("Caterpie", new String[]{"Inseto"}, new String[]{"Fogo", "Voador", "Pedra"}, "Uma pequena lagarta que eventualmente se transforma."),
            new Pokemon("Metapod", new String[]{"Inseto"}, new String[]{"Fogo", "Voador", "Pedra"}, "O estágio intermediário de Caterpie, encapsulado."),
            new Pokemon("Butterfree", new String[]{"Inseto", "Voador"}, new String[]{"Fogo", "Elétrico", "Gelo", "Voador", "Pedra"}, "Uma borboleta com habilidades psíquicas."),
            new Pokemon("Weedle", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Pedra"}, "Uma pequena larva com um ferrão venenoso."),
            new Pokemon("Kakuna", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Pedra"}, "Um casulo que se prepara para evoluir."),
            new Pokemon("Beedrill", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Pedra"}, "Uma abelha feroz com ferrões venenosos."),
            new Pokemon("Pidgey", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Um pequeno pássaro que é comum em várias áreas."),
            new Pokemon("Pidgeotto", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "A evolução de Pidgey, maior e mais forte."),
            new Pokemon("Pidgeot", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Uma águia majestosa e veloz."),
            new Pokemon("Rattata", new String[]{"Normal"}, new String[]{"Lutador"}, "Um rato pequeno e muito rápido."),
            new Pokemon("Raticate", new String[]{"Normal"}, new String[]{"Lutador"}, "A evolução de Rattata, com dentes grandes e afiados."),
            new Pokemon("Spearow", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "Um pássaro agressivo e muito barulhento."),
            new Pokemon("Fearow", new String[]{"Normal", "Voador"}, new String[]{"Elétrico", "Gelo", "Pedra"}, "A evolução de Spearow, maior e mais ameaçador."),
            new Pokemon("Ekans", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "Uma cobra venenosa que se move silenciosamente."),
            new Pokemon("Arbok", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "A evolução de Ekans, com padrões ameaçadores."),
            new Pokemon("Pikachu", new String[]{"Elétrico"}, new String[]{"Terra"}, "Um rato elétrico muito popular e adorável."),
            new Pokemon("Raichu", new String[]{"Elétrico"}, new String[]{"Terra"}, "A evolução de Pikachu, com mais energia elétrica."),
            new Pokemon("Sandshrew", new String[]{"Terra"}, new String[]{"Água", "Gelo", "Planta"}, "Um Pokémon que vive em regiões áridas e escava para se esconder."),
            new Pokemon("Sandslash", new String[]{"Terra"}, new String[]{"Água", "Gelo", "Planta"}, "A evolução de Sandshrew, com garras afiadas e espinhos."),
            new Pokemon("Nidoran♀", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "Um pequeno Pokémon com habilidades venenosas."),
            new Pokemon("Nidorina", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "A evolução de Nidoran♀, mais forte e protetora."),
            new Pokemon("Nidoqueen", new String[]{"Veneno", "Terra"}, new String[]{"Psíquico", "Água", "Gelo"}, "A forma final de Nidoran♀, com grande poder defensivo."),
            new Pokemon("Nidoran♂", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "Um pequeno Pokémon com chifres venenosos."),
            new Pokemon("Nidorino", new String[]{"Veneno"}, new String[]{"Psíquico", "Terra"}, "A evolução de Nidoran♂, com chifres mais perigosos."),
            new Pokemon("Nidoking", new String[]{"Veneno", "Terra"}, new String[]{"Psíquico", "Água", "Gelo"}, "A forma final de Nidoran♂, com grande força ofensiva."),
            new Pokemon("Clefairy", new String[]{"Normal"}, new String[]{"Lutador"}, "Um Pokémon encantador que é atraído pela lua."),
            new Pokemon("Clefable", new String[]{"Normal"}, new String[]{"Lutador"}, "A evolução de Clefairy, ainda mais encantadora."),
            new Pokemon("Vulpix", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "Uma raposa de fogo com caudas elegantes."),
            new Pokemon("Ninetales", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "A evolução de Vulpix, com um ar de mistério."),
            new Pokemon("Jigglypuff", new String[]{"Normal"}, new String[]{"Lutador"}, "Um Pokémon redondo que canta para adormecer seus inimigos."),
            new Pokemon("Wigglytuff", new String[]{"Normal"}, new String[]{"Lutador"}, "A evolução de Jigglypuff, com um corpo ainda mais flexível."),
            new Pokemon("Zubat", new String[]{"Veneno", "Voador"}, new String[]{"Psíquico", "Elétrico", "Gelo", "Pedra"}, "Um morcego que se move em cavernas escuras."),
            new Pokemon("Golbat", new String[]{"Veneno", "Voador"}, new String[]{"Psíquico", "Elétrico", "Gelo", "Pedra"}, "A evolução de Zubat, com uma boca enorme."),
            new Pokemon("Oddish", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "Uma planta noturna que se move lentamente."),
            new Pokemon("Gloom", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "A evolução de Oddish, com um aroma forte."),
            new Pokemon("Vileplume", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "A forma final de Oddish, com uma grande flor venenosa."),
            new Pokemon("Paras", new String[]{"Inseto", "Planta"}, new String[]{"Fogo", "Voador", "Gelo", "Veneno", "Pedra"}, "Um inseto que carrega cogumelos em suas costas."),
            new Pokemon("Parasect", new String[]{"Inseto", "Planta"}, new String[]{"Fogo", "Voador", "Gelo", "Veneno", "Pedra"}, "A evolução de Paras, completamente controlado por seus cogumelos."),
            new Pokemon("Venonat", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Pedra"}, "Um inseto peludo com olhos grandes."),
            new Pokemon("Venomoth", new String[]{"Inseto", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Pedra"}, "A evolução de Venonat, com asas cobertas de pó tóxico."),
            new Pokemon("Diglett", new String[]{"Terra"}, new String[]{"Água", "Gelo", "Planta"}, "Um pequeno Pokémon que vive no subsolo."),
            new Pokemon("Dugtrio", new String[]{"Terra"}, new String[]{"Água", "Gelo", "Planta"}, "A evolução de Diglett, com três cabeças."),
            new Pokemon("Meowth", new String[]{"Normal"}, new String[]{"Lutador"}, "Um gato que adora moedas brilhantes."),
            new Pokemon("Persian", new String[]{"Normal"}, new String[]{"Lutador"}, "A evolução de Meowth, elegante e astuto."),
            new Pokemon("Psyduck", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "Um pato que sofre de constantes dores de cabeça."),
            new Pokemon("Golduck", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "A evolução de Psyduck, com grande agilidade aquática."),
            new Pokemon("Mankey", new String[]{"Lutador"}, new String[]{"Psíquico", "Voador", "Fada"}, "Um macaco temperamental e muito agressivo."),
            new Pokemon("Primeape", new String[]{"Lutador"}, new String[]{"Psíquico", "Voador", "Fada"}, "A evolução de Mankey, ainda mais furioso."),
            new Pokemon("Growlithe", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "Um cachorro leal com habilidades de fogo."),
            new Pokemon("Arcanine", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "A evolução de Growlithe, majestoso e veloz."),
            new Pokemon("Poliwag", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "Um girino com uma espiral no abdômen."),
            new Pokemon("Poliwhirl", new String[]{"Água"}, new String[]{"Elétrico", "Planta"}, "A evolução de Poliwag, com braços fortes."),
            new Pokemon("Poliwrath", new String[]{"Água", "Lutador"}, new String[]{"Elétrico", "Planta", "Psíquico", "Voador", "Fada"}, "A forma final de Poliwag, com grande força física."),
            new Pokemon("Abra", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Sombrio"}, "Um Pokémon que teleporta para evitar perigo."),
            new Pokemon("Kadabra", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Sombrio"}, "A evolução de Abra, com habilidades psíquicas mais fortes."),
            new Pokemon("Alakazam", new String[]{"Psíquico"}, new String[]{"Inseto", "Fantasma", "Sombrio"}, "A forma final de Abra, com intelecto superior."),
            new Pokemon("Machop", new String[]{"Lutador"}, new String[]{"Psíquico", "Voador", "Fada"}, "Um Pokémon que treina para ser mais forte."),
            new Pokemon("Machoke", new String[]{"Lutador"}, new String[]{"Psíquico", "Voador", "Fada"}, "A evolução de Machop, com músculos poderosos."),
            new Pokemon("Machamp", new String[]{"Lutador"}, new String[]{"Psíquico", "Voador", "Fada"}, "A forma final de Machop, com quatro braços."),
            new Pokemon("Bellsprout", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "Uma planta carnívora que se move lentamente."),
            new Pokemon("Weepinbell", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "A evolução de Bellsprout, mais ágil."),
            new Pokemon("Victreebel", new String[]{"Planta", "Veneno"}, new String[]{"Fogo", "Psíquico", "Voador", "Gelo"}, "A forma final de Bellsprout, com uma boca perigosa."),
            new Pokemon("Tentacool", new String[]{"Água", "Veneno"}, new String[]{"Elétrico", "Psíquico", "Terra"}, "Um Pokémon aquático com tentáculos venenosos."),
            new Pokemon("Tentacruel", new String[]{"Água", "Veneno"}, new String[]{"Elétrico", "Psíquico", "Terra"}, "A evolução de Tentacool, com tentáculos mais perigosos."),
            new Pokemon("Geodude", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Aço"}, "Um Pokémon feito de rocha sólida."),
            new Pokemon("Graveler", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Aço"}, "A evolução de Geodude, mais robusto."),
            new Pokemon("Golem", new String[]{"Pedra", "Terra"}, new String[]{"Água", "Planta", "Gelo", "Lutador", "Terra", "Aço"}, "A forma final de Geodude, com uma armadura rochosa."),
            new Pokemon("Ponyta", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "Um cavalo de fogo com velocidade incrível."),
            new Pokemon("Rapidash", new String[]{"Fogo"}, new String[]{"Água", "Rocha", "Terra"}, "A evolução de Ponyta, ainda mais rápida."),
            new Pokemon("Slowpoke", new String[]{"Água", "Psíquico"}, new String[]{"Elétrico", "Planta", "Inseto", "Fantasma", "Sombrio"}, "Um Pokémon lento e desatento."),
            new Pokemon("Slowbro", new String[]{"Água", "Psíquico"}, new String[]{"Elétrico", "Planta", "Inseto", "Fantasma", "Sombrio"}, "A evolução de Slowpoke, com uma concha na cauda."),
            new Pokemon("Magnemite", new String[]{"Elétrico", "Aço"}, new String[]{"Terra", "Fogo", "Lutador"}, "Um Pokémon metálico que flutua.")
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
            "Planta",
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
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "weakness");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                    if(utilKey.get(j).equals("tipo")) {
                        ArrayList<Pokemon> compatibles = getPoke(pokeTypesKey, "type");
                        response = generateMessage(response, compatibles);
                        return response;
                    }
                }
            }
        }
        response = messages[0][0];
        return response;
    }

    private String generateMessage(String response, ArrayList<Pokemon> compatibles) {
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

    private ArrayList<Pokemon> getPoke(ArrayList<String> keys, String characteristic) {
        ArrayList<Pokemon> targetPokemons = new ArrayList<>();

        for(int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            List<String> key;
            switch(characteristic) {
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
            for(int j = 0; j < keys.size(); j++) {

                if(key.contains(keys.get(j))) {
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
