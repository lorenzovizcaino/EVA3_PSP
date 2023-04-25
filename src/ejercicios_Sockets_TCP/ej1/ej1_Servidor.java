package ejercicios_Sockets_TCP.ej1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a cada
cliente un mensaje indicando el número de cliente que es. Este número será 1, 2 o 3.
El cliente mostrará el mensaje recibido. Cambia el programa para que lo haga para N
clientes, siendo N un parámetro que tendrás que definir en el programa.

 */
public class ej1_Servidor {
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        int contador=0;
        int numClientes=5;
        ServerSocket servidor=new ServerSocket(puerto);
        Socket [] sockets=new Socket[numClientes];
        OutputStream salida=null;
        DataOutputStream flujoSalida=null;
        for (int i = 0; i <numClientes ; i++) {
            contador++;
            sockets [i]=servidor.accept();
            salida = sockets [i].getOutputStream();
            flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeInt(contador);
            sockets [i].close();

        }

        flujoSalida.close();
        salida.close();
        servidor.close();


    }
}
