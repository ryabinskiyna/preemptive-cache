package ru.itpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {

    @Test
    void get() {
        LruCache<Object, Object> test = new LruCache<>(1);
        {
            assertNull(test.get(1));
        }
        {
            test.put(1, "one");
            assertEquals("one", test.get(1));
        }

    }

    @Test
    void put() {
        LruCache<Object, Object> test = new LruCache<>(1);
        {
            assertFalse(test.put(1, "one"));
        }
        {
            test.put(1, "one");
            assertTrue(test.put(1, "one"));
        }
        {
            test.put(2, "two");
            assertEquals("two", test.get(2));
        }
    }
}