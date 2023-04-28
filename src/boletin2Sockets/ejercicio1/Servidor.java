package boletin2Sockets.ejercicio1;

import boletin2Sockets.ejercicio1.modelo.Asignatura;
import boletin2Sockets.ejercicio1.modelo.Especialidad;
import boletin2Sockets.ejercicio1.modelo.Profesor;
import boletin2Sockets.ejercicio1.modelo.SocketId;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static Profesor[] profesores;
    public static Asignatura[] asignaturas1;
    public static Asignatura[] asignaturas2;
    public static Asignatura[] asignaturas3;
    public static Asignatura[] asignaturas4;

    public static void main(String[] args) throws IOException {
        crearDatos();
        int puerto = 6000;
        int id = 0, idProfesor = 0;
        String cadena = "";
        Profesor profesor = null;
        boolean encontrado = false;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor Iniciado...");
        DataInputStream dataInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        while (true) {
            Socket cliente = servidor.accept();
            id++;
            System.out.println("Cliente con id:" + id);
            while (!cadena.equals("*")) {
                encontrado = false;
                dataInputStream = new DataInputStream(cliente.getInputStream());
                cadena = dataInputStream.readUTF();
                if (!cadena.equals("*")) {
                    System.out.println("Cliente con id: " + id + " Pide datos de profesor con identificador " + cadena);
                    idProfesor = Integer.valueOf(cadena);
                    for (int i = 0; i < profesores.length; i++) {
                        if (profesores[i].getIdProfesor() == idProfesor) {
                            profesor = profesores[i];
                            encontrado = true;
                        }
                    }
                    if (encontrado == false) {
                        profesor = new Profesor();
                    }
                    objectOutputStream = new ObjectOutputStream(cliente.getOutputStream());
                    objectOutputStream.writeObject(profesor);
                } else {
                    System.out.println("El cliente con id: " + id + " finaliza sesion");
                    objectOutputStream.close();
                    dataInputStream.close();
                    cliente.close();
                }
            }
            cadena = "";
        }
    }

    private static void crearDatos() {
        profesores = new Profesor[5];
        asignaturas1 = new Asignatura[3];
        asignaturas2 = new Asignatura[3];
        asignaturas3 = new Asignatura[3];
        asignaturas4 = new Asignatura[3];
        Asignatura lm = new Asignatura(1, "Linguaxe de marcas");
        Asignatura prog = new Asignatura(2, "Programacion");
        Asignatura cs = new Asignatura(3, "Contornos de Desarrollo");
        Asignatura si = new Asignatura(4, "Sistemas informaticos");
        Asignatura bd = new Asignatura(5, "Bases de datos");
        Asignatura psp = new Asignatura(6, "Programacion de Servicios y Procesos");
        Asignatura ad = new Asignatura(7, "Acceso a datos");
        Asignatura di = new Asignatura(8, "Diseño de interfaces");
        Asignatura pmdm = new Asignatura(9, "Programacion de moviles");
        Asignatura sxe = new Asignatura(10, "Sistemas de xestion");
        Asignatura fol = new Asignatura(11, "FOL");
        Asignatura eyp = new Asignatura(12, "Empresa e iniciativa emprendedora");
        Especialidad esp_informatica = new Especialidad(1, "Informatica");
        asignaturas1[0] = lm;
        asignaturas1[1] = prog;
        asignaturas1[2] = cs;
        asignaturas2[0] = si;
        asignaturas2[1] = bd;
        asignaturas2[2] = psp;
        asignaturas3[0] = ad;
        asignaturas3[1] = di;
        asignaturas3[2] = pmdm;
        asignaturas4[0] = sxe;
        asignaturas4[1] = fol;
        asignaturas4[2] = eyp;

        profesores[0] = new Profesor(1, "Juan Luis Ruiperez", asignaturas1, esp_informatica);
        profesores[1] = new Profesor(2, "Ana Dominguez Lorenzo", asignaturas1, esp_informatica);
        profesores[2] = new Profesor(3, "Santiago Couto Martinez", asignaturas1, esp_informatica);
        profesores[3] = new Profesor(4, "Emilio Claro Vazquez", asignaturas1, esp_informatica);
        profesores[4] = new Profesor(5, "Nuria Alvarez Dominguez", asignaturas1, esp_informatica);
    }
}
