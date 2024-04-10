package com.example.sortirovki;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RGBVkl extends Sort {

    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<Integer> operations = new LinkedList<>();// список для порядка операция
    int i1 = 0;
    int j1 = 0;


    @Override
    public void MainSort() {
        Stage stage = new Stage();
        stage.setTitle("Сортировка включением");
        stage.setWidth(1100);
        stage.setHeight(666);

        Group root = new Group();
        Scene scene = new Scene(root, Color.web("#2E2E2E"));
        LinkedList<Label> ListLabel = new LinkedList<>();
        LinkedList<Rectangle> ListRectangle = new LinkedList<>();

        for(int i = 0; i < 104; i++){
            numbers.add(i);
        }

        int count = 30;
        int r = 255;
        int g = 0;
        int b = 0;
        for(Integer i: numbers){
            Rectangle rectangle = new Rectangle(10, i*4);
            if(r == 255 && b == 0){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                g += 15;
            }
            if(g == 255 && b == 0){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                r -= 15;
            }
            if(r == 0 && g == 255){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                b += 15;
            }
            if(b == 255 && r == 0){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                g -= 15;
            }
            if(g == 0 && b == 255){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                r += 15;
            }
            if(r == 255 && g == 0){
                rectangle.setFill(Color.rgb(r, g, b));
                rectangle.setStroke(Color.rgb(r, g, b));
                b -= 15;
            }
            rectangle.setTranslateX(i*10+10);
            rectangle.setTranslateY(520 - i*4);
            root.getChildren().add(rectangle);
            ListRectangle.add(rectangle);
        }

        for(int i = 0; i < 102; i++){
            Random rnd = ThreadLocalRandom.current();
            int index = rnd.nextInt(i+1);
            int temp = numbers.get(index);
            numbers.set(index,numbers.get(i));
            numbers.set(i,temp);

            Rectangle tempRect = ListRectangle.get(index);
            ListRectangle.set(index, ListRectangle.get(i));
            ListRectangle.set(i, tempRect);
            double tempCoords = ListRectangle.get(index).getTranslateX();
            ListRectangle.get(index).setTranslateX(ListRectangle.get(i).getTranslateX());
            ListRectangle.get(i).setTranslateX(tempCoords);
        }

        stage.setScene(scene);
        stage.show();

        boolean isSorted = false;
        int temp;

        int lenght = 0;

        int sizelist = 0;
        for(Integer i: numbers){
            sizelist += 1;
        }
        System.out.println("Длина листа = " + sizelist);

        for(int i = 1; i < sizelist; i++){
            int k = numbers.get(i);
            int j = i - 1;

            while (j >= 0 && numbers.get(j) > k){
                numbers.set(j+1, numbers.get(j));
                numbers.set(j, k);

                operations.add(j+1);
                operations.add(j);
                operations.add(10);
                lenght += 1;
                System.out.println(j);
                System.out.println(j+1 + "j+1");

                j--;
            }

        }

        System.out.println();
        System.out.println("Отсортированный массив: ");
        i1 = 0;
        for(Integer i: numbers){
            System.out.print(numbers.get(i1) + " ");
            i1 += 1;
        }
        for(Integer i: operations){
            System.out.println(i);
        }


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(11), new EventHandler<ActionEvent>() {
            boolean faza = true;

            @Override
            public void handle(ActionEvent event) {

               try {
                   Rectangle temprect = ListRectangle.get(operations.get(0));
                   ListRectangle.set(operations.get(0), ListRectangle.get(operations.get(1)));
                   ListRectangle.set(operations.get(1), temprect);
                   double tempcoordsrect = ListRectangle.get(operations.get(0)).getTranslateX();
                   ListRectangle.get(operations.get(0)).setTranslateX(ListRectangle.get(operations.get(1)).getTranslateX());
                   ListRectangle.get(operations.get(1)).setTranslateX(tempcoordsrect);

                   Label templab;
                   double tempcoord;

                   operations.remove(0);
                   operations.remove(0);
                   operations.remove(0);
                   faza = true;
               }
               catch (IndexOutOfBoundsException e){

               }
            }

        }));
        timeline.setCycleCount(lenght * 2 + 1);
        timeline.play();

        System.out.println("Конец");
    }
}
