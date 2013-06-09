package smarthouselib.devices.drivers;

/**
 * @author cameri
 * @since 6/9/13
 */
public interface IUPSDriver
{
  void initialize();

  void setAddress(String address);

  String getAddress();

  void setPort(int port);

  int getPort();

  String getParam(String param);
}
