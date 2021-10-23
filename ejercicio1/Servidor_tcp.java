
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor_tcp {
    public static String fibo(int n){
        String cad="";
        int a=-1, b=1, d=0;
        d = a+ b; a = b; b = d;
        
        for (int i = 0; i < n; i++) {
            cad= cad + String.valueOf(d) + ", ";
            d = a+b;
            a = b;
            b = d;             
        }
        return cad;
        
    }
    public static String primos(int n){
        String cad="";
        int con=0,i=2;
        while(con<=n){
            if(esPrimo(i)) {
                cad= cad + String.valueOf(i) + ", "; con++;
            }
            i++;
        }
        return cad;
    }

    
    public static String fiboprimos(int n){
        String cad="";
        int a=-1, b=1, d=0, i=0;
        d = a+ b; a = b; b = d;
        
        while(i<=n) {
            if(esPrimo(d)) {
                cad= cad + String.valueOf(d) + ", "; i++;
            }
            d = a+b;
            a = b;
            b = d;             
        }
        return cad;
    }
    
public static boolean esPrimo(int num){
    int cont = 2;
    boolean primo=true;
    while ((primo) && (cont<=num/2)){
    if (num % cont == 0)
        primo = false;
    cont++;
    }
    return primo;
}
    
    public static void main(String args[]) throws IOException {
        DataInputStream in1; //
        DataInputStream in2;
        DataOutputStream out;
         int PUERTO = 9876;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            int i=0;
            while(true){
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");
                in1 = new DataInputStream(cliente.getInputStream());
                out = new DataOutputStream(cliente.getOutputStream());

                String mensaje = in1.readUTF();
                in2 = new DataInputStream(cliente.getInputStream());
                String num = in2.readUTF();
                int n = Integer.parseInt(num);
                String respuesta;
                if(mensaje.equals("a")) respuesta=primos(n);
                else if(mensaje.equals("b")) respuesta=fibo(n);
                else if(mensaje.equals("c")) respuesta=fiboprimos(n);
                else respuesta="Error";

                out.writeUTF(respuesta);
                cliente.close();
                System.out.println("Cliente desconectado");
           }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
