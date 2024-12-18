from time import localtime

def getTime():
    horario = localtime().tm_hour

    if(6 <= horario < 12):
        return "bom dia"
    if(12 <= horario < 18):
        return "boa tarde"
    return "boa noite"