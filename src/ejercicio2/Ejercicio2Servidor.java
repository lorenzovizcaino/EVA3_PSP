package ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
Crea un programa servidor que envie un mensaje a otro programa cliente
y este se lo devuelva en minuscula.
 */
public class Ejercicio2Servidor {
    public static void main(String[] args) {
        int puerto=6000;
        try {
            ServerSocket servidor=new ServerSocket(puerto);
            Socket cliente=servidor.accept();
            OutputStream salida=cliente.getOutputStream();
            DataOutputStream flujoSalida=new DataOutputStream(salida);
            flujoSalida.writeUTF("HOLA, QUE TAL ESTAS");

            InputStream entrada=cliente.getInputStream();
            DataInputStream flujoEntrada=new DataInputStream(entrada);
            System.out.println("Recibiendo del Cliente: "+flujoEntrada.readUTF());

            salida.close();
            flujoSalida.close();
            entrada.close();
            flujoEntrada.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

