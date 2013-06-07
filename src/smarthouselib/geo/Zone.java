package smarthouselib.geo;

/**
 * @author cameri
 * @since 6/7/13
 */
public class Zone
{

  ZoneType zoneType = ZoneType.Unknown;
  String name;
  int floor;

  public int getFloor()
  {
    return this.floor;
  }

  public void setFloor(int newFloor)
  {
    this.floor = newFloor;
  }

  public void setName(String newName)
  {
    this.name = newName;
  }

  public String getName()
  {
    return this.name;
  }

  public void setZoneType(ZoneType newZoneType)
  {
    this.zoneType = newZoneType;
  }

  public ZoneType getZoneType()
  {
    return this.zoneType;
  }
}
