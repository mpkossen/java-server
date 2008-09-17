package server;

import java.io.FileInputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.OutputStream;

/**
 *
 * @author mistermartin75
 */
public class Response 
{
    public Response()
    {
	
    }
    
    public void setCODE()
    {
	
    }
    
    public void setREASON()
    {
	
    }
    
    private static void setBYTES(FileInputStream fis, OutputStream os) throws Exception {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes = 0;
        
        // Copy requested file into the socket's output stream.
        while((bytes = fis.read(buffer)) != -1 )
            os.write(buffer, 0, bytes);
    }
    
    public void send()
    {
	
    }
}
