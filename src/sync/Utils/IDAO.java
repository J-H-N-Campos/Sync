package sync.Utils;

import java.util.ArrayList;
import java.util.List;

public interface IDAO<T> 
{
    public void create( T entity ) throws DataBaseException,DuplicateKeyException;
    public void edit( T entity ) throws DataBaseException;
    public void delete( T entity ) throws DataBaseException;
    public T read( int id ) throws DataBaseException;
    public List<T> read( String query ) throws DataBaseException;
    public List<T> readAll() throws DataBaseException;
}
