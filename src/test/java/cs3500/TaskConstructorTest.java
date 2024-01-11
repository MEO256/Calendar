package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.TaskConstructor;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * represents test for taskConstructor
 */
public class TaskConstructorTest {

  /**
   * Initalizes tests
   */
  @BeforeEach
  public void setup() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    TaskConstructor task2 = new TaskConstructor("Clean house",
        DaysOfWeek.TUESDAY, false, Path.of("src/main/resources/Week.bujo"));
  }

  @Test
  public void testGetDays() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    TaskConstructor task2 = new TaskConstructor("Clean house",
        DaysOfWeek.TUESDAY, false, Path.of("src/main/resources/Week.bujo"));
    assertEquals(DaysOfWeek.MONDAY, task1.getDays());
    assertEquals(DaysOfWeek.TUESDAY, task2.getDays());
  }

  @Test
  public void testGetName() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    TaskConstructor task2 = new TaskConstructor("Clean house",
        DaysOfWeek.TUESDAY, false, Path.of("src/main/resources/Week.bujo"));
    assertEquals("Movie", task1.getName());
    assertEquals("Clean house", task2.getName());
  }

  @Test
  public void testGetPathToSend() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    TaskConstructor task2 = new TaskConstructor("Clean house",
        DaysOfWeek.TUESDAY, false, Path.of("src/main/resources/Week.bujo"));
    assertEquals(Path.of("src/main/resources/Week.bujo"), task1.getPathToSend());
    assertEquals(Path.of("src/main/resources/Week.bujo"), task2.getPathToSend());
  }

  @Test
  public void testGetCompleted() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    TaskConstructor task2 = new TaskConstructor("Clean house",
        DaysOfWeek.TUESDAY, false, Path.of("src/main/resources/Week.bujo"));
    assertTrue(task1.getCompleted());
    assertFalse(task2.getCompleted());
  }

  @Test
  public void testToString() {
    TaskConstructor task1 = new TaskConstructor("Movie",
        DaysOfWeek.MONDAY, true, Path.of("src/main/resources/Week.bujo"));
    assertEquals("name: " + "Movie" + ";\n" + "complete:"
        + true, task1.toString());
  }
}
