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
/**
 * Created by Сергей on 12.04.2019.
 */
    public class MainWindow
    {
        public void display(Stage primaryStage)
        {
            try {
                primaryStage.setResizable(false);
                BorderPane root = new BorderPane();
                Scene scene = new Scene(root, 600, 240);
                GridPane gridpane = new GridPane();
                gridpane.setPadding(new Insets(10));
                gridpane.setHgap(12);
                gridpane.setVgap(8);



                root.setCenter(gridpane);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }

