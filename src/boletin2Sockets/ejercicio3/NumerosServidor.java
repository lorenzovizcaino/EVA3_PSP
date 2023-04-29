package boletin2Sockets.ejercicio3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NumerosServidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor Iniciado......");
        Socket cliente = servidor.accept();
        Numeros numero;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(cliente.getInputStream());
        while (true) {
            numero = (Numeros) objectInputStream.readObject();
            if (numero.getNumero() <= 0) {
                System.out.println("Cliente solicita cerrarse, Cliente cerrado.");
                break;
            }
            System.out.println("Cliente envia el numero:" + numero.getNumero());
            numero.setCuadrado((long) Math.pow(numero.getNumero(), 2));
            numero.setCubo((long) Math.pow(numero.getNumero(), 3));
            objectOutputStream.writeObject(numero);
            System.out.println("Enviada respuesta al cliente");
        }
        System.out.println("Servidor cerrando sesion.....");
        objectInputStream.close();
        objectOutputStream.close();
        cliente.close();
        servidor.close();
    }
}
