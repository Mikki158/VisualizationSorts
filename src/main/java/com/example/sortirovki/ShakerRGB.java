package com.example.sortirovki;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShakerRGB extends Sort {

    @Override
    public void MainSort() {
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, Color.web("#2E2E2E"));

        int[][] IsxodMass = new int[102][102];
        for(int i = 0; i < 102; i++){
            for(int j = 0; j < 102; j++){
                IsxodMass[i][j] = j;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        LinkedList<LinkedList<Rectangle>> ListRectangle = new LinkedList<>();
        LinkedList<LinkedList<Integer>> ListInteger = new LinkedList<>();

        for(int i = 0; i < 102; i++){
            ListRectangle.add(new LinkedList<>());
        }
        for(int i = 0; i < 102; i++){
            ListInteger.add(new LinkedList<>());
        }
        int r;
        int g;
        int b;
        for(int i = 0; i < 102; i ++){
            r = 255;
            g = 0;
            b = 0;
            for(int j = 0; j < 102; j++){

                Rectangle rectangle = new Rectangle(5, 5);
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
                rectangle.setTranslateX(j*5+70);
                rectangle.setTranslateY(i*5+60);
                root.getChildren().add(rectangle);
                ListRectangle.get(i).add(rectangle);

            }
        }

        for(int i = 101; i > 0; i--){
            Random rnd = ThreadLocalRandom.current();
            for(int j = 101; j > 0; j--){
                for(int u = 0; u < 102; u++){
                    int index = rnd.nextInt(i+1);
                    int temp = IsxodMass[u][index];
                    IsxodMass[u][index] = IsxodMass[u][i];
                    IsxodMass[u][i] = temp;

                    Rectangle tempRect = ListRectangle.get(u).get(index);
                    ListRectangle.get(u).set(index, ListRectangle.get(u).get(i));
                    ListRectangle.get(u).set(i, tempRect);
                    double tempCoords = ListRectangle.get(u).get(index).getTranslateX();
                    ListRectangle.get(u).get(index).setTranslateX(ListRectangle.get(u).get(i).getTranslateX());
                    ListRectangle.get(u).get(i).setTranslateX(tempCoords);
                }
            }
        }
        int lenght = 0;

        int left, right;
        left = 1;
        right = 102 - 1;
        while (left <= right){
            for(int i = right; i >= left; i--){
                for(int u = 0; u < 102; u++){
                    if(IsxodMass[u][i-1] > IsxodMass[u][i]){
                        int temp = IsxodMass[u][i];
                        IsxodMass[u][i] = IsxodMass[u][i-1];
                        IsxodMass[u][i-1] = temp;

                        ListInteger.get(u).add(i);
                        ListInteger.get(u).add(i-1);

                        lenght += 1;

                    }
                    else{
                        ListInteger.get(u).add(i);
                        ListInteger.get(u).add(i);

                    }
                }

            }
            left++;
            for(int i = left; i <= right; i++){
                for(int u = 0; u < 102; u++){
                    if(IsxodMass[u][i-1] > IsxodMass[u][i]){
                        int temp = IsxodMass[u][i];
                        IsxodMass[u][i] = IsxodMass[u][i-1];
                        IsxodMass[u][i-1] = temp;

                        ListInteger.get(u).add(i);
                        ListInteger.get(u).add(i-1);

                        lenght += 1;

                    }
                    else{
                        ListInteger.get(u).add(i);
                        ListInteger.get(u).add(i);

                    }
                }
            }
            right --;
        }

        stage.setTitle("Шейкерная");
        stage.setWidth(666);
        stage.setHeight(666);



        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            int u = 0;
            @Override
            public void handle(ActionEvent event) {
                try {
                    for(int i = 0; i < 102; i++){
                        Rectangle tempRect = ListRectangle.get(i).get(ListInteger.get(i).get(u+1));
                        ListRectangle.get(i).set(ListInteger.get(i).get(u+1), ListRectangle.get(i).get(ListInteger.get(i).get(u)));
                        ListRectangle.get(i).set(ListInteger.get(i).get(u), tempRect);

                        double tempCoords = ListRectangle.get(i).get(ListInteger.get(i).get(u+1)).getTranslateX();
                        ListRectangle.get(i).get(ListInteger.get(i).get(u+1)).setTranslateX(ListRectangle.get(i).get(ListInteger.get(i).get(u)).getTranslateX());
                        ListRectangle.get(i).get(ListInteger.get(i).get(u)).setTranslateX(tempCoords);

                        ListInteger.get(i).remove(0);
                        ListInteger.get(i).remove(0);
                    }
                }
                catch (IndexOutOfBoundsException e){

                }
            }
        }));
        timeline.setCycleCount(lenght);
        timeline.play();

        stage.setScene(scene);
        stage.show();


    }
}
