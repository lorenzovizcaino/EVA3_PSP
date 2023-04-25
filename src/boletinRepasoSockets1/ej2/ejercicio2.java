package boletinRepasoSockets1.ej2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
Implementa un programa que recoja de teclado una URL (con el formato
http://www.sitioweb.dom) y abra una conexión a dicho sitio Web, mostrando por pantalla el
código HTML de su página inicial.
 */
public class ejercicio2 {
    public static void main(String[] args) {
        InputStream inputStream=null;
        try {
            URL url=new URL ("https://www.registradores.org/");
            inputStream=url.openStream();
            int c=0;
            while((c=inputStream.read())!=-1){
                System.out.print((char)c);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
