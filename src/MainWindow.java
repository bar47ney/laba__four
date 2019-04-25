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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * Created by Сергей on 12.04.2019.
 */


class MyThread implements Callable<Integer> {

    private int aa;
    private int bb;
    private int cc;
    private int dd;
    private String name_thread;

    private int determinant;

    public Integer call()
    {
        System.out.printf("%s started... \n", name_thread);
        Determinant determinant = new Determinant();
        determinant.setArray(aa,bb,cc,dd);
        this.determinant = determinant.calculate();


        System.out.printf("%s finished... \n", name_thread);
        return this.determinant;
    }

    MyThread(String name, int a, int b, int c, int d)
    {
        name_thread = name;
        aa = a;
        bb = b;
        cc = c;
        dd = d;
    }
}



public class MainWindow
{
    public void display(Stage primaryStage, Matrix matrix)
    {
        try {

            primaryStage.setResizable(false);
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 600, 240);
            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(10));
            gridpane.setHgap(12);
            gridpane.setVgap(8);

            TextField oneOne = new TextField();
            gridpane.add(oneOne, 0, 0);

            TextField oneTwo = new TextField();
            gridpane.add(oneTwo, 1, 0);

            TextField oneThree = new TextField();
            gridpane.add(oneThree, 2, 0);

            TextField twoOne = new TextField();
            gridpane.add(twoOne, 0, 1);

            TextField twoTwo = new TextField();
            gridpane.add(twoTwo, 1, 1);

            TextField twoThree = new TextField();
            gridpane.add(twoThree, 2, 1);

            TextField threeOne = new TextField();
            gridpane.add(threeOne, 0, 2);

            TextField threeTwo = new TextField();
            gridpane.add(threeTwo, 1, 2);

            TextField threeThree = new TextField();
            gridpane.add(threeThree, 2, 2);

            Button go = new Button("Go");
            go.setPrefSize(190,100);
            gridpane.add(go, 1, 3);

            go.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    int i = 0;
                    matrix.array[0][0] = Integer.parseInt(oneOne.getText());
                    matrix.array[0][1] = Integer.parseInt(oneTwo.getText());
                    matrix.array[0][2] = Integer.parseInt(oneThree.getText());
                    matrix.array[1][0] = Integer.parseInt(twoOne.getText());
                    matrix.array[1][1] = Integer.parseInt(twoTwo.getText());
                    matrix.array[1][2] = Integer.parseInt(twoThree.getText());
                    matrix.array[2][0] = Integer.parseInt(threeOne.getText());
                    matrix.array[2][1] = Integer.parseInt(threeTwo.getText());
                    matrix.array[2][2] = Integer.parseInt(threeThree.getText());

                    while (i <3)
                    {

                        if(i == 0)
                        {

                            MyThread myThread = new MyThread("MyThread_1",matrix.array[1][1],matrix.array[1][2],matrix.array[2][1],matrix.array[2][2]);
                            try
                            {
                                Future<Integer> future = Executors.newCachedThreadPool().submit(myThread);
                                matrix.determinant_one = future.get();
                            }
                            catch(InterruptedException | ExecutionException e){

                                e.printStackTrace();
                            }

                        }
                        if(i == 1)
                        {
                            MyThread myThread = new MyThread("MyThread_2",matrix.array[1][0],matrix.array[1][2],matrix.array[2][0],matrix.array[2][2]);
                            try
                            {
                                Future<Integer> future = Executors.newCachedThreadPool().submit(myThread);
                                matrix.determinant_two = future.get();
                            }
                            catch(InterruptedException | ExecutionException e)
                            {

                                e.printStackTrace();
                            }
                        }
                        if(i == 2)
                        {
                            MyThread myThread = new MyThread("MyThread_3",matrix.array[1][0],matrix.array[1][1],matrix.array[2][0],matrix.array[2][1]);
                            try
                            {
                                Future<Integer> future = Executors.newCachedThreadPool().submit(myThread);
                                matrix.determinant_three = future.get();
                            }
                            catch(InterruptedException | ExecutionException e)
                            {

                                e.printStackTrace();
                            }
                        }
                        i++;

                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText(Integer.toString(matrix.calculate()));
                    alert.showAndWait();
                    primaryStage.close();
                    System.out.println("Main thread finished...");
                }
            });

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

