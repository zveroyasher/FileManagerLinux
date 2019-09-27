package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TextReader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TextReader.fxml"));

        primaryStage.setTitle("File Manager");
        primaryStage.setScene(new Scene(root, 800, 400));


        primaryStage.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
