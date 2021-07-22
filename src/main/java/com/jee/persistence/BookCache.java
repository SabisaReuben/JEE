package com.jee.persistence;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.WRITE)
public class BookCache {


   private static final Map<Object, Object> cacheMap = new HashMap<>();

    public void cache(String key,Object value){
        cacheMap.put(key, value);

    }

    public  Object remove(String key){
       if(cacheMap.containsKey(key))
           return cacheMap.remove(key);
        return null;

    }

    @Lock(LockType.READ)
    public Object getBookList(String key) {
        return cacheMap.get(key);
    }

    /**
     * This method schedules a refresh after every 15 minutes
     */
    @Schedule(second = "*/15", minute = "*" ,hour = "*")
    public void refreshCache() {
        //feed the cache with new data
        System.out.println("The schedule is really working");
    }


}
