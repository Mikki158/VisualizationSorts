package com.example.sortirovki;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;


public class FastSort extends Sort {
    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<Integer> operations = new LinkedList<>();// список для порядка операция
    int i1 = 0;
    int j1 = 0;
    int lenght = 0;


    public FastSort(LinkedList<Integer> numbers){
        this.numbers = numbers;
    }

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
                operations.add(j);
                operations.add(20);
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
        stage.setWidth(666);
        stage.setHeight(666);

        Pane root = new Pane();
        Scene scene = new Scene(root);
        LinkedList<Label> ListLabel = new LinkedList<>();
        LinkedList<Rectangle> ListRectangle = new LinkedList<>();


        int count = 70;
        for (Integer i : numbers) {

            Rectangle foncifr = new Rectangle(30, i * 10);
            foncifr.setTranslateX(count);
            foncifr.setTranslateY(400 - i * 10);
            foncifr.setFill(Color.web("#26527C"));
            foncifr.setStroke(Color.WHITE);

            ListRectangle.add(foncifr);

            count += 33;


            root.getChildren().add(foncifr);

        }

        count = 72;
        int NumberPosition = 0;
        for (Integer i : numbers) {
            String q = "" + i;
            Label jab = new Label();
            jab.setText(q);
            jab.setStyle("-fx-font-size : 12");
            jab.setStyle("-fx-font-weight: bold");
            jab.setStyle("-fx-font: 16 arial");
            jab.setTextFill(Color.WHITESMOKE);
//            if(i/10 >= 1){
//                jab.setTranslateX(ListRectangle.get(NumberPosition).getTranslateX() + 3);
//            }
//            if(i/10 <= 0){
//                jab.setTranslateX(ListRectangle.get(NumberPosition).getTranslateX() + 3);
//            }
            jab.setTranslateX(ListRectangle.get(NumberPosition).getTranslateX() + 5.5);
            jab.setTranslateY(380);

            ListLabel.add(jab);

            root.getChildren().add(jab);

            count += 21;
            NumberPosition += 1;

        }

        stage.setScene(scene);
        stage.show();

        boolean isSorted = false;
        int temp;

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

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            boolean faza = false;
            int vid = 1;
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(vid == 2){
                        ListRectangle.get(operations.get(0)).setFill(Color.web("#26527C"));
                        ListRectangle.get(operations.get(1)).setFill(Color.web("#26527C"));
                        vid = 1;

                    }

                    if(faza == true && vid == 1){
                        operations.remove(0);
                        operations.remove(0);
                        operations.remove(0);
                        faza = true;
                    }



                    if(vid == 0 && operations.get(2) == 10){ // 0 = true


                        ListRectangle.get(operations.get(0)).setFill(Color.web("#20815D"));
                        ListRectangle.get(operations.get(1)).setFill(Color.web("#20815D"));

                        Rectangle temprect = ListRectangle.get(operations.get(0));
                        ListRectangle.set(operations.get(0), ListRectangle.get(operations.get(1))).setFill(Color.web("#20815D"));
                        ListRectangle.set(operations.get(1), temprect);
                        double tempcoordsrect = ListRectangle.get(operations.get(0)).getTranslateX();
                        ListRectangle.get(operations.get(0)).setTranslateX(ListRectangle.get(operations.get(1)).getTranslateX());
                        ListRectangle.get(operations.get(1)).setTranslateX(tempcoordsrect);

                        Label templab;
                        double tempcoord;

                        templab = ListLabel.get(operations.get(0));
                        ListLabel.set(operations.get(0), ListLabel.get(operations.get(1)));
                        ListLabel.set(operations.get(1), templab);

                        tempcoord = ListLabel.get(operations.get(0)).getTranslateX();
                        ListLabel.get(operations.get(0)).setTranslateX(ListLabel.get(operations.get(1)).getTranslateX());
                        ListLabel.get(operations.get(1)).setTranslateX(tempcoord);
                        faza = true;
                        vid = 2; // 1 = false
                    }
                    if(vid == 0 && operations.get(2) == 20){
                        ListRectangle.get(operations.get(0)).setFill(Color.web("#BE2F33"));
                        ListRectangle.get(operations.get(1)).setFill(Color.web("#BE2F33"));
                        faza = true;
                        vid = 2;
                    }

                    if(vid == 1){
                        ListRectangle.get(operations.get(0)).setFill(Color.web("#FF8940"));
                        ListRectangle.get(operations.get(1)).setFill(Color.web("#FF8940"));
                        vid = 0;
                    }
                }
                catch (IndexOutOfBoundsException e){

                }
            }
        }));
        timeline.setCycleCount(lenght * 2 + 1);
        timeline.play();

        System.out.println("Конец");
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    public static void Animation(LinkedList<Integer> operation){

    }
}