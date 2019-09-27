package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MyThread implements Runnable {

        @Override
        public void run()
        {
            TextReader textReader = new TextReader();
            Stage stage = new Stage();
        try {
            textReader.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

                }
