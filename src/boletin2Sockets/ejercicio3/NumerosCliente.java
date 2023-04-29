package boletin2Sockets.ejercicio3;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class NumerosCliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000;
        try {
            Socket cliente = new Socket(host, puerto);
            System.out.println("Cliente iniciado...");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(cliente.getInputStream());
            Scanner entrada = new Scanner(System.in);
            Numeros numero;
            int num = 0;
            while (true) {
                System.out.println("Dame Numero");
                num = entrada.nextInt();

                numero = new Numeros(num);
                if (num <= 0) {
                    System.out.println("Ha solicitado cerrar el cliente");
                    objectOutputStream.writeObject(numero);
                    break;
                }
                objectOutputStream.writeObject(numero);
                numero = (Numeros) objectInputStream.readObject();
                System.out.println(numero.toString());
            }
            System.out.println("Cliente cerrado...");
            objectInputStream.close();
            objectOutputStream.close();
            cliente.close();
        } catch (ConnectException e) {
            System.out.println("El servidor no esta iniciado");
            //falta excepcion de si estando el servidor ejecutándose ocurre algún error en el cliente,
            // o este finaliza inesperadamente, etc.
        }


    }
}
