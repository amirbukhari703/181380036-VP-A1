package sample;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    private TextField marks;
    private DatePicker datePicker;
    private Label titleLb, dateLb, marksLb;
    private Button save;
    private HBox dateBox, marksBox, btnBox;
    private VBox root;



    @Override
    public void start(Stage primaryStage) {
        // create functions
        marks = new TextField();
        marks.setPrefWidth(200);
        datePicker = new DatePicker();
        datePicker.setPrefWidth(200);
        titleLb = new Label("My CP Tracker");
        titleLb.setFont(new Font("Arial",22));
        dateLb = new Label("Date:");
        dateLb.setFont(new Font(16));
        marksLb = new Label("Marks:");
        marksLb.setFont(new Font(16));
        save = new Button("Save Data");
        save.setFont(new Font(16));

        //apply events
        save.setOnAction((ActionEvent event) -> {
            save();
        });
        //created datebox
        dateBox = new HBox(70);
        dateBox.getChildren().addAll(dateLb,datePicker);

        //created markBox

        marksBox = new HBox(70);
        marksBox.getChildren().addAll(marksLb,marks);

        //created btnBox

        btnBox = new HBox();
        btnBox.getChildren().add(save);

        //set Postions and passing
        dateBox.setAlignment(Pos.CENTER);
        marksBox.setAlignment(Pos.CENTER);
        btnBox.setAlignment(Pos.CENTER_RIGHT);
        btnBox.setPadding(new Insets(0,40,0,0));



        root = new VBox(20);
        root.getChildren().addAll(titleLb,dateBox,marksBox, btnBox);
        root.setAlignment(Pos.CENTER);

        //created scene
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("RollNumber CP Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //get value from user
    private void save(){
        try(PrintWriter writer=new PrintWriter(new FileWriter("cp.txt",true))){
            String str="----- CP Marks on "+datePicker.getValue().toString()+" ----------\n";
            str+=" Marks: "+marks.getText();
            writer.println(str);
            alert(str);
        }
        catch(Exception exception){
            System.out.println("Error: "+ exception.getMessage());
        }
    }

    //show alert
    private void alert(String data){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("CP Data Saved");
        alert.setHeaderText("Your CP data is saved successfully");
        alert.setContentText(data);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

