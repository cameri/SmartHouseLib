package smarthouse.devices;

import smarthouse.DeviceCapabilities;
import smarthouse.DeviceState;
import smarthouse.IDevice;
import smarthouse.IDimmable;
import smarthouse.drivers.IToggleableDriver;

/**
 * @author cameri
 * @since 6/5/13
 */
public class DimmableLamp implements IDevice, IDimmable {
  String ID;
  DeviceState currentState = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[] { DeviceCapabilities.Dimmable };
  IToggleableDriver driver;
  int brightness = 0;
  int minBrightness = 0;
  int maxBrightness = 1023;

  @Override
  public void setID(String ID) {
    this.ID = ID;
  }

  @Override
  public String getID() {
    return this.ID;
  }

  @Override
  public void setCurrentState(DeviceState newState) {
    this.currentState = newState;
  }

  @Override
  public DeviceState getCurrentState() {
    return this.currentState;
  }

  @Override
  public DeviceCapabilities[] getCapabilities()
  {
    return this.capabilities;
  }

  @Override
  public void setMinimumBrightness(int minBrightness) {
    this.minBrightness = minBrightness;
  }

  @Override
  public int getMinimumBrightness() {
    return this.minBrightness;
  }

  @Override
  public void setMaximumBrightness(int maxBrightness) {
    this.maxBrightness = maxBrightness;
  }

  @Override
  public int getMaximumBrightness() {
    return this.maxBrightness;
  }

  @Override
  public void setBrightness(int brightness) {
    this.brightness = Math.min(this.maxBrightness ,Math.max(this.minBrightness, brightness));
  }

  @Override
  public int getBrightness() {
    return this.brightness;
  }

  @Override
  public void decreaseBrightness(int step) {
    this.brightness = Math.max(this.minBrightness, this.brightness - step);
  }

  @Override
  public void increaseBrightness(int step) {
    this.brightness = Math.min(this.maxBrightness, this.brightness + step);
  }

  @Override
  public void setDriver(IToggleableDriver newDriver) {
    this.driver = newDriver;
  }

  @Override
  public IToggleableDriver getDriver() {
    return this.driver;
  }
}
