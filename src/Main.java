
import java.net.InetAddress;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
	InetAddress localhost = InetAddress.getLocalHost();
	System.out.println(info(localhost));
	InetAddress[] ip = InetAddress.getAllByName(localhost.getHostName());
	for (int i=0; i<ip.length; i++)
	    System.out.println(info(ip[i]));
    }

    private static String info(InetAddress ia)
    {
	return "\n"+ia
	+ "\nHostName="+ia.getHostName()
	+ "\nCanonicalHostName="+ia.getCanonicalHostName()
	+ "\nHostAddress="+ia.getHostAddress();
    }

}
