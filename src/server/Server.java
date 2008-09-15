package server;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends ServerSocket implements Runnable
{
    Service request;
    Control parent;
    Thread thread;
    boolean running;
    public Server(Control c, InetAddress i, int p) throws IOException {
	super(p,3,i);
        parent = c;
        running = false;
    }   
    @Override
    public void close() throws IOException{
        running = false;
	System.out.println("=========================");
        System.out.println("Server Gestopt");
	System.out.println("=========================");	
	super.close();
    }

    public void run() {
        System.out.println("=========================");	
        System.out.println("Server Gestart");
        System.out.println("=========================");
	running = true;
        while(running) {
            try {
                request = new Service(this.accept());
                thread = new Thread(request);
                thread.start();
                System.out.println("-> \tIncoming request");
	    } catch (SocketException e) {
		//System.out.println(e);
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
        
    }
}
