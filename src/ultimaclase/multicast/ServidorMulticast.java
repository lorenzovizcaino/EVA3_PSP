package ultimaclase.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/*
Implementar un programa que actúe como servidor multicast empleando sockets UDP. Dicho servidor,
recogerá de teclado cadenas de texto que introducirá el usuario por teclado y las irá enviando
a todos los clientes conectados al grupo multicast.

El programa cliente, solicitará al usuario su nombre y lo enviará al servidor, que indicará al resto
de usuarios quién se ha conectado. Cada cliente además recibirá todos los mensajes asignados al grupo.
 */
public class ServidorMulticast {
    public static void main(String[] args) throws IOException {

        MulticastSocket multicastSocket=new MulticastSocket();
        int puerto=12345;
        String cadena;
        DatagramPacket paqueteRecibido;
        DatagramPacket paqueteEnviado;
        InetAddress grupo=InetAddress.getByName("225.0.0.1");
        while(true){
            byte [] buffer=new byte[1024];

            paqueteRecibido=new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(paqueteRecibido);
            cadena=new String(paqueteRecibido.getData(),0,paqueteRecibido.getLength());
//            System.out.println("Datos a enviar al grupo");
//            System.out.println(cadena.trim());

            paqueteEnviado=new DatagramPacket(cadena.getBytes(),cadena.length(),grupo,puerto);
            multicastSocket.send(paqueteRecibido);


        }


    }
}
