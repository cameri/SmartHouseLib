package smarthouselib.controllers.drivers;

import java.io.IOException;

/**
 * @author cameri
 * @since 6/6/13
 */
public interface IControllerDriver
{

  void initialize();

  void connect() throws IOException;
}
