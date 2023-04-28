package boletin2Sockets.ejercicio1.modelo;

import java.net.Socket;

public class SocketId {
    private Socket socket;
    private int id;

    public SocketId(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
