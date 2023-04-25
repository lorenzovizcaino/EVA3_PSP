package boletinRepasoSockets1.ej3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/*
Realiza un programa servidor TCP que acepte 2 clientes. Mostrar para cada cliente conectados
sus puertos local y remoto. Implementar también el programa cliente, donde se muestren los
puertos locales y remotos a los que se encuentre conectado, asi como la IP de la máquina
remota a la que se conecta.

 */
public class ej3_Cliente {
    public static void main(String[] args) {
        String host="localhost";
        int puerto=6000;
        try {
            Socket cliente=new Socket(host, puerto);
            InetAddress inetAddress=cliente.getInetAddress();
            System.out.println("Puerto local: "+cliente.getLocalPort());
            System.out.println("Puerto remoto: "+cliente.getPort());
            System.out.println("IP maquina remota: "+inetAddress.getHostAddress().toString());
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
