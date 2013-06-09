package smarthouselib.controllers.drivers;

import java.net.Socket;

/**
 * @author cameri
 * @since 6/7/13
 */
public class MochadDriver implements IControllerDriver
{

  static MochadDriver instance;
  String address = "localhost";
  int port = 1099;
  Socket socket;

  protected MochadDriver()
  {
    // exists only to disallow instantiation
  }

  public static MochadDriver getInstance()
  {
    if (instance == null)
    {
      instance = new MochadDriver();
    }
    return instance;
  }

  public void setAddress(String newAddress)
  {
    this.address = newAddress;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setPort(int newPort)
  {
    this.port = newPort;
  }

  public int getPort()
  {
    return this.port;
  }

  public void initialize()
  {

  }

  public void connect()
  {

  }

  @Override
  public String toString()
  {
    return "MochadDriver{" +
      "address='" + address + '\'' +
      ", port=" + port +
      '}';
  }
}