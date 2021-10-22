package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream in;
		DataOutputStream out;
		//int[] Vector=new int [50];
		int PUERTO=9876;
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");
			int i=0;
			while (true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado");
				in= new DataInputStream(cliente.getInputStream());
				out= new DataOutputStream(cliente.getOutputStream());
				
				String mensaje = in.readUTF(); 
				int c1=0,c2=0,c3=0;  
				if (mensaje.equals("1")) {
					c1++;out.writeUTF("VOTO RECIBIDO");
				} 
				if (mensaje.equals("2")) {
					c2++;out.writeUTF("VOTO RECIBIDO");
				} 
				if (mensaje.equals("3")) {
					c3++;out.writeUTF("VOTO RECIBIDO");
				} 
				if (mensaje.equals("4")) {
					if (c1>=c2 && c1>=c3) {
						out.writeUTF("GANA CANDIDATO 1");
					}
					if (c2>c1 && c2>c3) {
						out.writeUTF("GANA CANDIDATO 2");
					}
					if (c3>=c1 && c2>=c3) {
						out.writeUTF("GANA CANDIDATO 3");
					}
				} 
				cliente.close();
				System.out.println("CLIENTE DESCONECTADO");
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
		}
	}

}
