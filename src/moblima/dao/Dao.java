package moblima.dao;
import java.util.*;

/**
 * Represents 
 * @author A Penguin
 *
 * @param <T>
 */
public interface Dao<T> {
    
	Optional<T> get(long id);
	
    List<T> getAll();
    
    void add(T t);
    
    void delete(T t);

	
}


