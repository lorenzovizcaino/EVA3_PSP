package boletin2Sockets.ejercicio5;

import boletin2Sockets.ejercicio5.modelo.Alumno;
import boletin2Sockets.ejercicio5.modelo.Curso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServidor {
    private static Alumno[] alumnos=new Alumno[5];
    public static void main(String[] args) throws IOException {
        rellenarDatos();
        Alumno alumno = null;
        boolean encontrado;

        DatagramSocket socket=new DatagramSocket(12346);
        System.out.println("Servidor iniciado...");
        DatagramPacket datagramPacketRecibir;

        while(true){
            byte [] bufferRecibir=new byte[1024];
            byte [] bufferEnviar=new byte[1024];
            encontrado=false;
            datagramPacketRecibir=new DatagramPacket(bufferRecibir, bufferRecibir.length);
            socket.receive(datagramPacketRecibir);

            bufferRecibir= datagramPacketRecibir.getData();
            String rec=new String(datagramPacketRecibir.getData()).trim();
            System.out.println("El cliente ha solicitado la informacion del alumno con id: "+rec);
            if(!rec.equals("*")){
                for (Alumno al:alumnos) {
                    if(al.getIdAlumno().equalsIgnoreCase(rec)){
                        alumno=al;
                        encontrado=true;
                        System.out.println("Se envia la informacion del alumno solicitado al cliente.");
                    }
                }
                if(!encontrado){
                    alumno=new Alumno();
                    System.out.println("No existe ningun alumno con ese Id, se envia un alumno vacio.");
                }
                //mandamos el alumno en bytes al cliente
                //primero convertimos el alumno a bytes
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(alumno);
                bufferEnviar=byteArrayOutputStream.toByteArray();
                //lo mandamos

                InetAddress iPorigen=datagramPacketRecibir.getAddress();
                int puerto=datagramPacketRecibir.getPort();
                DatagramPacket datagramPacketEnviar=new DatagramPacket(bufferEnviar, bufferEnviar.length, iPorigen,puerto);
                socket.send(datagramPacketEnviar);
            }else{
                System.out.println("El cliente ha solicitado salir...");
                break;
            }
        }
        System.out.println("Cerrando Servidor...");
        socket.close();

    }

    private static void rellenarDatos() {

        Curso curso1=new Curso("1DAM","1 Desarrollo Aplicaciones Multiplataforma");
        Curso curso2=new Curso("2DAM","2 Desarrollo Aplicaciones Multiplataforma");
        Curso curso3=new Curso("1DAW","2 Desarrollo Aplicaciones Web");
        Curso curso4=new Curso("2DAW","2 Desarrollo Aplicaciones Web");
        Alumno alumno1=new Alumno("1","Manuel Antonio", curso2,9);
        Alumno alumno2=new Alumno("2","Andrea", curso1,4);
        Alumno alumno3=new Alumno("3","Maria Sofia", curso2,6);
        Alumno alumno4=new Alumno("4","Ignacio", curso3,8);
        Alumno alumno5=new Alumno("5","Jesus", curso4,9);
        alumnos[0]=alumno1;
        alumnos[1]=alumno2;
        alumnos[2]=alumno3;
        alumnos[3]=alumno4;
        alumnos[4]=alumno5;



    }
}
