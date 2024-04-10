package com.example.sortirovki;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class MergeNeGotova extends Sort {

    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<Integer> operations = new LinkedList<>();// список для порядка операция

    public MergeNeGotova(LinkedList<Integer> numbers){
        this.numbers = numbers;
    }


    public void mergeSort(LinkedList<Integer> src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        LinkedList<Integer> left= new LinkedList<>();
        LinkedList<Integer> right= new LinkedList<>();

        for (int i = 0; i < mid; i++ ) {
            left.add(i,src.get(i));
        }

        for (int i = mid; i < n-mid; i++ ) {
            right.add(i,src.get(i));
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }
    public static void merge(LinkedList<Integer> src, LinkedList<Integer> left, LinkedList<Integer> right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left.get(i) <= right.get(j)) {
                src.set(k++,left.get(i++));
            }
            else src.set(k++,right.get(j++));
        }

        while (i < leftLength) {
            src.set(k++,left.get(i++));
        }

        while (j < rightLength) {
            src.set(k++,right.get(j++));
        }
    }

    @Override
    public void MainSort() {
        Stage stage = new Stage();
        stage.setTitle("Пузырьковая");
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

        int temp;
        int lenght = 0;
        int sizelistnumb = 0;

        for (Integer i : numbers) {
            sizelistnumb += 1;
        }
        System.out.println("Длина листа = " + sizelistnumb);
        mergeSort(numbers,sizelistnumb);

        System.out.println();
        System.out.println("Отсортированный массив: ");
        for (Integer i : numbers) {
            System.out.print(i + " ");
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
}
