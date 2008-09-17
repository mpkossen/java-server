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
    String path;
    public Server(Control c, InetAddress i, int p, String path) throws IOException {
	super(p,3,i);
        parent = c;
        running = false;
	this.path = path;
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
	String startstr = "Server Gestart @ "+this.getInetAddress().toString()+":"+this.getLocalPort();
	for(int i = 0;i<startstr.length();i++) {
	    System.out.print("=");
	}
        System.out.println("");	
        System.out.println(startstr);
        for(int i = 0;i<startstr.length();i++) {
	    System.out.print("=");
	}
        System.out.println("");	
	running = true; 
        while(running) {
            try {
                request = new Service(this.accept(),path);
                thread = new Thread(request);
                thread.start();
                System.out.println("-> Incoming request");
	    } catch (SocketException e) {
		//System.out.println(e);
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
        
    }
}
