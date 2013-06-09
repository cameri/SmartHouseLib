package smarthouselib.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cameri
 * @since 6/12/13
 */
public class ZoneModel implements IModel
{
  private int id = 0;
  private String name;
  private int floor;

  private boolean changed = false;
  private static String tableName = "zones";
  private static String[] sqlQueries = {
    "SELECT `id`, `name`, `floor` FROM `zones` WHERE `id` = ?;",
    "INSERT INTO `zones` (`id`, `name`, `floor`) VALUES (?, ?, ?);",
    "UPDATE `zones` SET `name`= ?, `floor`=? WHERE `id` = ?"
  };

  protected ZoneModel()
  {
    this.id = 0;
    this.name = "";
    this.floor = 0;
    this.changed = false;
  }

  public ZoneModel(int id, String name, int floor)
  {
    if (id == 0) // new Zone
    {
      setChanged(true);
    } else // existing Zone
    {
      this.setId(id);
    }
    this.setName(name);
    this.setFloor(floor);
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int newId)
  {
    if (this.id == 0 && newId > 0)
    {
      this.id = newId;
      setChanged(true);
    }
  }

  public int getFloor()
  {
    return this.floor;
  }

  public void setFloor(int newFloor)
  {
    if (newFloor != this.floor)
    {
      setChanged(true);
      this.floor = newFloor;
    }
  }

  public void setName(String newName)
  {
    if (newName != null && !newName.isEmpty() && newName != this.name)
    {
      setChanged(true);
      this.name = newName;
    }
  }

  public String getName()
  {
    return this.name;
  }

  private static ZoneModel fetchById(int id)
  {
    Connection _conn = Database.getInstance().getConnection();
    PreparedStatement stmt;
    ZoneModel model = new ZoneModel();
    try
    {
      stmt = _conn.prepareStatement(sqlQueries[0]);
      stmt.setInt(1, id);

      ResultSet rs = stmt.executeQuery();
      boolean found = false;
      if (rs.next())
      {
        model.setId(rs.getInt(1));
        model.setName(rs.getString(2));
        model.setFloor(rs.getInt(3));
        model.setChanged(false);
        found = true;
      }
      rs.close();
      stmt.close();
      if (found)
        return model;

    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean update()
  {
    Connection _conn = Database.getInstance().getConnection();
    PreparedStatement stmt;

    try
    {
      stmt = _conn.prepareStatement(sqlQueries[0]);
      stmt.setInt(1, getId());

      ResultSet rs = stmt.executeQuery();
      boolean found = false;
      if (rs.next())
      {
        setId(rs.getInt(1));
        setName(rs.getString(2));
        setFloor(rs.getInt(3));
        setChanged(false);
        found = true;
      }
      rs.close();
      stmt.close();

      return found;
    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }

    return false;
  }

  @Override
  public boolean save()
  {
    if (!this.isChanged())
      return true;

    Connection _conn = Database.getInstance().getConnection();
    PreparedStatement stmt;
    try
    {
      if (this.getId() == 0)
      {
        stmt = _conn.prepareStatement(sqlQueries[1]); // insert
        stmt.setInt(1, 0);
        stmt.setString(2, this.getName());
        stmt.setInt(3, this.getFloor());

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
      } else
      {
        stmt = _conn.prepareStatement(sqlQueries[2]); // update
        stmt.setString(1, this.getName());
        stmt.setInt(2, this.getFloor());
        stmt.setInt(3, this.getId());

        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 1)
        {
          setChanged(false);
        }
        stmt.close();
        return !isChanged();
      }
    } catch (SQLException ex)
    {
      ex.printStackTrace();
    }

    return false;
  }

  @Override
  public boolean isChanged()
  {
    return changed;
  }

  public void setChanged(boolean changed)
  {
    this.changed = changed;
  }

  @Override
  public String toString()
  {
    return "ZoneModel{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", floor=" + floor +
      ", changed=" + changed +
      '}';
  }
}
