package moblima.dao;
import java.util.*;

public interface Dao<T> {
    
	Optional<T> get(long id);
	
    List<T> getAll();
    
    void add(T t);
    
    void delete(T t);
}


