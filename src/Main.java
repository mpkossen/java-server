
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mistermartin75
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
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
