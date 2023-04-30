package boletin2Sockets.ejercicio5;

import boletin2Sockets.ejercicio5.modelo.Alumno;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class UDPCliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner entrada=new Scanner(System.in);
        String idAlumno="";
        DatagramSocket clienteSocket=new DatagramSocket();


        //Datos del servidor al que se va a enviar el mensaje
        InetAddress iPServidor=InetAddress.getLocalHost();
        int puerto=12346;

        ObjectInputStream objectInputStream = null;
        while(!idAlumno.equals("*")){
            System.out.println("Id del alumno a cosultar (* - Para salir)");
            idAlumno="";
            idAlumno=entrada.nextLine();



            //transformamos en byte la cadena introducida por teclado

            byte[] bufferEnvios=new byte[1024];

            bufferEnvios=idAlumno.getBytes();

            if(!idAlumno.equals("*")){


                //Enviamos Datagrama al servidor
                DatagramPacket datagramEnvio=new DatagramPacket(bufferEnvios, bufferEnvios.length,iPServidor,puerto);
                clienteSocket.send(datagramEnvio);

                //Recibimos Datagrama del servidor
                byte[] bufferRecepcion=new byte[1024];
                DatagramPacket datagramRecepcion=new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                clienteSocket.receive(datagramRecepcion);

                //transformar de bytes a Objeto Alumno
                ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bufferRecepcion);
                objectInputStream=new ObjectInputStream(byteArrayInputStream);
                Alumno alumno=(Alumno) objectInputStream.readObject();
                System.out.println(alumno.toString());
            }else{
                //Enviamos Datagrama al servidor
                DatagramPacket datagramEnvio=new DatagramPacket(bufferEnvios, bufferEnvios.length,iPServidor,puerto);
                clienteSocket.send(datagramEnvio);
            }


        }
        System.out.println("Cerrando cliente...");
        objectInputStream.close();
        clienteSocket.close();





    }
}
