package smarthouselib.devices;

import smarthouselib.devices.drivers.IUPSDriver;
import smarthouselib.geo.Zone;

/**
 * @author cameri
 * @since 6/9/13
 */
public class UPS implements IUPS
{
  IUPSDriver driver;
  Zone zone;

  public UPS()
  {

  }

  @Override
  public IUPSDriver getDriver()
  {
    return this.driver;
  }

  @Override
  public void setDriver(IUPSDriver driver)
  {
    this.driver = driver;
  }

  @Override
  public String getStatus()
  {
    return this.driver.getParam("STATUS");
  }

  @Override
  public String getModel()
  {
    return this.driver.getParam("MODEL");
  }

  @Override
  public Zone getZone()
  {
    return this.zone;
  }

  @Override
  public void setZone(Zone zone)
  {
    this.zone = zone;
  }

  @Override
  public float getBatteryCharge()
  {
    String bcharge = this.driver.getParam("BCHARGE");
    if (bcharge != null)
    {
      int spacePos = bcharge.indexOf(" ");
      return Float.parseFloat(bcharge.substring(0, spacePos));
    }

    return 0.0f;
  }

  @Override
  public float getTimeLeftInMinutes()
  {
    return 0;
  }

  @Override
  public float getBatteryVoltage()
  {
    return 0;
  }

  @Override
  public float getLineVoltage()
  {
    return 0;
  }
}
