package smarthouselib.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cameri
 * @since 6/9/13
 */
public class ProcessHelper
{
  protected ProcessHelper()
  {

  }

  public static synchronized String exec(String cmd)
  {
    String output;
    StringBuilder sb = new StringBuilder();
    try
    {
      Process p = Runtime.getRuntime().exec(cmd);
      String sep = System.lineSeparator();
      String line;
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      while ((line = reader.readLine()) != null)
      {
        sb.append(line + sep);
      }
      return sb.toString();
    } catch (IOException ex)
    {
      return null;
    }
  }


}
