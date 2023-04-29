package boletin2Sockets.ejercicio4;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PersonaServidorUDP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket=new DatagramSocket(12345);
        System.out.println("Servidor esperando Datagrama...");
        DatagramPacket recibo;

        byte [] bufferRecibir=new byte[1024];
        byte [] bufferEnviar=new byte[1024];
        recibo=new DatagramPacket(bufferRecibir, bufferRecibir.length);
        socket.receive(recibo); //recibo datagrama
        bufferRecibir=recibo.getData();

        //pasamos de byte a objeto
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bufferRecibir);
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
        Persona persona=(Persona) objectInputStream.readObject();
        System.out.println("Persona como nos llega del cliente:\n"+persona.toString());

        //modificamos a la persona
        persona.setDni("76912388C");
        persona.setNombre("Manuel Antonio");
        System.out.println("Persona modificada en Servidor:\n"+persona.toString());

        //pasamos objeto a byte
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(persona);
        bufferEnviar=byteArrayOutputStream.toByteArray();

        //Enviamos datagrama a Cliente
        InetAddress IPOrigen=recibo.getAddress();
        int puerto=recibo.getPort();
        DatagramPacket envio=new DatagramPacket(bufferEnviar, bufferEnviar.length,IPOrigen,puerto);
        socket.send(envio);

        System.out.println("Cerrando servidor...");
        socket.close();



    }
}
