package smarthouselib.devices.drivers;

/**
 * @author cameri
 * @since 6/9/13
 */
public class UPSDriverFactory
{
  protected UPSDriverFactory()
  {

  }

  public static IUPSDriver CreateAPCUPSDriver(String address, int port)
  {
    APCUPSDDriver driver = new APCUPSDDriver();
    driver.setAddress(address);
    driver.setPort(port);
    driver.initialize();
    return driver;
  }
}
