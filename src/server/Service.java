package server;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mistermartin75
 */
public class Service extends Thread 
{
    public Server s;
    public Response rs;
    public Request rq;
    public Servlet sl;
    
    public Service(Server s)
    {
	this.s = s;
	rs = new Response();
	rq = new Request();
	sl = new Servlet();
    }
    
    public void run()
    {
	
    }
}
