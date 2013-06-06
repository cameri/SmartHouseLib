package smarthouselib.devices.drivers;

/**
 * @author cameri
 * @since 6/6/13
 */
public interface IDimmableDriver
{

  void setBrightness(int brightness);

  void decreaseBrightness(int amount);

  void increaseBrightness(int amount);
}
