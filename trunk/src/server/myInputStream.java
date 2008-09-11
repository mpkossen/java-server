package server;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.SocketException;

class myInputStream
extends FilterInputStream
{
  myInputStream(InputStream is)
  {
    super(is);
  }

  public String readLine()
  throws IOException
  {
    int c1 = read();
    if (c1 == -1) throw new IOException("eof(1)");

    int c2 = read();
    if (c2 == -1) throw new IOException("eof(2)");

    String ret = "";
    while (c1 != '\r' || c2 != '\n')
    {
      ret = ret + (char)c1;
      c1 = c2;
      c2 = read();
      if (c2 == -1) throw new IOException("eof(3)");
    }
    return ret.length()>0 ? ret : null;
  }
} 
