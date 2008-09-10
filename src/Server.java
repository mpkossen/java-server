import javax.net.ServerSocketFactory;

public class Server extends ServerSocket implements Runnable
{
    boolean running = false;
    public Server(){ 
    }
    public void start() {
        running = true;
        System.out.println("=========================");
        System.out.println("Server Gestart");
        System.out.println("=========================");
        this.run();
    }
    public void stop() {
        running = false;
        this.notify();
        System.out.println("=========================");
        System.out.println("Server Gestopt");
        System.out.println("=========================");
    }
    

    public void run() {
        try {
            while (running) {
		
            }
        }
        catch (Exception e) {
        System.out.println(e);
        }
    }
}
