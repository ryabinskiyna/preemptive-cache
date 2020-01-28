package ru.itpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LruCacheTest {

    @Test
    void get() {
        LruCache<Object, Object> test = new LruCache<>(1);
        {
            assertNull(test.get(1));
        }
        {
            test.put(1, "Demo");
            assertEquals("Demo", test.get(1));
        }

    }

    @Test
    void put() {
        LruCache<Object, Object> test = new LruCache<>(1);
        {
            assertFalse(test.put(1, "Demo"));
        }
        {
            test.put(1, "Demo");
            assertTrue(test.put(1, "Demo"));
        }
        {
            test.put(2, "Betta");
            assertEquals("Betta", test.get(2));
        }
    }
}