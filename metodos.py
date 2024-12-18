from time import localtime

def getTime():
    horario = localtime().tm_hour

    if(6 <= horario < 12):
        return "dia"
    if(12 <= horario < 18):
        return "tarde"
    return "noite"