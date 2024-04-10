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

public class FastRGB extends Sort {

    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<Integer> operations = new LinkedList<>();// список для порядка операция
    int i1 = 0;
    int j1 = 0;
    int lenght = 0;

    public void quickSort(LinkedList<Integer> array, int low, int high){
        if(array.size() == 0){
            return;
        }
        if(low >= high){
            return;
        }

        int middle = low + (high - low) / 2;
        int opora = array.get(middle);

        int i = low;
        int j = high;

        while (i <= j){
            while (array.get(i) < opora){
                i++;
            }
            while (array.get(j) > opora){
                j--;
            }
            if(i <= j){
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);

                operations.add(i);
                operations.add(j);
                operations.add(10);
                lenght += 1;

                i++;
                j--;
            }
            else {
                operations.add(i);
                operations.add(i);
                operations.add(10);
                lenght += 1;
            }
        }

        if(low < j){
            quickSort(array, low, j);
        }
        if(high > i){
            quickSort(array, i, high);
        }
    }


    @Override
    public void MainSort() {
        Stage stage = new Stage();
        stage.setTitle("Быстрая");
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


        int sizelist = 0;
        for(Integer i: numbers){
            sizelist += 1;
        }
        System.out.println("Длина листа = " + sizelist);

        int tempsort = sizelist + 1;

        int low = 0;
        int hight = numbers.size() - 1;

        quickSort(numbers, low, hight);



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


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
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
