package ejercicio2;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "localhost";
		try {
			Socket cliente =new Socket(host, 9876);
			DataInputStream in= null;
			DataOutputStream out = null;
			in= new DataInputStream(cliente.getInputStream());
			out= new DataOutputStream(cliente.getOutputStream());
			System.out.println("1)CandidatoA 2)CandidatoB 3)Mostrar");
			Scanner read = new Scanner(System.in);
			String msj=read.next();
			out.writeUTF(msj);
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			cliente.close();
		} catch (Exception e) {
			System.err.println("Error: "+ e);
		}
	}

}
