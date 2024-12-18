from random import randint
import unicodedata
import string
import metodos

messages = [
    [
        "Desculpe, não sou bom o suficiente para entender o que você quis dizer.",
        "Perdão?",
        "Poderia tentar escrever de outro jeito? Não consegui compreender."
    ],  
]

keyWords = [
    [
        "oi",
        "oii",
        "oiii",
        "ola",
        "bomdia",
        "bao",
        "aoba",
        "tudocerto"
    ],

]

def init(question: str):
    questionSplit = question.lower()
    
    questionSplit = ''.join(char for char in unicodedata.normalize('NFD', questionSplit) if unicodedata.category(char) != 'Mn')
    
    questionSplit = questionSplit.translate(str.maketrans('', '', string.punctuation))

    questionSplit = questionSplit.split()

    identifyQuestion(questionSplit)

def identifyQuestion(questionSplit: str):
    for i in range(len(keyWords)):
        for j in range(len(keyWords[i])):
            match i:
                case 0:
                    for k in range(len(questionSplit)):
                        if(questionSplit[k] == keyWords[i][j]):
                            print(f"Olá {metodos.getTime()}")
                            return
                        if(k+1 < len(questionSplit) and questionSplit[k] + questionSplit[k+1] == keyWords[i][j]):
                            print(f"Olá {metodos.getTime()}")
                            return
    #message = error(messages[0])
    #print(message)

def error(errorMessages: list):
    choice = randint(0, len(errorMessages)-1)
    return errorMessages[choice]