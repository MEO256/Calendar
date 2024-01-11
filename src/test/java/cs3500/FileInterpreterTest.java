package cs3500;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.DayJson;
import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.SetupJson;
import cs3500.pa05.model.TaskJson;
import cs3500.pa05.model.WeekJson;
import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.EventConstructor;
import cs3500.pa05.model.FileInterpreter;
import cs3500.pa05.model.TaskConstructor;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents test for file interpretor
 */
public class FileInterpreterTest {

  /**
   * Initalizes test
   */
  @BeforeEach
  public void setup() {
    FileInterpreter fileInterpreter = new FileInterpreter();
  }


  @Test
  public void testOpenFileInterpretor() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    fileInterpreter.openFileInterpreter(Path.of("src/test/resources/Week1backup.bujo"));

    assertEquals(
        "{\"max-events\":3,\"max-tasks\":3,\"week\":"
            + "{\"week-view\":[{\"day\":\"SUNDAY\",\"events\":[{\"name\":\"Movies\","
            + "\"days\":\"SUNDAY\",\"start-time\":\"4:00pm\",\"duration\":2,"
            + "\"path-to-send\":\"file:///C:/Personal/College/"
            + "Summer%201%202023/Object%20Oreinted%20Design/"
            + "CS%203500%20Projects/pa05-fandorins/src/main/resources/Week.bujo\"}],"
            + "\"tasks\":[{\"name\":\"Drive\",\"days\":\"SUNDAY\","
            + "\"complete\":false,\"path-to-send\":\""
            + "file:///C:/Personal/College/"
            + "Summer%201%202023/Object%20Oreinted%20Design/"
            + "CS%203500%20Projects/pa05-fandorins/src/main/resources/Week.bujo\"}]}]}}",
        fileInterpreter.getContent().toString());

    FileInterpreter fileInterpreter2 = new FileInterpreter();

    assertThrows(RuntimeException.class, () ->
        fileInterpreter2.openFileInterpreter(Path.of("src/resources/Week1backup.bujo")));
  }


  @Test
  public void testMakeTaskList() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    TaskConstructor task = new TaskConstructor("Drive", DaysOfWeek.MONDAY, false, path);
    List<TaskConstructor> lt = new ArrayList<>(Arrays.asList(task));
    assertEquals(lt.toString(), fileInterpreter.makeTaskList().toString());
  }

  @Test
  public void testMakeEventList() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    EventConstructor eventConstructor =
        new EventConstructor("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventConstructor> le = new ArrayList<>(Arrays.asList(eventConstructor));
    assertEquals(le.toString(), fileInterpreter.makeEventList().toString());
  }

  @Test
  public void testTasksCompleted() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    TaskConstructor task = new TaskConstructor("Drive", DaysOfWeek.MONDAY, false, path);
    List<TaskConstructor> lt = new ArrayList<>(Arrays.asList(task));
    List<TaskConstructor> lt2 = fileInterpreter.makeTaskList();
    assertEquals(0.0, fileInterpreter.tasksCompleted());
  }

  @Test
  public void testGetJson() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);

    assertEquals(bujoJson, fileInterpreter.getJson());

  }

  @Test
  public void testGetContent() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    fileInterpreter.openFileInterpreter(Path.of("src/test/resources/Week1backup.bujo"));

    assertEquals(
        "{\"max-events\":3,\"max-tasks\":3,\"week\":{\"week-view\":"
            + "[{\"day\":\"SUNDAY\",\"events\":[{\"name\":\"Movies\","
            + "\"days\":\"SUNDAY\",\"start-time\":\"4:00pm\",\"duration\":2,"
            + "\"path-to-send\":\"file:///C:/Personal/College/"
            + "Summer%201%202023/Object%20Oreinted%20Design/"
            + "CS%203500%20Projects/pa05-fandorins/src/main/resources/Week.bujo\"}],"
            + "\"tasks\":[{\"name\":\"Drive\",\"days\":\"SUNDAY\",\""
            + "complete\":false,\"path-to-send\":\""
            + "file:///C:/Personal/College/"
            + "Summer%201%202023/Object%20Oreinted%20Design/"
            + "CS%203500%20Projects/pa05-fandorins/src/main/resources/Week.bujo\"}]}]}}",
        fileInterpreter.getContent().toString());
  }

  @Test
  public void testGetTotalTasks() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    TaskConstructor task = new TaskConstructor("Drive", DaysOfWeek.MONDAY, false, path);
    List<TaskConstructor> lt = new ArrayList<>(Arrays.asList(task));
    List<TaskConstructor> lt2 = fileInterpreter.makeTaskList();

    assertEquals(lt2, fileInterpreter.getTotalTasks());

  }

  @Test
  public void testGetTotalEvents() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    EventConstructor eventConstructor =
        new EventConstructor("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventConstructor> le = new ArrayList<>(Arrays.asList(eventConstructor));
    List<EventConstructor> le2 = fileInterpreter.makeEventList();

    assertEquals(le2, fileInterpreter.getTotalEvents());

  }


  @Test
  public void testGetPercentTaskCompleted() {
    FileInterpreter fileInterpreter = new FileInterpreter();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "1", 2, path);
    List<EventJson> leJson = new ArrayList<>(Arrays.asList(eventJson));
    List<TaskJson> ltJson = new ArrayList<>(Arrays.asList(taskJson));
    DayJson dayJson = new DayJson(DaysOfWeek.MONDAY, leJson, ltJson);
    List<DayJson> ldjson = new ArrayList<>(Arrays.asList(dayJson));
    WeekJson weekJson = new WeekJson(ldjson);
    SetupJson bujoJson = new SetupJson(1, 1, weekJson);
    fileInterpreter.setJson(bujoJson);
    TaskConstructor task = new TaskConstructor("Drive", DaysOfWeek.MONDAY, false, path);
    List<TaskConstructor> lt = new ArrayList<>(Arrays.asList(task));
    List<TaskConstructor> lt2 = fileInterpreter.makeTaskList();
    double tasksCompleted = fileInterpreter.tasksCompleted();
    assertEquals(0.0, fileInterpreter.getPercentTaskCompleted());
  }


}
