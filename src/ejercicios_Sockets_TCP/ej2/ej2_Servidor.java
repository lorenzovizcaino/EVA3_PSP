package ejercicios_Sockets_TCP.ej2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
Usando Sockets TCP realiza un programa cliente que introduzca cadenas por teclado
hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor. El
programa servidor aceptará la conexión de un único cliente y por cada cadena recibida
le devolverá al cliente el número de caracteres de la misma. El programa servidor
finalizará cuando reciba un asterisco como cadena.

 */
public class ej2_Servidor {
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        int cuentaCaracteres;
        ServerSocket servidor=new ServerSocket(puerto);
        Socket cliente=servidor.accept();
        String cadena = "";
        InputStream entrada=null;
        DataInputStream flujoEntrada=null;
        OutputStream salida=null;
        DataOutputStream flujoSalida=null;
        while(!cadena.equalsIgnoreCase("*")){
            entrada=cliente.getInputStream();
            flujoEntrada=new DataInputStream(entrada);
            cadena=flujoEntrada.readUTF();
            cuentaCaracteres=cadena.length();
            salida=cliente.getOutputStream();
            flujoSalida=new DataOutputStream(salida);
            flujoSalida.writeInt(cuentaCaracteres);

        }
        flujoSalida.close();
        salida.close();
        flujoEntrada.close();
        entrada.close();
        cliente.close();
        servidor.close();
    }
}
