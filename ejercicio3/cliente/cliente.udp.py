from socket import *
ADDR = ('localhost', 21566) #donde se conecta
cliSock = socket(AF_INET, SOCK_DGRAM)
print("1)SUMA 2)RESTA 3)MULTIPLICACION 4)DIVISION")
data = input('> ')
print("INGRESE EL PRIMER NUMERO")
num1 = input('> ')
print("INGRESE EL SEGUNDO NUMERO")
num2 = input('> ')
data= data + '/' + num1 + '/' + num2
cliSock.sendto(data.encode("utf-8"), ADDR)
data, ADDR = cliSock.recvfrom(500)
print(data.decode("utf-8"))
cliSock.close()