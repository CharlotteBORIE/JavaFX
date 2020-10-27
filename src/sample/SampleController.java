package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class SampleController  {

    public Label helloWorld;
    public Canvas canvas;

    public void initialize(Stage primaryStage){
        GraphicsContext gc =  canvas.getGraphicsContext2D();

        EventHandler<MouseEvent> drawEventHandler =
                e -> {
                    // 1° can access private element of controller
                    // (accès aux canvas)
                    double x=e.getX();
                    double y=e.getY();
                    double r=5;         //on choisit le rayon
                    gc.setFill(Color.DARKRED);
                    gc.strokeOval(x,y,r,r);


                };
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,drawEventHandler);

        Group root = new Group(gc.getCanvas());
        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }


    public void clearImage() {
        GraphicsContext gc =  canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

    }
}
