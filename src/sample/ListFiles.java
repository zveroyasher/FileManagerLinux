package sample;

import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiles{
    public static String stringPathFile;
    private List lst;
    private List lst2;
    private String newPath;
    public static String staticPath;
    public static ArrayList<String> arrPathOld= new ArrayList<String>();
    //public File stringPathFile;

    public static int y =1;

    public  ListFiles(){
        String path = new File(".").getPath(); //create path
        File dir = new File(path); //path to dir
        File[] arrFiles = dir.listFiles();//array files & folders
        List lst =  Arrays.asList(arrFiles);
        this.lst = lst;
        //System.out.println("String getList "+lst);
    }

    public List getLst(){
        return lst;
    }

    public String getRootLst(){
        addoldPath("/");

        //arrPathOld.add("/");
    String pathRoot = "/";
    File dir = new File(pathRoot); //path to dir
    File[] arrFiles = dir.listFiles();
    List lstRoot = Arrays.asList(arrFiles);
    String strstr = lstRoot.toString();
   // System.out.println(lstRoot.get(1));
        arrPathOld.add(pathRoot);
    return strstr;
    }


    public ArrayList<String> getRootLstADD(String newPath) throws Exception {
        String pathRoot = getStaticPath();
        //String pathString = newPath;
        //newPath=getStaticPath() + newPath;
        if (newPath != null)
        newPath= newPath.replaceAll(" ", "");
        pathRoot +=newPath;
        System.out.println("pathRoot + newPath = " + pathRoot );
        File dir = new File(pathRoot + "/"); //path to dir
        ArrayList pathArray = null;
        if (!dir.isDirectory()) {
            //COde for file
//                FXMLLoader loader =new FXMLLoader();
//                loader.setLocation(getClass().getResource("/sample/TextReader.fxml"));
//                try {
//                    loader.load();
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//                Parent root = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));
//                stage.showAndWait();
            ////////////////

          stringPathFile = dir.toString();

          //  Thread threds = new Thread(new MyThread(),"MyThread");
            TextReader textReader = new TextReader();
            Stage stage = new Stage();

            textReader.start(stage);
           //.start();
            pathRoot = getStaticPath();
            File dir2 = new File(pathRoot + "/"); //path to dir

           // System.out.println("its a dir: = " + dir);
            File[] arrFiles = dir2.listFiles();
            pathArray = new ArrayList<String>();
            pathArray.add(newPath);
            for (int i = 0; i < arrFiles.length; i++) {

                pathArray.add(arrFiles[i].getName());

            }
            System.out.println("pat" + pathArray);

        } else {
            System.out.println("its a dir: = " + dir);
            if(newPath !=""){ addoldPath(newPath+"/");}
            File[] arrFiles = dir.listFiles();
            pathArray = new ArrayList<String>();
            pathArray.add(newPath);
            for (int i = 0; i < arrFiles.length; i++) {

                pathArray.add(arrFiles[i].getName());

            }
            System.out.println("pat" + pathArray);

        }
        return pathArray;
    }
    public static void addoldPath(String inPath){
       // inPath = inPath.replace("/", "");
        System.out.println("addOldPath or inPath " + inPath);
        arrPathOld.add(inPath);
        y+=1;
       // staticPath = inPath ;

    }

    public static String getStaticPath(){
        staticPath ="";
        int staticCount;
        //if(null != staticCount) {}
            for (int x=1 ; x<= arrPathOld.size() -1; x++ ) {
                System.out.println("arryPaz elementIndex"+x+ "="+ "elementString= "+ arrPathOld.get(x));
                staticPath += arrPathOld.get(x);
                y-=1;
                //staticPath.replaceAll("/", "");

            }

        return staticPath;
    }
    public static  void removeStaticPath(){
           int lastElement =arrPathOld.size()-1;
           System.out.println("LAST ELEMENT REMOVE "+ lastElement );
           arrPathOld.remove(lastElement);
    }
}
