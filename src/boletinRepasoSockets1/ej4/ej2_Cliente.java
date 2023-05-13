package boletinRepasoSockets1.ej4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
Usando Sockets TCP realiza un programa cliente que introduzca cadenas por teclado
hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor. El
programa servidor aceptará la conexión de un único cliente y por cada cadena recibida
le devolverá al cliente el número de caracteres de la misma. El programa servidor
finalizará cuando reciba un asterisco como cadena.

 */
public class ej2_Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente=new Socket(host, puerto);
        DataOutputStream flujoSalida = null;
        DataInputStream flujoEntrada;
        String cadena = "";
        int numCaracteres;
        Scanner entrada=new Scanner(System.in);
        while(!cadena.equalsIgnoreCase("*")){
            System.out.println("Cadena: ");
            cadena=entrada.nextLine();
            flujoSalida=new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF(cadena);
            flujoEntrada=new DataInputStream(cliente.getInputStream());
            numCaracteres=flujoEntrada.readInt();

            if(!cadena.equalsIgnoreCase("*")){
                System.out.println("La cadena tiene: "+numCaracteres+" caracteres");
            }


        }
        flujoSalida.close();
        cliente.close();
    }
}
