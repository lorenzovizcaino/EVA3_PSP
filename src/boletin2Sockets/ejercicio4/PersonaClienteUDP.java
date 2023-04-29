package boletin2Sockets.ejercicio4;

import java.io.*;
import java.net.*;

public class PersonaClienteUDP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persona = new Persona(1, "Antonio", "Lorenzo", "Vizcaino", "00000000X");
        System.out.println("Persona en cliente, antes de enviar al servidor:\n" + persona.toString());

        DatagramSocket clienteSocket = new DatagramSocket();
        InetAddress iPServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        byte[] enviar = new byte[1024];
        byte[] recibir = new byte[1024];

        //para transformar persona en bytes
        //escribimos(Output) en el array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(persona);
        enviar = byteArrayOutputStream.toByteArray();

        // ENVIANDO DATAGRAMA AL SERVIDOR
        DatagramPacket envio = new DatagramPacket(enviar, enviar.length, iPServidor, puerto);
        clienteSocket.send(envio);

        // RECIBIENDO DATAGRAMA DEL SERVIDOR
        DatagramPacket recibo = new DatagramPacket(recibir, recibir.length);
        clienteSocket.receive(recibo);
        recibir = recibo.getData();

        //para transformar bytes en persona
        //leemos (Input) el array recibido
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(recibir);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        persona = (Persona) objectInputStream.readObject();
        System.out.println("Persona en cliente, despues de recibir del servidor:\n" + persona.toString());

        clienteSocket.close();
    }
}
