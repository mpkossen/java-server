
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.net.InetAddress;

public class Server 
{
    public Server()
    throws Exception
    {
	ServerSocket ss = new ServerSocket(8080, 80, InetAddress.getLocalHost());
	System.out.println("Accepting: " + ss);
	Socket s = ss.accept();
	System.out.println(s);
	InputStream is = s.getInputStream();
	int c;
    
    	while((c = is.read()) != -1)
	{
	    System.out.print((char)c);
	}
	is.close();
	s.close();
	ss.close();
    }
}
