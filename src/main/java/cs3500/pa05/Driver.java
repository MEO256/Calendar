package cs3500.pa05;


import cs3500.pa05.model.FileInterpreter;
import cs3500.pa05.view.PutJournal;
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents a simple interactive application with a GUI.
 */
public class Driver extends Application {
  /**
   * Starts the GUI for a simple interactive application.
   *
   * @param stage the JavaFX stage to add elements to
   */


  FileInterpreter file = new FileInterpreter();

  @Override
  public void start(Stage stage) {
    // instantiate a simple welcome GUI view
    try {

      stage.setTitle("Journal");
      PutJournal journal = new PutJournal(new File("src/main/resources/Week.bujo"));
      journal.setJournal(stage);

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Runs a GUI application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {

    launch();
  }


}