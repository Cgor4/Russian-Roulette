package cgor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class gun extends Application {

    //application launcher function
    public static void main(String[]args) {
        launch(args);
    }


    //main void

    @Override
    public void start(Stage primaryStage) throws Exception {

        //application dimension variables
        double appWidth = 450;
        double appHeight = appWidth/1.5;



        //application objects & window structure elements

        //Stack pane & HBox's for scene creation
        StackPane mainPane = new StackPane();
        HBox buttonBox = new HBox();
        HBox gunBox = new HBox();


        //Resource for Image of a gun (created by yours truly)
        Image revolver = new Image("cgor/revolver.png");


        //Game loss & game win text
        Text l = new Text("YOU DIED!");
        Text w = new Text("YOU WIN!");
        l.setStroke(Color.RED);
        w.setStroke(Color.GREEN);
        l.setFont(new Font(40));
        w.setFont(new Font(40));
        l.setVisible(false);
        w.setVisible(false);

        //button to fire gun  (triggers random # generator which generates a # between 1 and 6. If the number is 6, then the player loses. Otherwise, they win.)
        Button fire = new Button("Press to fire");
        fire.setOnAction(event -> {
            int i;
            l.setVisible(false);
            w.setVisible(false);
            Random bullet = new Random();
            i = bullet.nextInt(6) + 1;
            System.out.println(i);

            //winning & losing conditionals (If the player loses, the game over text will be displayed, otherwise the game won text will appear)
            if(i == 6) {
                System.out.println("BANG!");
                    l.setVisible(true);
            } else{
                System.out.println("YOU WIN!");
                    w.setVisible(true);
            }

        });



        //Fire button position settings
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        gunBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(100);

        //window structure setup
        primaryStage.setTitle("RUSSIAN ROULETTE");
        primaryStage.setWidth(appWidth);
        primaryStage.setHeight(appHeight);


        //addition of elements to the main pane and organizers within pane

        mainPane.getChildren().add(gunBox);
        gunBox.getChildren().add(new ImageView(revolver));

        mainPane.getChildren().add(buttonBox);
        mainPane.getChildren().addAll(l,w);
        buttonBox.getChildren().add(fire);



        //scene creation and window launch
        Scene scn = new Scene(mainPane,appWidth,appHeight);
        primaryStage.setScene(scn);
        primaryStage.show();


    }


}
