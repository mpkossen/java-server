package server;

import java.awt.event.*;
import java.awt.Color;
import java.io.*;

public class Control implements WindowListener, ActionListener, ItemListener {

    Server s;
    Thread serverthread;
    myFrame frame;
    public boolean serverrunning = false;

    public Control() throws Exception {
	frame = new myFrame(this);

	System.setOut(new PrintStream(new myOutputStream(frame)));
    }

    public void doButton() {
	if (serverrunning) {

	    try {
		s.close();
		s = null;
		frame.setButtonText("GESTOPT", Color.RED);
		serverrunning = !serverrunning;
		serverthread = null;
	    } catch (IOException ex) {
		System.out.println(ex);
	    }

	} else {
	    try {
		s = new Server(this,frame.getCurrentlySelectedAdapter(), 80);
		serverthread = new Thread(s);
		serverthread.start();
		frame.setButtonText("GESTART", Color.GREEN);
		serverrunning = !serverrunning;
	    } catch (IOException ex) {
		System.out.println(ex);
	    }
	}


    }

    /*
     * doChoice() 
     */
    public void doChoice() {
    }

    /*
     * doTextField() 
     */
    public void doTextField() {
    }

    /*
     * start() 
     */
    public void start() {
    }

    /*
     * stop() 
     */
    public void stop() {
    }

    /*
     * restart() 
     */
    public void restart() {
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
