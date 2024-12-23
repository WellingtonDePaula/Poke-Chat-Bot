package wellz.Test;

import wellz.Domain.ChatBot;

import java.util.Scanner;

public class ChatBotTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatBot chat = new ChatBot();

        String input = sc.nextLine();

        chat.respond(input);
//        chat.respond("Quais as fraquezas do charmander e do charizard?");
    }
}