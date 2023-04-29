package boletin2Sockets.ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
Crea un programa cliente usando sockets UDP que envíe el texto escrito desde la entrada
estándar al servidor. El servidor le devolverá la cadena en mayúsculas. El proceso de entrada
de datos finalizará cuando el cliente introduzca un asterisco.
Crea un programa servidor que reciba cadenas de caracteres, las muestre en pantalla y se las
envíe al emisor en mayúscula. El proceso servidor finalizará cuando reciba un asterisco.

Establece un tiempo de espera de 5000ms con el método setSoTimeout para hacer que el
método receive() del programa cliente se bloquee. Pasado ese tiempo, controlar si no se
reciben datos lanzando la excepción InterruptedIOException, en cuyo caso visualiza un
mensaje indicando que el paquete se ha perdido.

 */
public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        byte[] buferRecepcion;
        byte[] buferEnvio;

        DatagramSocket socket=new DatagramSocket(12345);
        System.out.println("Servidor esperando Datagrama..........");
        DatagramPacket recibo, envio;
        int bytesRecibidos;
        String cadena="";
        while(!cadena.trim().equals("*")){
            buferRecepcion=new byte[1024];
            recibo = new DatagramPacket(buferRecepcion,buferRecepcion.length);
            socket.receive(recibo);
            bytesRecibidos=recibo.getLength();
            cadena=new String(recibo.getData()).trim();
            System.out.println("Servidor recibe: "+cadena);
            InetAddress inetAddress=recibo.getAddress();
            int puerto=recibo.getPort();

            String cadenaMayusculas=cadena.trim().toUpperCase();
            buferEnvio=new byte[1024];
            buferEnvio=cadenaMayusculas.getBytes();
            envio=new DatagramPacket(buferEnvio, buferEnvio.length,inetAddress,puerto);
            socket.send(envio);

        }
        System.out.println("Cerrando Conexion...");
        socket.close();
    }
}
