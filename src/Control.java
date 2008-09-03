/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;

public class Control implements WindowListener, ActionListener, ItemListener
{
    public Control() throws Exception
    {
	Server s = new Server();
	GUI_Frame frame = new GUI_Frame();
	myOutputStream os = new myOutputStream();
    }
    
    /*
     * doButton() 
     */
    public void doButton()
    {
	
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
