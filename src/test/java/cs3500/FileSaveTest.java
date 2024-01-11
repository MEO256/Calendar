package cs3500;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.TaskJson;
import cs3500.pa05.model.DaysOfWeek;
import cs3500.pa05.model.FileSave;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents test for FileSave
 */
public class FileSaveTest {

  /**
   * Initializes tests
   */
  @BeforeEach
  public void setup() {
    FileSave fileSave = new FileSave();
  }

  @Test
  public void testSaveFile() {
    FileSave fileSave = new FileSave();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    File file = new File("src/main/resources/Week.bujo");
    EventJson eventJson = new EventJson("Movie", DaysOfWeek.MONDAY, "4:00pm", 2, path);

    fileSave.saveFile(eventJson);

    assertTrue(file.exists());
  }

  @Test
  public void testSaveFileTasks() {
    FileSave fileSave = new FileSave();
    Path path = Path.of("src/test/resources/Week1backup.bujo");
    File file = new File("src/main/resources/Week.bujo");
    TaskJson taskJson = new TaskJson("Drive", DaysOfWeek.MONDAY, false, path);

    fileSave.saveFileTasks(taskJson);

    assertTrue(file.exists());
  }


}
