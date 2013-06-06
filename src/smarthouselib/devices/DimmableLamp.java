package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;

/**
 * @author cameri
 * @since 6/5/13
 */
public class DimmableLamp extends Lamp implements IDevice, IDimmable
{

  public String ID;
  DeviceState currentState = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[]{DeviceCapabilities.Dimmable};
  IDeviceDriver driver;
  int brightness;
  int minBrightness;
  int maxBrightness;

  @Override
  public void initialize(IDeviceDriver driver)
  {
    this.driver = driver;
    this.brightness = 0;
    this.minBrightness = 0;
    this.maxBrightness = 255;
  }

  @Override
  public void setID(String ID)
  {
    this.ID = ID;
  }

  @Override
  public String getID()
  {
    return this.ID;
  }

  @Override
  public void setState(DeviceState newState)
  {
    this.currentState = newState;
  }

  @Override
  public DeviceState getState()
  {
    return this.currentState;
  }

  @Override
  public DeviceCapabilities[] getCapabilities()
  {
    return this.capabilities;
  }

  @Override
  public void setMinimumBrightness(int minBrightness)
  {
    this.minBrightness = minBrightness;
  }

  @Override
  public int getMinimumBrightness()
  {
    return this.minBrightness;
  }

  @Override
  public void setMaximumBrightness(int maxBrightness)
  {
    this.maxBrightness = maxBrightness;
  }

  @Override
  public int getMaximumBrightness()
  {
    return this.maxBrightness;
  }

  @Override
  public void setBrightness(int brightness)
  {
    this.brightness = Math.min(this.maxBrightness, Math.max(this.minBrightness, brightness));
  }

  @Override
  public int getBrightness()
  {
    return this.brightness;
  }

  @Override
  public void decreaseBrightness(int step)
  {
    this.brightness = Math.max(this.minBrightness, this.brightness - step);
  }

  @Override
  public void increaseBrightness(int step)
  {
    this.brightness = Math.min(this.maxBrightness, this.brightness + step);
  }


  @Override
  public IDeviceDriver getDriver()
  {
    return this.driver;
  }
}
