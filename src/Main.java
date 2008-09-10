import java.io.PrintStream;

class Main
{ 
  public static void main(String[] args)
  { 
    myFrame myFrame = new myFrame();
    System.setOut(new PrintStream(new myOutputStream(myFrame)));
    
  }
}