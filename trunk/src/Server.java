

public class Server implements Runnable
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
        System.out.println("=========================");
        System.out.println("Server Gestopt");
        System.out.println("=========================");
    }
    

    public void run() {
        //while (running) {
            
        //}
    }
}
