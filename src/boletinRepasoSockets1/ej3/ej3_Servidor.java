package boletinRepasoSockets1.ej3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Realiza un programa servidor TCP que acepte 2 clientes. Mostrar para cada cliente conectados
sus puertos local y remoto. Implementar también el programa cliente, donde se muestren los
puertos locales y remotos a los que se encuentre conectado, asi como la IP de la máquina
remota a la que se conecta.

 */
public class ej3_Servidor {
    public static void main(String[] args) {
        int numeroPuerto=6000;
        try {
            ServerSocket servidor=new ServerSocket(numeroPuerto);
            Socket cliente1=servidor.accept();
            System.out.println("Puerto local del cliente1: "+cliente1.getLocalPort());
            System.out.println("Puerto remoto del cliente1: "+cliente1.getPort());

            Socket cliente2=servidor.accept();
            System.out.println("Puerto local del cliente2: "+cliente2.getLocalPort());
            System.out.println("Puerto remoto del cliente2: "+cliente2.getPort());

            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
