package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
Crea un programa servidor que envie un mensaje a otro programa cliente
y este se lo devuelva en minuscula.
 */
public class Ejercicio2Cliente {
    public static void main(String[] args) {
        String host="localhost";
        int puerto=6000;
        try {
            Socket cliente=new Socket(host, puerto);
            DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());
            String recibido= flujoEntrada.readUTF();
            System.out.println("Recibido del Servidor: "+recibido);
            String enviar=recibido.toLowerCase();

            DataOutputStream flujoSalida=new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF(enviar);

            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
