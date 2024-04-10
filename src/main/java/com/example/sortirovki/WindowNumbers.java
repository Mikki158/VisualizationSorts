package com.example.sortirovki;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class WindowNumbers {
    String temp;
    LinkedList<Integer> chisla = new LinkedList<>();
    LinkedList<String> slova = new LinkedList<>();


    public void start() {
        Stage stage = new Stage();
        stage.setTitle("Методы сортировок");
        stage.setWidth(700);
        stage.setHeight(666);


        Pane root = new Pane();  //#2E2E2E

        Label lab = new Label();
        lab.setText("Menu");
        lab.setTranslateY(100);
        lab.setTranslateX(100);

        TextField login = new TextField();
        login.setPromptText("Введите числа через пробел");
        login.setPrefSize(350, 20);
        login.setTranslateX(150);
        login.setTranslateY(300);

        Button btn = new Button();
        btn.setText("Пирамидальная");
        btn.setPrefSize(200, 20);
        btn.setTranslateX(100);
        btn.setTranslateY(100);
        btn.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            PyramidSort pyramid = new PyramidSort(chisla);
            pyramid.MainSort();
        });

        Button btn2 = new Button();
        btn2.setText("Шейкерная");
        btn2.setPrefSize(200, 20);
        btn2.setTranslateX(100);
        btn2.setTranslateY(200);
        btn2.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            //System.out.println(temp);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            ShakerSort shaker = new ShakerSort(chisla);
            shaker.MainSort();
        });

        Button btn3 = new Button();
        btn3.setText("Пузырьковая");
        btn3.setPrefSize(200, 20);
        btn3.setTranslateX(100);
        btn3.setTranslateY(500);
        btn3.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            BubbleSort bubble = new BubbleSort(chisla);
            bubble.MainSort();
        });

        Button btn4 = new Button();
        btn4.setText("Выбором");
        btn4.setPrefSize(200, 20);
        btn4.setTranslateX(400);
        btn4.setTranslateY(500);
        btn4.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            //System.out.println(temp);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            ChoiceSort choice = new ChoiceSort(chisla);
            choice.MainSort();
        });

        Button btn5 = new Button();
        btn5.setText("Включением");
        btn5.setPrefSize(200, 20);
        btn5.setTranslateX(400);
        btn5.setTranslateY(200);
        btn5.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            //System.out.println(temp);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            VKL inclusion = new VKL(chisla);
            inclusion.MainSort();
        });

        Button btn6 = new Button();
        btn6.setText("Поразрядная слов");
        btn6.setPrefSize(200, 20);
        btn6.setTranslateX(400);
        btn6.setTranslateY(400);
        btn6.setOnAction(event -> {
            slova.clear();
            int start = 0;
            int end = 0;
            int max = 0;
            int sizelist = 0;
            temp = login.getText();
            temp = temp + " ";
            //System.out.println(temp);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    slova.add(temp2);
                    sizelist += 1;
                    start = end + 1;
                    end = start;
                    if (temp2.length() > max) {
                        max = temp2.length();
                    }
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }

            for (int i = 0; i < sizelist; i++) {
                for (int j = 0; j < max; j++) {
                    if (slova.get(i).length() < max) {
                        slova.set(i, slova.get(i) + " ");
                    }
                }
            }

            for (String i : slova) {
            }
            System.out.print("Максимальная длинна слова = " + max);
           BitwiseSort slovo = new BitwiseSort(slova, sizelist, max);
            slovo.MainSort();
        });

        Button btn7 = new Button();
        btn7.setText("Быстрая");
        btn7.setPrefSize(200, 20);
        btn7.setTranslateX(100);
        btn7.setTranslateY(400);
        btn7.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            FastSort faster = new FastSort(chisla);
            faster.MainSort();
        });

        Button btn8 = new Button();
        btn8.setText("Извлечением");
        btn8.setPrefSize(200, 20);
        btn8.setTranslateX(400);
        btn8.setTranslateY(100);
        btn8.setOnAction(event -> {
            chisla.clear();
            int start = 0;
            int end = 0;
            temp = login.getText();
            temp = temp + " ";
            //System.out.println(temp);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    String temp2 = temp.substring(start, end);
                    int NumberList = Integer.parseInt(temp2);
                    chisla.add(NumberList);
                    start = end + 1;
                    end = start;
                    if (true == false) {
                        System.exit(0);
                    }
                } else end += 1;

            }
            for (Integer i : chisla) {
                System.out.print(i + " ");
            }
            ExtractionSort izvlec = new ExtractionSort(chisla);
            izvlec.MainSort();
        });

        Scene scene = new Scene(root);

        root.getChildren().addAll(btn, btn2, btn3, btn4, btn5, btn6, btn7, btn8, login);
        stage.setScene(scene);
        stage.show();

    }
}