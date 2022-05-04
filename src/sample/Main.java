package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


// to handle user  implement and add the event handler as method
public class Main extends Application  {
    //Button butt ;
    Stage window ;
    Scene szene1,szene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Responsible Portal");


     /*    butt = new Button("rarted");

        butt.setOnAction(e -> System.out.println("hehe"));
        StackPane layout = new StackPane();
        layout.getChildren().add(butt);
        Scene szene = new Scene(layout , 300,300);
        primaryStage.setScene(szene);
        primaryStage.show();
   */
        window=primaryStage;
        window.setOnCloseRequest(e-> {
            e.consume();
            closeThis();
        });
        //creat connection and fetch students

        List<teachers> lst = new ArrayList<teachers>();
        teachers T1 = new teachers("teacher1","pass1");
        teachers T2 = new teachers("teacher2","pass2");
        teachers T3 = new teachers("teacher3","pass3");
        lst.add(T1);
        lst.add(T2);
        lst.add(T3);
        //for testing integrity only
        for (teachers t :lst)
        {
            System.out.println(t.toString());
        }

        Label lbl1 = new Label("Log in Portal");
        Button butt = new Button("Close");
        butt.setOnAction(e -> {
        boolean result = displayAlert.displayAlert("alert ","do you want to quit ?");
        if (result == true){
           Alert alertYes = new Alert(Alert.AlertType.CONFIRMATION);
           alertYes.setTitle("Quit");
           alertYes.setHeaderText("yes");
           alertYes.setContentText("yes");
           alertYes.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK!!");
                }
                if (rs == ButtonType.CANCEL) {
                    System.out.println("Pressed Cancel!!");
                }
            });
        }
        });

        //horizontal box
        HBox horizont = new HBox(10);
        horizont.getChildren().addAll(lbl1);
        //vertical box
        VBox layout1 = new VBox(15);

        GridPane grid = new GridPane();
        //insets add amount of padding in each corner
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(8);
        grid.setHgap(10);
        Label nameLabel = new Label("name : ");
        TextField nameTXT = new TextField("name...");
        Label passLBL = new Label("password : ");
        TextField passTXT = new TextField();
        passTXT.setPromptText("password");
        Button btnconfirm = new Button("log in");
        GridPane.setConstraints(nameLabel,0,0);
        GridPane.setConstraints(nameTXT,1,0);
        GridPane.setConstraints(passLBL,0,1);
        GridPane.setConstraints(passTXT,1,1);
        GridPane.setConstraints(btnconfirm,2,2);
        grid.getChildren().addAll(nameLabel,nameTXT,passLBL,passTXT,btnconfirm);
        //searching for valid teachers
        btnconfirm.setOnAction(e -> {

        boolean check1 = lst.contains(nameTXT.toString());
        boolean check2 = lst.contains(passTXT.toString());
        if(check1&&check2)
            window.setScene(szene2);
            window.setTitle("Teacher's acess ");
            window.show();

         //   Controller ctrl = new Controller();
           // ctrl.ConnectButton((ActionEvent) btnconfirm.getOnMouseClicked());
        });

        // making students page nice and ready ;)
        students S = new students();
        Label txtName = new Label();
        Label txtLastname = new Label();
        Label txtbDay = new Label();
        Label txtClass = new Label();
        Label txtMail = new Label();
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(txtName,txtLastname,txtbDay,txtClass,txtMail);
        BorderPane border2 = new BorderPane();
        border2.setTop(horizont);
        border2.setCenter(layout2);
        border2.setRight(grid);
        szene2 = new Scene(border2 , 520,500);
        //you insert elements inside a box and insert the box inside the border
        BorderPane border = new BorderPane();
        border.setTop(horizont);
        border.setCenter(layout1);
        border.setRight(grid);
        szene1 = new Scene(border , 350,300);
        window.setScene(szene1);
        window.setTitle("Main scene ");
        window.show();
    }

 private void closeThis(){
     boolean answer = displayAlert.displayAlert("are you sure ?","you will quit the app");
     if (answer){window.close();}
 }
    public void ConnectButton(ActionEvent actEv){
        sqlconnection konnek = new sqlconnection();
        Connection connectDB = konnek.getConnection();
        String queeryVar ="select * from student";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queeryOutput = statement.executeQuery(queeryVar);
            Main m = new Main();
            while (queeryOutput.next()){

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}
