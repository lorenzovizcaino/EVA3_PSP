package ejercicio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Realiza un programa servidor TCP que acepte 3 clientes. Para cada cliente, mostrar sus puertos local
y remoto.
Se debera implementar tambien el programa cliente que se conecte a dicho servidor. Mostrar los puertos
locales y remotos a los que esta conectado su socket, y la direccion IP de la maquina remota
a la que se conecta.


 */
public class ejercicio1Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        try {
            ServerSocket servidor=new ServerSocket(numeroPuerto);
            Socket cliente1=servidor.accept();
            int PuertoRemotocliente1=cliente1.getPort();
            System.out.println("Puerto local del cliente1: "+PuertoRemotocliente1);
            int PuertoLocalcliente1=cliente1.getLocalPort();
            System.out.println("Puerto remoto del cliente1: "+PuertoLocalcliente1);

            Socket cliente2=servidor.accept();
            int PuertoRemotocliente2=cliente2.getPort();
            System.out.println("Puerto local del cliente2: "+PuertoRemotocliente2);
            int PuertoLocalcliente2=cliente2.getLocalPort();
            System.out.println("Puerto remoto del cliente2: "+PuertoLocalcliente2);

            Socket cliente3=servidor.accept();
            int PuertoRemotocliente3=cliente3.getPort();
            System.out.println("Puerto local del cliente3: "+PuertoRemotocliente3);
            int PuertoLocalcliente3=cliente3.getLocalPort();
            System.out.println("Puerto remoto del cliente3: "+PuertoLocalcliente3);

            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
