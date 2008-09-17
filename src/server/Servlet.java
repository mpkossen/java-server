package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author mistermartin75
 */
public class Servlet 
{
    Socket socket;
    String path;
    final static String CRLF ="\r\n";
    final static String HTTPVERSION = "HTTP/1.0";
    
    public Servlet()
    {
	
    }
    
    public void doGET(Socket socket, String path) throws IOException
    {
	InputStream is = this.socket.getInputStream();
        DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
	Vector<String> clientrequest = new Vector<String>();
	String s = br.readLine();
	while(!s.isEmpty()) {
	    clientrequest.add(s);
	    System.out.println("\t"+s);
	    s = br.readLine();
	}
	int statusNummer = 400;
	String statusLine = "HTTP/1.0 1337 Nigger Not Found" + CRLF; 
        String contentTypeLine = "";
        String entityBody = "";
	String filename = "";
	
	for(int i=0;i<clientrequest.size();i++) {
	    if (clientrequest.elementAt(i).contains("GET")) {
		filename = path+clientrequest.elementAt(i).split(" ")[1];
		filename = filename.replaceAll("/+", "/");
		if (filename.endsWith("/")) {
		    filename += "index.html";
		}
		statusNummer = 200;
		System.out.println("GET request: bestand "+filename);
		File f = new File(filename);
		if (!f.exists()) {
		    statusNummer = 404;
		}
	    }
	    
	}
	
	
	String requestLine = clientrequest.elementAt(0);

	switch (statusNummer) {
	    case 200: statusLine = HTTPVERSION+" 200 OK";break;
	    case 404: statusLine = HTTPVERSION+" 404 File Not Found";break;
	    default: statusLine = HTTPVERSION+" 400 Bad Request";break;
	}

        
	String returncrap = statusLine+contentTypeLine+entityBody;
        // Send the status line.
        os.writeBytes(returncrap);
	System.out.println("Response:\n\t"+statusLine+"\t"+contentTypeLine+"\t"+entityBody);
        
        // Send the content type line.
       // os.writeBytes(contentTypeLine);
        
        // Send a blank line to indicate the end of the header lines.
        os.writeBytes(CRLF);
        
        
        //Close the streams
        os.close();
        br.close();
        socket.close();
    }
}
