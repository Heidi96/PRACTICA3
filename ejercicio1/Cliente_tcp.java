
import java.io.*;
import java.net.*;
import java.util.*;


public class Cliente_tcp {
    public static void main(String args[]) {
        
        String host ="localhost";
        try {
            Socket cliente = new Socket(host, 9876);
            DataInputStream in=null;
            DataOutputStream out=null;
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
            System.out.println("a)SERIE PRIMOS b)SERIE FIBONACCI c)SERIE FIBONACCI-PRIMOS d)SALIR");
            Scanner read= new Scanner(System.in);
            String msj= read.next();
            out.writeUTF(msj);
            System.out.println("Ingresa n:");
            String n= read.next();
            out.writeUTF(n);
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            cliente.close();
        }
        catch (Exception e) {System.err.println("Error: " + e );}
    }
}
