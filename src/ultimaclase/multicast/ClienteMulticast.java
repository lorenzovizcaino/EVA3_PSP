package ultimaclase.multicast;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
Implementar un programa que actúe como servidor multicast empleando sockets UDP. Dicho servidor,
recogerá de teclado cadenas de texto que introducirá el usuario por teclado y las irá enviando
a todos los clientes conectados al grupo multicast.

El programa cliente, solicitará al usuario su nombre y lo enviará al grupo, indicando que se ha conectado.
Cada cliente además recibirá todos los mensajes asignados al grupo.
 */
public class ClienteMulticast {
    public static void main(String[] args) throws IOException {
        Scanner entrada=new Scanner(System.in);
        String cadena="";
        int puerto=12345;
        DatagramPacket envio;
        DatagramPacket recibo;
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress grupo=InetAddress.getByName("225.0.0.1");
        SocketAddress sock = new InetSocketAddress(grupo, puerto);
        datagramSocket.joinGroup(sock, NetworkInterface.getByInetAddress(grupo));
        byte[] buffer=new byte[1024];
        System.out.println("Nombre");
        cadena=entrada.nextLine();
        buffer=cadena.getBytes();
        envio=new DatagramPacket(buffer, buffer.length,grupo,puerto);
        datagramSocket.send(envio);


        byte[] recibido=new byte[1024];
        recibo=new DatagramPacket(recibido, recibido.length);

        datagramSocket.receive(recibo);
        String cadenaRecibida=new String(recibo.getData()).trim();
        System.out.println("CADENA RECIBIDA: "+cadenaRecibida);

        //datagramSocket.close();





    }
}
