/**
 * Created by Сергей on 12.04.2019.
 */
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;



public class MainThread extends Application {


    public void start(Stage primaryStage)
    {
        System.out.println("Main thread started...");
        Matrix matrix = new Matrix();
        MainWindow window = new MainWindow();
        window.display(primaryStage, matrix);
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}