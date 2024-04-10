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

public class VKL extends Sort {
    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<Integer> operations = new LinkedList<>();// список для порядка операция
    int i1 = 0;
    int j1 = 0;

    public VKL(LinkedList<Integer> numbers){
        this.numbers = numbers;
    }
    @Override
    public void MainSort() {
        Stage stage = new Stage();
        stage.setTitle("Сортировка включением");
        stage.setWidth(1100);
        stage.setHeight(666);

        Pane root = new Pane();
        Scene scene = new Scene(root);
        LinkedList<Label> ListLabel = new LinkedList<>();
        LinkedList<Rectangle> ListRectangle = new LinkedList<>();

        int count = 30;
        for(Integer i: numbers){

            Rectangle foncifr = new Rectangle(50,50);
            foncifr.setTranslateX(count-8);
            foncifr.setTranslateY(147);
            foncifr.setFill(Color.web("#26527C"));
            foncifr.setStroke(Color.WHITE);

            ListRectangle.add(foncifr);

            count += 50;


            root.getChildren().add(foncifr);

        }
        count = 30;
        for(Integer i: numbers){
            String q = ""+i;
            Label jab = new Label();
            jab.setText(q);
            jab.setStyle("-fx-font-size : 30");
            jab.setTranslateX(count);
            jab.setTranslateY(150);

            ListLabel.add(jab);

            root.getChildren().add(jab);

            count += 50;
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


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
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

    public static void Animation(LinkedList<Integer> operacii){

    }
}

