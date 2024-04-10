package com.example.sortirovki;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GlavMenU extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("Методы сортировок");
        stage.setWidth(500);
        stage.setHeight(500);

        Group root = new Group();
        Scene scene = new Scene(root);

        Button btn1 = new Button();
        btn1.setText("Сортировка цифр");
        btn1.setPrefSize(200, 50);
        btn1.setTranslateX(150);
        btn1.setTranslateY(160);
        btn1.setOnAction(event -> {
            WindowNumbers niGGer = new WindowNumbers();
            niGGer.start();

        });

        Button btn2 = new Button();
        btn2.setText("Сортировка цветов");
        btn2.setPrefSize(200, 50);
        btn2.setTranslateX(150);
        btn2.setTranslateY(240);
        btn2.setOnAction(event -> {
            WindowRGB WhiteniGGer = new WindowRGB();
            WhiteniGGer.start();

        });

        root.getChildren().addAll(btn1,btn2);
        stage.setScene(scene);
        stage.show();


    }
}
