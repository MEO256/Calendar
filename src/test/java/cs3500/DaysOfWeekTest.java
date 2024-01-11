package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.DaysOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents test for Day of Week enum
 */
public class DaysOfWeekTest {

  /**
   * Initializes tests
   */
  @BeforeEach
  public void setup() {
    DaysOfWeek monday = DaysOfWeek.MONDAY;
    DaysOfWeek tuesday = DaysOfWeek.TUESDAY;
    DaysOfWeek wednesday = DaysOfWeek.WEDNESDAY;
    DaysOfWeek thursday = DaysOfWeek.THURSDAY;
    DaysOfWeek friday = DaysOfWeek.FRIDAY;
    DaysOfWeek saturday = DaysOfWeek.SATURDAY;
    DaysOfWeek sunday = DaysOfWeek.SUNDAY;
  }


  @Test
  public void testDaysOfWeek() {
    final DaysOfWeek monday = DaysOfWeek.MONDAY;
    final DaysOfWeek tuesday = DaysOfWeek.TUESDAY;
    final DaysOfWeek wednesday = DaysOfWeek.WEDNESDAY;
    final DaysOfWeek thursday = DaysOfWeek.THURSDAY;
    final DaysOfWeek friday = DaysOfWeek.FRIDAY;
    final DaysOfWeek saturday = DaysOfWeek.SATURDAY;
    final DaysOfWeek sunday = DaysOfWeek.SUNDAY;
    assertEquals(monday, DaysOfWeek.valueOf("MONDAY"));
    assertEquals(tuesday, DaysOfWeek.valueOf("TUESDAY"));
    assertEquals(wednesday, DaysOfWeek.valueOf("WEDNESDAY"));
    assertEquals(thursday, DaysOfWeek.valueOf("THURSDAY"));
    assertEquals(friday, DaysOfWeek.valueOf("FRIDAY"));
    assertEquals(saturday, DaysOfWeek.valueOf("SATURDAY"));
    assertEquals(sunday, DaysOfWeek.valueOf("SUNDAY"));
  }
}
