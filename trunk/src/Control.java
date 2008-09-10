import java.awt.event.*;
import java.awt.Color;
import java.io.PrintStream;
import java.io.*;

public class Control implements WindowListener, ActionListener, ItemListener
{
    Server s;
    Thread serverthread;
    myFrame frame;
    boolean serverrunning = false;
    public Control() throws Exception
    {
	frame = new myFrame(this);
        System.setOut(new PrintStream(new myOutputStream(frame)));
    }
    public void doButton()
    {
	if (serverrunning) {
            frame.setButtonText("GESTOPT", Color.RED);
            serverthread.interrupt();
            serverthread = null;
            }
        else {
            
            try {
            serverthread = new Thread(new Server(frame.getPort()));
            serverthread.start();
            frame.setButtonText("GESTART", Color.GREEN);
                }
            catch(IOException e) {
                System.out.println(e);
            }
            }
        serverrunning = !serverrunning;
        }
    
    /*
     * doChoice() 
     */
    public void doChoice()
    {
	
    }
    
    /*
     * doTextField() 
     */
    public void doTextField()
    {
	
    }
    
    /*
     * start() 
     */
    public void start()
    {
    }
    
    /*
     * stop() 
     */
    public void stop()
    {

    }
    
    /*
     * restart() 
     */
    public void restart()
    {
	
    }

    public void windowOpened(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosing(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosed(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowIconified(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeiconified(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowActivated(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeactivated(WindowEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void actionPerformed(ActionEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void itemStateChanged(ItemEvent arg0) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
