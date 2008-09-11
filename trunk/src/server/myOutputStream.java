package server;

import java.io.OutputStream;
import java.io.IOException;

public class myOutputStream
extends OutputStream
{ 
  private myFrame myFrame = null;
  public myOutputStream(myFrame mf)
  { 
    myFrame = mf;
  }
  public void write(int b)
  throws IOException
  { 
    myFrame.setText(""+(char)b);
  }
}