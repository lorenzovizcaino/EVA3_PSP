package boletin2Sockets.ejercicio1;

import boletin2Sockets.ejercicio1.modelo.Asignatura;
import boletin2Sockets.ejercicio1.modelo.Profesor;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host="localhost";
        int puerto=6000;
        Socket cliente=new Socket(host,puerto);

        Scanner entrada=new Scanner(System.in);
        String cadena="";
        Profesor profesor;
        DataOutputStream dataOutputStream = null;
        ObjectInputStream objectInputStream = null;
        while(!cadena.equals("*")){
            System.out.println("Id del profesor a consultar");
            cadena=entrada.nextLine();
            //cadena=JOptionPane.showInputDialog("Id del profesor a consultar");



            if(!cadena.equals("*")){
                dataOutputStream=new DataOutputStream(cliente.getOutputStream());
                dataOutputStream.writeUTF(cadena);
                objectInputStream=new ObjectInputStream(cliente.getInputStream());
                profesor= (Profesor) objectInputStream.readObject();
                System.out.println("Datos del profesor");
                System.out.println(profesor.toString());


            }else{

            }


        }
        dataOutputStream.close();
        objectInputStream.close();
        cliente.close();

    }


}
