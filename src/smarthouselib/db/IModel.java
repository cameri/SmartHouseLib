package smarthouselib.db;

/**
 * @author cameri
 * @since 6/12/13
 */
public interface IModel
{
  boolean update();

  boolean save();

  boolean isChanged();
}
