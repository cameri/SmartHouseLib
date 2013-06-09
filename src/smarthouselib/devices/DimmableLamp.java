package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.devices.drivers.IDimmableDriver;

/**
 * @author cameri
 * @since 6/5/13
 */
public class DimmableLamp extends Lamp implements IDevice, IDimmable
{

  int brightness;
  int minBrightness;
  int maxBrightness;

  public DimmableLamp()
  {
    this.brightness = 0;
    this.getBrightness(); // attempt to get brightness
    this.minBrightness = 0;
    this.maxBrightness = 255;
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
    IDeviceDriver _driver = this.getDriver();
    if (_driver instanceof IDimmableDriver)
    {
      this.brightness = Math.min(this.maxBrightness, Math.max(this.minBrightness, brightness));
      ((IDimmableDriver) _driver).setBrightness(this.brightness);
    }
  }

  @Override
  public int getBrightness()
  {
    // figure out if the driver supports this...
    try
    {
      IDeviceDriver _driver = this.getDriver();
      if (_driver instanceof IDimmableDriver)
      {
        this.brightness = ((IDimmableDriver) _driver).getBrightness();
      }
    } catch (UnsupportedOperationException ex)
    {
      // left empty on purpse
    }
    return this.brightness;
  }

  @Override
  public void decreaseBrightness(int step)
  {
    this.setBrightness(Math.max(this.minBrightness, this.getBrightness() - step));
  }

  @Override
  public void increaseBrightness(int step)
  {
    this.setBrightness(Math.min(this.maxBrightness, this.getBrightness() + step));
  }

  @Override
  public String toString()
  {
    return String.format("DimmableLamp (%s)", this.getId());
  }
}
