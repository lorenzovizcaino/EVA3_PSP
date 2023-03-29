package ejercicio1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/*
Realiza un programa servidor TCP que acepte 3 clientes. Para cada cliente, mostrar sus puertos local y remoto.
Se debera implementar tambien el programa cliente que se conecte a dicho servidor. Mostrar los puertos locales
y remotos a los que esta conectado su socket, y la direccion IP de la maquina remota a la que se conecta.


 */
public class ejercicio1Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            Socket cliente=new Socket(host, puerto);
            InetAddress inetAddress= cliente.getInetAddress ();
            System.out.println ("Puerto local: "+ cliente.getLocalPort());
            System.out.println ("Puerto Remoto: "+ cliente.getPort());
            System.out.println ("IP Host Remoto: "+ inetAddress.getHostAddress() .toString());
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
