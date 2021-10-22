from socket import *
ADDR = ('localhost', 21566)
srvsock = socket(AF_INET, SOCK_DGRAM)
srvsock.bind(ADDR)
while True:
 print('esperando mensaje...')
 data, addr = srvsock.recvfrom(5120)
 print (addr)

 cadena = data.decode("utf-8")
 string_list= cadena.split('/')
 print(string_list)
 numero1=int (string_list[1])
 numero2=int (string_list[2])
 num1=int(numero1)
 num2=int(numero2)
 if(string_list[0]=='1' ):
     resultado= num1+num2
 if(string_list[0]=='2' ):
     resultado= num1-num2
 if(string_list[0]=='3' ):
     resultado= num1*num2
 if(string_list[0]=='4' ):
     resultado= num1/num2

 data=str(resultado)
 srvsock.sendto(data.encode("utf-8"), addr)
