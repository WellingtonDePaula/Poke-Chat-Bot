package wellz.Domain;

import java.util.Scanner;
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

    public static void initMessage() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--- Seja bem-vindo ao chatbot de pokémon mais incrível do planeta, aproveite bem!! ---");
        System.out.println("--- Gostaria de ressaltar, que o chat não funcionará caso tente colocar mais de um ---");
        System.out.println("---                                Pokémon por vez!                                ---");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void loopResponse(ChatBot cb) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("--> ");
            String input = sc.nextLine();
            cb.respond(input);
        }
    }
}
