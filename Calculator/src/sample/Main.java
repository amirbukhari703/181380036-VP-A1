package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    private VBox pain;
    private HBox labelHox, calOneHBox, calTwoHBox, calThreeHBox, calFourHBox, calFiveHBox;
    private Label show;
    private Button divisionBtn, sqrtBtn, powerBtn, clearBtn, multiplyBtn, minisBtn, plusBtn, equalBtn, dotBtn, plusMinisBtn, zeroBtn,
                    oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;


    @Override
    public void start(Stage primaryStage) throws Exception{

        //created result there
        show = new Label("0");
        labelHox = new HBox(30, show);
        show.setFont(new Font(25));
        labelHox.setAlignment(Pos.BOTTOM_RIGHT);


        //now created all button in a list

        //all functions
        clearBtn=new Button("C");
        clearBtn.setPrefWidth(120);
        clearBtn.setPrefHeight(60);
        powerBtn=new Button("X^2");
        powerBtn.setPrefHeight(60);
        powerBtn.setPrefWidth(120);
        sqrtBtn=new Button("Sqrt");
        sqrtBtn.setPrefWidth(120);
        sqrtBtn.setPrefHeight(60);
        divisionBtn=new Button("/");
        divisionBtn.setPrefHeight(60);
        divisionBtn.setPrefWidth(120);
        multiplyBtn=new Button("X");
        multiplyBtn.setPrefHeight(60);
        multiplyBtn.setPrefWidth(120);
        plusBtn=new Button("+");
        plusBtn.setPrefHeight(60);
        plusBtn.setPrefWidth(120);
        minisBtn=new Button("-");
        minisBtn.setPrefHeight(60);
        minisBtn.setPrefWidth(120);
        plusMinisBtn=new Button("+/-");
        plusMinisBtn.setPrefWidth(120);
        plusMinisBtn.setPrefHeight(60);
        zeroBtn=new Button("0");
        zeroBtn.setPrefHeight(60);
        zeroBtn.setPrefWidth(120);
        dotBtn=new Button(".");
        dotBtn.setPrefWidth(120);
        dotBtn.setPrefHeight(60);
        equalBtn=new Button("=");
        equalBtn.setPrefHeight(60);
        equalBtn.setPrefWidth(120);

        oneBtn=new Button("1");
        oneBtn.setPrefWidth(120);
        oneBtn.setPrefHeight(60);
        twoBtn=new Button("2");
        twoBtn.setPrefHeight(60);
        twoBtn.setPrefWidth(120);
        threeBtn=new Button("3");
        threeBtn.setPrefWidth(120);
        threeBtn.setPrefHeight(60);
        fourBtn=new Button("4");
        fourBtn.setPrefWidth(120);
        fourBtn.setPrefHeight(60);
        fiveBtn=new Button("5");
        fiveBtn.setPrefHeight(60);
        fiveBtn.setPrefWidth(120);
        sixBtn=new Button("6");
        sixBtn.setPrefWidth(120);
        sixBtn.setPrefHeight(60);
        sevenBtn=new Button("7");
        sevenBtn.setPrefWidth(120);
        sevenBtn.setPrefHeight(60);
        eightBtn=new Button("8");
        eightBtn.setPrefHeight(60);
        eightBtn.setPrefWidth(120);
        nineBtn=new Button("9");
        nineBtn.setPrefWidth(120);
        nineBtn.setPrefHeight(60);

        //line one
        calOneHBox = new HBox(clearBtn, powerBtn, sqrtBtn, divisionBtn);
        calOneHBox.setAlignment(Pos.BOTTOM_CENTER);

        //line two
        calTwoHBox = new HBox(sevenBtn, eightBtn, nineBtn, multiplyBtn);
        calTwoHBox.setAlignment(Pos.BOTTOM_CENTER);

        //line three
        calThreeHBox = new HBox(fourBtn, fiveBtn,sixBtn,minisBtn);
        calThreeHBox.setAlignment(Pos.BOTTOM_CENTER);

        //line four
        calFourHBox = new HBox(oneBtn, twoBtn, threeBtn, plusBtn);
        calFourHBox.setAlignment(Pos.BOTTOM_CENTER);

        //line five
        calFiveHBox = new HBox(plusMinisBtn, zeroBtn, dotBtn, equalBtn);
        calFiveHBox.setAlignment(Pos.BOTTOM_CENTER);

        //set all action in pain
        pain = new VBox(labelHox, calOneHBox, calTwoHBox, calThreeHBox, calFourHBox, calFiveHBox);

        //Apply clickListener
        calculate lb1 = new calculate();
        oneBtn.setOnAction(lb1);
        twoBtn.setOnAction(lb1);
        threeBtn.setOnAction(lb1);
        fourBtn.setOnAction(lb1);
        fiveBtn.setOnAction(lb1);
        sixBtn.setOnAction(lb1);
        sevenBtn.setOnAction(lb1);
        eightBtn.setOnAction(lb1);
        nineBtn.setOnAction(lb1);
        zeroBtn.setOnAction(lb1);

        //Operating Buttons
        calculateWork run = new calculateWork();
        divisionBtn.setOnAction(run);
        clearBtn.setOnAction(run);
        sqrtBtn.setOnAction(run);
        powerBtn.setOnAction(run);
        equalBtn.setOnAction(run);
        multiplyBtn.setOnAction(run);
        minisBtn.setOnAction(run);
        plusBtn.setOnAction(run);



        //created scene
        Scene scene = new Scene(pain);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private class calculate implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent e) {
            if(e.getSource() == zeroBtn){
                show.setText("0");
            }
            else if(e.getSource() == oneBtn){
                show.setText("1");
            }
            if(e.getSource() == twoBtn){
                show.setText("2");
            }
            else if(e.getSource() == threeBtn){
                show.setText("3");
            }
            if(e.getSource() == fourBtn){
                show.setText("4");
            }
            else  if(e.getSource() == fiveBtn){
                show.setText("5");
            }
            if(e.getSource() == sixBtn){
                show.setText("6");
            }
            else  if(e.getSource() == sevenBtn){
                show.setText("7");
            }
            if(e.getSource() == eightBtn){
                show.setText("8");
            }
            else if(e.getSource() ==  nineBtn){
                show.setText("9");
            }
        }
    }



    public class calculateWork implements EventHandler<ActionEvent> {

        double number, value;
        String string;

        @Override
        public void handle(ActionEvent e) {

            if(e.getSource() == clearBtn){
                show.setText("0");
            }
            else if(e.getSource() == powerBtn){

                value = getNumber(show);
                value=Math.pow(value,2);
                show.setText(value+"");
            }
            else if(e.getSource() == sqrtBtn){

                value = getNumber(show);
                System.out.println(value);
                value=Math.sqrt(value);
                show.setText(value+"");
            }
            else if(e.getSource() == divisionBtn){

                value = getNumber(show);
                show.setText(null);
                string = "divide";

            }
            else if(e.getSource() == multiplyBtn){

                value = getNumber(show);
                show.setText(null);
                string = "multiply";

            }
            else if(e.getSource() == minisBtn){

                value = getNumber(show);
                show.setText(null);
                string = "minis";
            }
            else if(e.getSource() == plusBtn){

                value = getNumber(show);
                show.setText(null);
                string = "plus";
            }

            else if(e.getSource()==equalBtn){
                if(string.equals("division")){

                    number = getNumber(show);
                    String number1 = value / number + "";
                    if(number1.equalsIgnoreCase("Infinity")){
                        show.setText("Error");
                    }
                    else {
                        show.setText(getValue(value / number));
                    }
                }
                else if(string.equals("multiply")){
                    number = getNumber(show);
                    show.setText(getValue(value * number));

                }
                else if(string.equals("minis")){
                    number = getNumber(show);
                    show.setText(getValue(value - number));
                }
                else if(string.equals("plus")){
                    number = getNumber(show);
                    show.setText(getValue(value + number));
                }
            }


        }
    }
    public double getNumber(Label label){
        return Double.parseDouble(show.getText().toString());
    }
    public String getValue(double value){
        return value + "";
    }




    public static void main(String[] args) {
        launch(args);
    }
}
