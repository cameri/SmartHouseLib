package smarthouselib.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cameri
 * @since 6/9/13
 */
public abstract class ControllerModel implements IModel
{
  private int id;
  private String controllerType;
  private String controllerDriver;
  private String name;
  private String configuration;
  private boolean changed = false;
  private static String tableName = "controllers";
  private static String[] sqlQueries = {
    "SELECT `id`, `controller_type`, `controller_driver`, `name`, `configuration` FROM `controllers` WHERE `id` = ?;",
    "INSERT INTO `controllers` (`id`, `controller_type`, `controller_driver`, `name`, `configuration`) VALUES (?, ?, ?, ?);",
    "UPDATE `controllers` SET `controller_type` = ?, `controller_driver` = ?, `name` = ?, `configuration` = ? WHERE `id` = ?;"
  };

  public ControllerModel(int id, String controllerType, String controllerDriver, String name, String configuration)
  {
    this.id = id;
    this.controllerType = controllerType;
    this.controllerDriver = controllerDriver;
    this.name = name;
    this.configuration = configuration;
    setChanged(false);
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    if (this.id == 0 && id > 0)
    {
      this.id = id;
      setChanged(true);
    }
  }

  public String getControllerType()
  {
    return controllerType;
  }

  private void setControllerType(String controllerType)
  {
    if (this.controllerType != controllerType)
    {
      this.controllerType = controllerType;
      setChanged(true);
    }
  }

  public String getControllerDriver()
  {
    return controllerDriver;
  }

  private void setControllerDriver(String controllerDriver)
  {
    if (this.controllerDriver != controllerDriver)
    {
      this.controllerDriver = controllerDriver;
      setChanged(true);
    }
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    if (this.name != name)
    {
      this.name = name;
      setChanged(true);
    }
  }

  @Override
  public boolean load(int Id)
  {
    Connection _conn = Database.getInstance().getConnection();
    PreparedStatement stmt;
    boolean found = false;
    try
    {
      stmt = _conn.prepareStatement(sqlQueries[0]);
      stmt.setInt(1, id);

      ResultSet rs = stmt.executeQuery();

      if (rs.next())
      {
        setId(rs.getInt(1));
        setControllerType(rs.getString(2));
        setControllerDriver(rs.getString(3));
        setName(rs.getString(4));
        setConfiguration(rs.getString(5));
        setChanged(false);
        found = true;
      }
      rs.close();
      stmt.close();

    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }

    return found;
  }

  @Override
  public boolean save()
  {
    if (!this.isChanged())
      return true;

    if (this.getId() == 0)
      return this.insert();
    else
      return this.update();
  }

  private boolean insert()
  {
    try
    {
      Connection _conn = Database.getInstance().getConnection();
      PreparedStatement stmt;

      stmt = _conn.prepareStatement(sqlQueries[1]); // insert
      stmt.setInt(1, 0);
      stmt.setString(2, this.getControllerType());
      stmt.setString(3, this.getControllerDriver());
      stmt.setString(4, this.getName());
      stmt.setString(5, this.getConfiguration());

      int affectedRows = stmt.executeUpdate();

      if (affectedRows == 1)
      {
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next())
        {
          this.setId(rs.getInt(1));
          setChanged(false);
        }
        rs.close();
      }
      stmt.close();
      return !isChanged();
    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    return false;
  }

  private boolean update()
  {
    try
    {
      Connection _conn = Database.getInstance().getConnection();
      PreparedStatement stmt;

      stmt = _conn.prepareStatement(sqlQueries[2]); // update

      stmt.setString(1, this.getControllerType());
      stmt.setString(2, this.getControllerDriver());
      stmt.setString(3, this.getName());
      stmt.setString(4, this.getConfiguration());
      stmt.setInt(5, this.getId());

      int affectedRows = stmt.executeUpdate();

      if (affectedRows == 1)
      {
        setChanged(false);
      }
      stmt.close();
      return !isChanged();
    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    return false;
  }


  public void setChanged(boolean changed)
  {
    this.changed = changed;
  }

  @Override
  public boolean isChanged()
  {
    return this.changed;
  }

  public String getConfiguration()
  {
    return configuration;
  }

  public void setConfiguration(String configuration)
  {
    if (this.configuration != configuration)
    {
      this.configuration = configuration;
      setChanged(true);
    }
  }

  @Override
  public String toString()
  {
    return String.format("ControllerModel{id=%d, controllerType='%s', controllerDriver='%s', name='%s', changed=%s}", id, controllerType, controllerDriver, name, changed);
  }
}
