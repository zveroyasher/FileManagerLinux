package sample;
/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static sample.ListFiles.removeStaticPath;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="fileMenu1"
    private MenuButton fileMenu1; // Value injected by FXMLLoader

    @FXML // fx:id="aboutMenu1"
    private MenuButton aboutMenu1; // Value injected by FXMLLoader

    @FXML // fx:id="viewMenu1"
    private MenuButton viewMenu1; // Value injected by FXMLLoader

    @FXML // fx:id="fileMenu2"
    private MenuButton fileMenu2; // Value injected by FXMLLoader

    @FXML // fx:id="viewMenu2"
    private MenuButton viewMenu2; // Value injected by FXMLLoader

    @FXML // fx:id="aboutMenu2"
    private MenuButton aboutMenu2; // Value injected by FXMLLoader

    @FXML // fx:id="listView1"
    private ListView<String> listView1; // Value injected by FXMLLoader

    @FXML // fx:id="listView2"
    private ListView<String> listView2; // Value injected by FXMLLoader
    private ListFiles ListFiles;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        ListFiles newListFile = new ListFiles(); //list files and folders
        List ListfileString = newListFile.getLst();
        ObservableList<String> listPanelOne = FXCollections.observableArrayList(ListfileString);

        listView1.setItems(listPanelOne);   //list files and folders on left panel

        addListView();                      //list files and folders on right panel


        listView2.setOnMouseClicked(new EventHandler<MouseEvent>() { //event for mouse click
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){
                    try {
                        addListView2();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ///Press enter right panel////////////////////////////////////
            listView2.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent ke)
                {
                    if (ke.getCode().equals(KeyCode.ENTER))
                    {
                        System.out.println("ENTER PRESS");
                        try {
                            addListView2();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
            public void addListView(){
                ListFiles newListFile = new ListFiles();
                String newListFile3 = newListFile.getRootLst();
                String[] subStr = newListFile3.split("/");
                System.out.println("Substr 0 := "+subStr[0]+"END");
                for (int x=1; x<= (subStr.length-1) ; x++) {
                    String trimItem = subStr[x].replaceAll(",","");
                    String trimItem2 = trimItem.replaceAll("]","");
                    listView2.getItems().add(trimItem2);
                }
            }

            public void addListView2() throws IOException {
                String selectedItem = listView2.getSelectionModel().getSelectedItem();
                int index = listView2.getSelectionModel().getSelectedIndex();
                System.out.println("index: " + index+ " item: " + selectedItem );
                if(index == 0){
                   removeStaticPath();
                   selectedItem = "";
                    //selectedItem = selectedItem.replace("/","");
                }

                //////////////////code for update listviwer ///////////////////////////
                System.out.println("StaticPath"+ selectedItem);

                listView2.getItems().clear();
                ListFiles newListFile = new ListFiles();

                ArrayList<String> newListFile3 = null;
                try {
                    newListFile3 = newListFile.getRootLstADD(selectedItem);
                } catch (Exception e) {
                    e.printStackTrace();
                }

    for (int x=0; x<= (newListFile3.size()-1) ; x++) {
        if(x==0){ listView2.getItems().add("...up");

        continue;
        }
        String trimItem = newListFile3.get(x).replaceAll(",","");
        String trimItem2 = trimItem.replaceAll("]","");
        listView2.getItems().add(trimItem2);
        }
    }
}
