package ejemplosApuntes;

import java.net.*;
import java.io.*;

public class Ejemplo2URL {
  public static void main(String[] args) {
	URL url=null;
	try {
		url = new URL("http://www.elaltozano.es");
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
		
	BufferedReader in;
	try {
		InputStream inputStream = url.openStream();
//		in = new BufferedReader(new InputStreamReader(inputStream));
//		String inputLine;
//		while ((inputLine = in.readLine()) != null)
//			System.out.println(inputLine);
//		in.close();
		int c = 0;
		while((c=inputStream.read())!=-1){
			System.out.print((char)c);
		}
		inputStream.close();

	} catch (IOException e) {e.printStackTrace();}
  }//
}//Ejemplo2URL
