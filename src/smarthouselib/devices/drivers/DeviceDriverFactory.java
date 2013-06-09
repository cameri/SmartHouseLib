package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author cameri
 * @since 6/6/13
 */
public class DeviceDriverFactory
{
  protected DeviceDriverFactory()
  {

  }

  public static X10LampDriver CreateX10LampDriver(IController controller)
  {
    X10LampDriver driver = new X10LampDriver();
    driver.initialize(controller);
    return driver;
  }

  public static X10DimmableLampDriver CreateX10DimmableLampDriver(IController controller)
  {
    X10DimmableLampDriver driver = new X10DimmableLampDriver();
    driver.initialize(controller);
    return driver;
  }
}
