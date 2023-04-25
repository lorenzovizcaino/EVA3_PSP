package boletin2Sockets.ejercicio1;

import boletin2Sockets.ejercicio1.modelo.Asignatura;
import boletin2Sockets.ejercicio1.modelo.Profesor;

public class Cliente {
    public static Profesor[] profesores;
    public static void main(String[] args) {
        CrearDatos();
    }

    private static void CrearDatos() {
        profesores=new Profesor[5];
        Asignatura linguaxedemarcas=new Asignatura(1,"Linguaxe de marcas");
        Asignatura programacion=new Asignatura(2,"Programacion");
        Asignatura Contornos=new Asignatura(3,"Contornos de Desarrollo");
        Asignatura sistemas=new Asignatura(4,"Sistemas informaticos");
        Asignatura basesdedatos=new Asignatura(5,"Bases de datos");
    }
}
