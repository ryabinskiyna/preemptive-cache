package ru.itpark;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An LRU cache, based on LinkedHashMap
 * This cache has a fixed maximum number of elements (<code>mCapacity</code>).
 * If the cache is full and another entry is added, the LRU (least recently used) entry is dropped.
 *
 * @param <K> the type of the cache keys
 * @param <V> the type of the cache values
 * @author Ryabinskiy Nikita
 */

public class LruCache<K, V> {
    private static final boolean sSORT_BY_ACCESS = true;
    private static final float sLOAD_FACTOR = 0.75F;
    private final Map<K, V> mLruCacheMap;
    private final int mCapacity;

    /**
     * Constructor
     * <p>
     * If the cache is to be used by multiple threads, the cache must be wrapped with code to synchronize the methods
     *
     * @param capacity the limit of objects that are kept in the cache
     */

    public LruCache(int capacity) {
        this.mCapacity = capacity;
        this.mLruCacheMap = Collections.synchronizedMap(new LinkedHashMap<K, V>(capacity, sLOAD_FACTOR, sSORT_BY_ACCESS) {
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        });
    }

    /**
     * Returns the object to which this object cache maps the specified key
     *
     * @param key key with which the specified value is to be associated
     * @return the value to which this object cache maps the specified key, or null if the object cache contains no mapping for the key
     */

    public V get(K key) {
        Objects.requireNonNull(key, "key == null");
        synchronized (this) {
            V value = mLruCacheMap.get(key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this object cache. If the object cache previously contained a mapping for this key, the old value is replaced
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */

    public boolean put(K key, V value) {
        boolean exist = false;
        Objects.requireNonNull(key, "key == null");
        Objects.requireNonNull(value, "value == null");
        if (mLruCacheMap.containsKey(key)) {
            exist = true;
            mLruCacheMap.remove(key);
        } else if (mLruCacheMap.size() >= mCapacity) {
            mLruCacheMap.remove(mLruCacheMap.keySet().iterator().next());
        }
        mLruCacheMap.put(key, value);
        return exist;
    }
}
