import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  private HashMap<String, Integer> map;

  @BeforeEach
  void setUp() {
    map = new HashMap<>();
  }

  @Test
  void testPutAndGet() {
    map.put("apple", 10);
    map.put("banana", 20);
    map.put("apple", 15); // overwrite existing key

    assertEquals(15, map.get("apple"));
    assertEquals(20, map.get("banana"));
    assertEquals(2, map.size());
  }

  @Test
  void testGetThrowsIfMissingKey() {
    assertThrows(NoSuchElementException.class, () -> map.get("missing"));
  }

  @Test
  void testRemoveEntry() {
    map.put("dog", 1);
    map.put("cat", 2);

    var removed = map.removeEntry("dog");
    assertEquals("dog", removed.getKey());
    assertEquals(1, removed.getVal());
    assertEquals(1, map.size());
    assertThrows(NoSuchElementException.class, () -> map.get("dog"));
  }

  @Test
  void testRemoveEntryThrowsIfKeyMissing() {
    assertThrows(NoSuchElementException.class, () -> map.removeEntry("ghost"));
  }

  @Test
  void testSize() {
    assertEquals(0, map.size());

    map.put("one", 1);
    map.put("two", 2);
    assertEquals(2, map.size());

    map.removeEntry("one");
    assertEquals(1, map.size());
  }
}

