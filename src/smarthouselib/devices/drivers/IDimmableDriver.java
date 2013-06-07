package smarthouselib.devices.drivers;

/**
 * @author cameri
 * @since 6/6/13
 */
public interface IDimmableDriver
{

  void setBrightness(int brightness) throws UnsupportedOperationException;

  int getBrightness() throws UnsupportedOperationException;

  void decreaseBrightness(int amount) throws UnsupportedOperationException;

  void increaseBrightness(int amount) throws UnsupportedOperationException;
}
