/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouse.drivers;

/**
 *
 * @author Ricardo A Cabral
 */
public class ArturoLampDriver implements IToggleableDriver {
    
  @Override
  public void turnOn() {
    System.out.println("Arturo turns on lamp.");
  }

  @Override
  public void turnOff() {
    System.out.println("Arturo turns off lamp.");
  }
}
