package server;

import java.net.Socket;
import java.io.*;
import java.util.*;

public class Service implements Runnable {
    Socket socket;
    String path;
    Servlet servlet;
    
    public Service(Socket socket,String accessiblepath) 
    {
	this.socket = socket;
	this.path = accessiblepath;
	path = path.replaceAll("\\\\+", "/");
    }
public void run() {
        try {
            servlet.doGET(socket, path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*private void processRequest() throws Exception {
        
    }*/

    /*private static void sendBytes(FileInputStream fis, OutputStream os) throws Exception {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes = 0;
        
        // Copy requested file into the socket's output stream.
        while((bytes = fis.read(buffer)) != -1 )
            os.write(buffer, 0, bytes);
    }*/
}

