package server;

import java.net.Socket;
import java.io.*;
import java.util.*;

public class Service implements Runnable {
    final static String CRLF ="\r\n";
    Socket socket;
    public Service(Socket socket) {
    this.socket = socket;
    }
public void run() {
        try {
            processRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
private void processRequest() throws Exception {
        InputStream is = this.socket.getInputStream();
        DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
	Vector<String> crap = new Vector<String>();
	String s = br.readLine();
	while(!s.isEmpty()) {
	    crap.add(s);
	    System.out.println("\t"+s);
	    s = br.readLine();
	}
	
	String requestLine = crap.elementAt(0);

	String statusLine = "HTTP/1.0 1337 Nigger Not Found" + CRLF; 
        String contentTypeLine = "NONE";
        String entityBody = "\n\n nigger nigger";
        
        // Send the status line.
        os.writeBytes(statusLine);
        
        // Send the content type line.
        os.writeBytes(contentTypeLine);
        
        // Send a blank line to indicate the end of the header lines.
        os.writeBytes(CRLF);
        
        
        //Close the streams
        os.close();
        br.close();
        socket.close();
    }

    private static void sendBytes(FileInputStream fis, OutputStream os) throws Exception {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes = 0;
        
        // Copy requested file into the socket's output stream.
        while((bytes = fis.read(buffer)) != -1 )
            os.write(buffer, 0, bytes);
    }
}

