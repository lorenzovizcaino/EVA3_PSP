package ejemplosApuntes.TCP;

import java.io.*;
import java.net.*;
public class ejemplo2Cliente {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
		try{
			Socket Cliente = new Socket(Host, Puerto);
			
			// CREO FLUJO DE SALIDA AL SERVIDOR
			PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
			
			// CREO FLUJO DE ENTRADA AL SERVIDOR
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			
			// FLUJO PARA ENTRADA ESTANDAR
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String cadena, eco="";
			System.out.print("Introduce cadena: ");
			cadena = in.readLine();//lectura por teclado
			while(cadena !=null) {
				fsalida.println(cadena); //envio cadena al servidor
				eco=fentrada.readLine(); //recibo cadena del servidor
				System.out.println(" =>ECO: "+eco);
				System.out.print("Introduce cadena: ");
				cadena = in.readLine();//lectura por teclado
			}
			fsalida. close () ;
			fentrada.close();
			System.out.println("Fin del envio ... ");
			in.close();
			Cliente.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}//
}//