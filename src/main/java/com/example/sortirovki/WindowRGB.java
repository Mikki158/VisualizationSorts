package com.example.sortirovki;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowRGB{

    public void start() {
        Stage stage = new Stage();
        stage.setTitle("Методы сортировок");
        stage.setWidth(670);
        stage.setHeight(500);

        Pane root = new Pane();  //#2E2E2E

        Label lab = new Label();
        lab.setText("Menu");
        lab.setTranslateY(100);
        lab.setTranslateX(100);

        Button btn = new Button();
        btn.setText("Пирамидальная");
        btn.setPrefSize(150, 50);
        btn.setTranslateX(50);
        btn.setTranslateY(100);
        btn.setOnAction(event -> {
            PyramidRGB izvlekli = new PyramidRGB();
            izvlekli.MainSort();
        });

        Button btn2 = new Button();
        btn2.setText("Шейкерная");
        btn2.setPrefSize(150, 50);
        btn2.setTranslateX(250);
        btn2.setTranslateY(100);
        btn2.setOnAction(event -> {
            ShakerRGB shaker = new ShakerRGB();
            shaker.MainSort();
        });

        Button btn3 = new Button();
        btn3.setText("Пузырьковая");
        btn3.setPrefSize(150, 50);
        btn3.setTranslateX(450);
        btn3.setTranslateY(100);
        btn3.setOnAction(event -> {
            BubbleRGB bubble = new BubbleRGB();
            bubble.MainSort();
        });

        Button btn4 = new Button();
        btn4.setText("Выбором");
        btn4.setPrefSize(150, 50);
        btn4.setTranslateX(50);
        btn4.setTranslateY(200);
        btn4.setOnAction(event -> {
            ChoiceRGB choice = new ChoiceRGB();
            choice.MainSort();
        });

        Button btn5 = new Button();
        btn5.setText("Включением");
        btn5.setPrefSize(150, 50);
        btn5.setTranslateX(250);
        btn5.setTranslateY(200);
        btn5.setOnAction(event -> {
            RGBVkl inclusion = new RGBVkl();
            inclusion.MainSort();
        });

        Button btn6 = new Button();
        btn6.setText("Быстрая");
        btn6.setPrefSize(150, 50);
        btn6.setTranslateX(450);
        btn6.setTranslateY(200);
        btn6.setOnAction(event -> {
            FastRGB faster = new FastRGB();
            faster.MainSort();
        });

        Button btn7 = new Button();
        btn7.setText("Извлечением");
        btn7.setPrefSize(150, 50);
        btn7.setTranslateX(250);
        btn7.setTranslateY(300);
        btn7.setOnAction(event -> {
            ExtractionRGB bubble2 = new ExtractionRGB();
            bubble2.MainSort();
        });

        Scene scene = new Scene(root);

        root.getChildren().addAll(btn, btn2, btn3, btn4, btn5, btn6, btn7);
        stage.setScene(scene);
        stage.show();

    }
}
