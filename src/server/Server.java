package server;

import java.io.IOException;
import java.net.*;
import java.net.InetAddress;

public class Server extends ServerSocket implements Runnable
{
    public Server(int p) throws IOException{  
        super(p, 50, InetAddress.getLocalHost());
    }   
    

    public void run() {
        System.out.println("Server Gestart");
        System.out.println("=========================");
            while (!Thread.interrupted()) {
                try{
		Socket s = accept(); 
                
                }
                catch(Exception e){System.out.println(e);}
            }
        System.out.println("=========================");
        System.out.println("Server Gestopt");
        
    }
}
