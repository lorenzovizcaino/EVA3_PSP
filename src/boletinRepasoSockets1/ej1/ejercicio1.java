package boletinRepasoSockets1.ej1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
Realiza un programa Java que admita desde consola nombres de máquinas o direcciones IP y
vaya mostrando por pantalla información sobre ellas, haciendo uso de la clase InetAddress.
 */
public class ejercicio1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress dir=null;
        String maquina1="localhost";
        dir=InetAddress.getByName(maquina1);
        InformacionMaquinas(dir);

        String maquina2="192.168.1.238";
        dir=InetAddress.getByName(maquina2);
        InformacionMaquinas(dir);

        String maquina3="DESKTOP-EQI6B9K";
        dir=InetAddress.getByName(maquina3);
        InformacionMaquinas(dir);

    }

    private static void InformacionMaquinas(InetAddress dir) {
        System.out.println("Direccion IP de la maquina: "+dir.getHostAddress());
        System.out.println("Nombre del host de la maquina: "+dir.getHostName());
        System.out.println("Nombre canonico de la maquina: "+dir.getCanonicalHostName());
        System.out.println("toString de la maquina: "+ dir.toString());
        System.out.println();


    }
}
