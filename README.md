# LruCache

A tiny memory cache implementation which uses a LRU policy.

> This implementation gives priority to simplicity of API.

### Cache

[`LruCache`](https://github.com/ryabinskiyna/preemptive-cache/blob/master/src/main/java/ru/itpark/LruCache.java) is a class.

It provides two methods as bellow.

- `V get(K key)` - Gets an value for the specified key.
- `V put(K key, V value)` - Puts an value in the cache for the specified key.

#### LruCache

[`LruCache`](https://github.com/ryabinskiyna/preemptive-cache/blob/master/src/main/java/ru/itpark/LruCache.java)'s API is definitely simple.

```java
LruCache<K, V> cache = new LruCache<K, V>(capacity);
cache.put(k, v);
```

#### Note

- The code is written according to the mozilla.org Java Coding style: https://firefox-source-docs.mozilla.org/tools/lint/coding-style/coding_style_java.html
- The code is covered by JUnit tests.
- The code is covered by BenchMark stress tests.

## Support

Java 1.8 or greater.
