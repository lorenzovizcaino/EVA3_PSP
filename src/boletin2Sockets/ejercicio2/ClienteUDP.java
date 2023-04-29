package boletin2Sockets.ejercicio2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;
import java.util.Scanner;

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
public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        Scanner entrada =new Scanner(System.in);
        String cadena="";
        InetAddress inetAddress=InetAddress.getLocalHost();
        int puerto=12345;//puerto al que envio;
        byte[] mensaje;
        byte[] recibido;

        DatagramPacket envio;
        DatagramPacket recibo;
        DatagramSocket socket=new DatagramSocket();
        socket.setSoTimeout(5000);
        while(!cadena.equals("*")){
            System.out.println("Introduce una cadena de texto");
            cadena=entrada.nextLine();
            mensaje=new byte[1024];
            mensaje=cadena.getBytes();
            envio=new DatagramPacket(mensaje, mensaje.length,inetAddress,puerto);
            socket.send(envio);

            //recibiendo del servidor
            recibido=new byte[1024];
            recibo=new DatagramPacket(recibido, recibido.length);

            try{
                socket.receive(recibo);
                String cadenaRecibida=new String(recibo.getData()).trim();
                System.out.println("Cadena devuelta en MAYUSCULAS: "+cadenaRecibida);
            }catch (InterruptedIOException e){
                System.out.println("\tPaquete perdido");
            }


        }
        envio=new DatagramPacket("*".getBytes(),"*".getBytes().length,inetAddress,puerto);
        socket.send(envio);
        socket.close();
        System.out.println("Fin del cliente");

    }
}
