package sample.Process;

import java.util.*;

/**
 * Created by JKKim on 2016. 6. 12..
 */
public class PrivateCacheManager {

    private static PrivateCacheManager instance;
    private static Object monitor = new Object();
    private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<>());

    private PrivateCacheManager() {
    }

    public void put(String cacheKey, Object value) {
        cache.put(cacheKey, value);
    }

    public Object get(String cacheKey) {
        return cache.get(cacheKey);
    }

    public void clear(String cacheKey) {
        cache.put(cacheKey, null);
    }

    public void clear() {
        cache.clear();
    }

    public static PrivateCacheManager getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new PrivateCacheManager();
                }
            }
        }
        return instance;
    }
}
