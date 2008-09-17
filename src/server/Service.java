package server;

import java.net.Socket;
import java.io.*;
import java.util.*;

public class Service implements Runnable {
    final static String CRLF ="\r\n";
    final static String HTTPVERSION = "HTTP/1.0";
    Socket socket;
    String path;
    public Service(Socket socket,String accessiblepath) {
    this.socket = socket;
    this.path = accessiblepath;
    path = path.replaceAll("\\\\+", "/");
    
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

    private static void sendBytes(FileInputStream fis, OutputStream os) throws Exception {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes = 0;
        
        // Copy requested file into the socket's output stream.
        while((bytes = fis.read(buffer)) != -1 )
            os.write(buffer, 0, bytes);
    }
}

