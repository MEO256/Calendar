package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.EventConstructor;
import cs3500.pa05.model.TaskConstructor;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for eventConstructor
 */
public class EventConstructorTest {

  /**
   * Initalizes tests
   */
  @BeforeEach
  public void setup() {
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    EventConstructor
        eventConstructor = new EventConstructor("Movie", DaysOfWeek.MONDAY, "1", 2, path);
  }

  @Test
  public void testToString() {
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    EventConstructor
        eventConstructor = new EventConstructor("Movie", DaysOfWeek.MONDAY, "1", 2, path);

    assertEquals("name: " + "Movie" + ";\n" + "startTime:"
        + "1", eventConstructor.toString());
  }
}
