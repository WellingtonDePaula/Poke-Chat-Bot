import metodos
import chatBot

def main():
    while(True):
        pergunta = input("Digite sua pergunta:\n--> ")
        chatBot.init(pergunta)

main()