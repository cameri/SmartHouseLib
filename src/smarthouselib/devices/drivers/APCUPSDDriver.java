package smarthouselib.devices.drivers;

import smarthouselib.io.ProcessHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cameri
 * @since 6/9/13
 */
public class APCUPSDDriver implements IUPSDriver
{
  long lastUpdate;
  String address;
  int port;
  String statusCache;
  String apcaccessPath;
  int updateInterval;
  Map<String, String> map = new HashMap<String, String>();


  public APCUPSDDriver()
  {
    lastUpdate = 0;
    address = "localhost";
    apcaccessPath = "/usr/bin/apcaccess";
    port = 3551;
    updateInterval = 1000;
    statusCache = "";
  }

  @Override
  public void initialize()
  {
    this.updateStatusCache();
  }

  @Override
  public void setAddress(String address)
  {
    this.address = address;
  }

  @Override
  public String getAddress()
  {
    return this.address;
  }

  @Override
  public void setPort(int port)
  {
    this.port = port;
  }

  @Override
  public int getPort()
  {
    return this.port;
  }

  public int getUpdateInterval()
  {
    return this.updateInterval;
  }

  public void setUpdateInterval(int updateInterval)
  {
    this.updateInterval = updateInterval;
  }

  void updateStatusCache()
  {
    String cmd = String.format("%s status %s:%d", apcaccessPath, address, port);
    String output = ProcessHelper.exec(cmd);

    if (output != null && output.length() > 0)
    {
      this.statusCache = output;

      // Iterate over every line
      for (String s : output.split(System.lineSeparator()))
      {
        int pos = s.indexOf(":");
        if (pos > -1)
        {
          String key = s.substring(0, pos).trim();
          String value = s.substring(pos + 2).trim();
          map.put(key, value);
        }
      }
      this.lastUpdate = System.currentTimeMillis();
    }

  }

  @Override
  public String getParam(String param)
  {
    // Only update our information every second
    if (System.currentTimeMillis() - this.lastUpdate >= this.updateInterval)
      this.updateStatusCache();

    return map.get(param);
  }


}
