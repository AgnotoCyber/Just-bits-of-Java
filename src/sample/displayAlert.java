package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class displayAlert {
    static Boolean choice;
    public static boolean displayAlert (String title , String info){
        Stage window2 = new Stage() ;
        //initmodality prevents the user from useing the back stage
        window2.initModality(Modality.APPLICATION_MODAL);
        window2.setTitle(title);
        window2.setMinHeight(100);
        window2.setMinWidth(250);
        Label lbl = new Label();
        lbl.setText(info);

        Button butt1 = new Button("yes");
        Button butt2 = new Button("no");
        butt1.setOnAction(e ->{
            choice = true;
            window2.close();

        });
        butt2.setOnAction(e ->{
            choice = false;
            window2.close();
        });
        VBox crapArrange = new VBox(5);
        crapArrange.getChildren().addAll(lbl,butt1,butt2);
        crapArrange.setAlignment(Pos.CENTER);
        Scene szene = new Scene(crapArrange);
        window2.setScene(szene);
        window2.showAndWait();

        return choice;

    }
}
