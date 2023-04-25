package ejercicios_Sockets_TCP.ej1;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/*
Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a cada
cliente un mensaje indicando el número de cliente que es. Este número será 1, 2 o 3.
El cliente mostrará el mensaje recibido. Cambia el programa para que lo haga para N
clientes, siendo N un parámetro que tendrás que definir en el programa.

 */
public class ej1_Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente=new Socket(host,puerto);
        DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());
        System.out.println("Numero de cliente: "+flujoEntrada.readInt());

        flujoEntrada.close();
        cliente.close();
    }
}
