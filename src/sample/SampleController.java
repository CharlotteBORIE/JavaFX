package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

import javafx.scene.input.MouseEvent;

import java.util.concurrent.atomic.AtomicInteger;


public class SampleController  {

    public Label helloWorld;
    public Canvas canvas;
    public Slider Red;
    public Slider Green;
    public Slider Blue;
    public Canvas ColorBox;

    public void initialize(){
        GraphicsContext gc =  canvas.getGraphicsContext2D();

        AtomicInteger red= new AtomicInteger();
        AtomicInteger green = new AtomicInteger();
        AtomicInteger blue= new AtomicInteger();

        //initialisation des sliders
        Red.valueProperty().addListener((observable, oldValue, newValue) -> {
                    red.set(newValue.intValue());
                    SetColor(ColorBox,red,green,blue);
        });

        Green.valueProperty().addListener((observable, oldValue, newValue) -> {
                    green.set(newValue.intValue());
                    SetColor(ColorBox,red,green,blue);
        });
        Blue.valueProperty().addListener((observable, oldValue, newValue) -> {
                    blue.set(newValue.intValue());
                    SetColor(ColorBox,red,green,blue);
        });





        EventHandler<MouseEvent> drawEventHandler =
                e -> {
                    // 1° can access private element of controller
                    // (accès aux canvas)
                    double x=e.getX();
                    double y=e.getY();
                    double r=10;         //on choisit le rayon
                    gc.setFill(Color.rgb(red.get(), green.get(), blue.get()));
                    gc.fillOval(x-r/2,y-r/2,r,r);


                };
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,drawEventHandler);
        

    }
    private void SetColor(Canvas can, AtomicInteger red, AtomicInteger green,AtomicInteger blue ){
        GraphicsContext gc =  can.getGraphicsContext2D();
        gc.setFill(Color.rgb(red.get(), green.get(), blue.get()));
        gc.fillRect(0, 0, can.getWidth(), can.getHeight());
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
