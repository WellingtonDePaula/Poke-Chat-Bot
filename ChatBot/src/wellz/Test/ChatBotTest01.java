package wellz.Test;

import wellz.Domain.ChatBot;

import java.util.Scanner;

public class ChatBotTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatBot chat = new ChatBot();

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--- Seja bem-vindo ao chatbot de pokémon mais incrível do planeta, aproveite bem!! ---");
        System.out.println("--- Gostaria de ressaltar, que o chat não funcionará caso tente colocar mais de um ---");
        System.out.println("---                                Pokémon por vez!                                ---");
        System.out.println("--------------------------------------------------------------------------------------");
        while(true) {
            System.out.print("--> ");
            String input = sc.nextLine();
            chat.respond(input);
        }
    }
}