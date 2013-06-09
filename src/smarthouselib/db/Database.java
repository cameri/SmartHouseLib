package smarthouselib.db;

import org.mariadb.jdbc.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cameri
 * @since 6/12/13
 */
public class Database
{
  private static Database instance;
  private MySQLConnection connection;
  private String databaseName;
  private String username;
  private String password;
  private String hostname;
  private int port;

  protected Database()
  {

  }

  public static Database getInstance()
  {
    if (instance == null)
      instance = new Database();
    return instance;
  }

  public void setDatabaseName(String databaseName)
  {
    this.databaseName = databaseName;
  }

  public String getDatabaseName()
  {
    return this.databaseName;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public void setHostname(String hostname)
  {
    this.hostname = hostname;
  }

  public String getHostname()
  {
    return this.hostname;
  }

  public void setPort(int port)
  {
    this.port = port;
  }

  public int getPort()
  {
    return this.port;
  }

  private String getConnectionString()
  {
    return String.format("jdbc:mysql://%s:%d/%s", this.hostname, this.port, this.databaseName);
  }

  public Connection getConnection()
  {
    if (this.connection == null)
    {
      try
      {
        this.connection = (MySQLConnection) DriverManager.getConnection(this.getConnectionString(), this.username, this.password);
      } catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    return this.connection;
  }

  @Override
  public String toString()
  {
    return String.format("Database{hostname='%s', port=%d, databaseName='%s'}", hostname, port, databaseName);
  }
}
