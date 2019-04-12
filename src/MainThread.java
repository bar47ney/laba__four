/**
 * Created by Сергей on 12.04.2019.
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

public class MainThread extends Application
{
        public void start(String[] args)
        {

            int[][] matrixA;
            matrixA = new int[2][3];

            matrixA[0][0] = 1;
            matrixA[0][1] = -2;
            matrixA[0][2] = 3;
            matrixA[1][0] = 4;
            matrixA[1][1] = 1;
            matrixA[1][2] = 7;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrixA[i][j] + "\t");
                }
                System.out.println();
            }
        }

    public static void main(String[] args)
    {
        launch(args);
    }

}

public class Main extends Application
{
    public void start(Stage primaryStage)
    {
        ArrayList<Student> sl = new ArrayList<Student>();
        ArrayList<Worker> wl = new ArrayList<Worker>();
        Student student = new Student();
        Worker worker = new Worker();
        MainWindow window = new MainWindow();
        window.display(primaryStage, student, worker, sl, wl);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
