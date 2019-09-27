package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextReaderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox VBoxReader;

    @FXML
    private MenuBar MenuBarReader;

    @FXML
    private TextArea TextAreaReader;


    @FXML
    void initialize() {
        assert VBoxReader != null : "fx:id=\"VBoxReader\" was not injected: check your FXML file 'sample.fxml'.";
        assert MenuBarReader != null : "fx:id=\"MenuBarReader\" was not injected: check your FXML file 'sample.fxml'.";
        assert TextAreaReader != null : "fx:id=\"TextAreaReader\" was not injected: check your FXML file 'sample.fxml'.";
       // ListFiles.stringPathFile;
        TextAreaReader.setText(ListFiles.stringPathFile);

    }
}