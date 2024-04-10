package com.example.sortirovki;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.chrono.MinguoDate;
import java.util.LinkedList;

public class BitwiseSort extends Sort {
    LinkedList<Integer> numbers = new LinkedList<>();// список сортируемых чисел
    LinkedList<String> slovi = new LinkedList<>();
    LinkedList<String> operacii2 = new LinkedList<>();// список для порядка операция
    LinkedList<Label> operacii = new LinkedList<>();
    LinkedList<Double> LabCisla = new LinkedList<>();// список для лэйблов цифр
    LinkedList<Label> bukvi = new LinkedList<>();
    int i1 = 0;
    int j1 = 0;
    int sizelist;
    int max;
    int dlina = 0;
    int count;
    int count2 = 0;
    int position;


    public BitwiseSort(LinkedList<String> slovi, int sizelist, int max) {
        this.slovi = slovi;
        this.sizelist = sizelist;
        this.max = max;
    }

    public static int getDigit(int position, String value) {

        char c = value.toLowerCase().charAt(position);

        if ((int) c == 32) {
            return 0;
        }

        return (int) c - 1071;

    }

    public void SortSlova(String[][] help1, String[][] help2, int q, int sizelist) {
        int m = 0;
        int position;

        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < sizelist; j++) {
                if (help1[i][j] != null) {
                    m = 0;

                    position = getDigit(q, help1[i][j]);

                    while (help2[position][m] != null) {
                        m += 1;
                    }

                    help2[position][m] = help1[i][j];

                    Label label = new Label();
                    label.setText(help1[i][j]);
                    label.setStyle("-fx-font-size : 15");
                    label.setTranslateX(30 + (max * m * 10));
                    label.setTranslateY(bukvi.get(position).getTranslateY());

                    operacii.add(label);

                    dlina += 1;

                    help1[i][j] = null;
                }
            }
        }
    }
    @Override
    public void MainSort() {
        Stage stage = new Stage();
        stage.setTitle("Поразрядная сортировка");
        stage.setWidth(780);
        stage.setHeight(780);

        Group root = new Group();
        Scene scene = new Scene(root, 780, 780, Color.WHITE);
        LinkedList<Label> listlab = new LinkedList<>();
        LinkedList<Rectangle> listrab = new LinkedList<>();

        String[] alfavit = {"-", "А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};
        count = 0;
        int poradok = 0;
        for (int i = 0; i < 33; i++) {
            Label text = new Label(alfavit[i]);
            text.setTranslateX(15);
            text.setTranslateY(50 + (20 * i));
            text.setStyle("-fx-font-size : 15");

            Line line = new Line(0, 50 + (20 * (i + 1)), 720, 50 + (20 * (i + 1)));
            line.setStrokeWidth(1);
            line.setStroke(Color.web("#DEDEDE"));


            bukvi.add(text);

            root.getChildren().addAll(text, line);
        }

        count = 0;
        for (String i : slovi) {
            String q = "" + i;
            Label jab = new Label();
            jab.setText(q);
            jab.setStyle("-fx-font-size : 15");
            jab.setTranslateX(60 + (max * count * 10));
            jab.setTranslateY(20);

            listlab.add(jab);

            root.getChildren().add(jab);

            count += 1;
        }

        stage.setScene(scene);
        stage.show();

        String[][] help1 = new String[35][sizelist];
        String[][] help2 = new String[35][sizelist];

        int m = 0;

        for (int i = 0; i < sizelist; i++) {
            int j = 0;

            position = getDigit(max - 1, slovi.get(i));

            while (help1[position][j] != null) {
                j += 1;
            }
            help1[position][j] = slovi.get(i);

            Label label = new Label();
            label.setText(slovi.get(i));
            label.setStyle("-fx-font-size : 15");
            label.setTranslateX(30 + (max * j * 10));
            label.setTranslateY(bukvi.get(position).getTranslateY());

            operacii.add(label);

            dlina += 1;
        }
        Label lab = new Label();
        lab.setText("!");
        operacii.add(lab);
        for (int i1 = 0; i1 < 34; i1++) {
            for (int j1 = 0; j1 < sizelist; j1++) {

                if (help1[i1][j1] != null) {
                    operacii2.add(help1[i1][j1]);
                    dlina += 1;
                }
                if (help2[i1][j1] != null) {
                    operacii2.add(help2[i1][j1]);
                    dlina += 1;
                }


            }
        }
        operacii2.add("!");

        m = 2;

        for (int q = max - 2; q >= 0; q--) {
            if (m % 2 == 0) {
                SortSlova(help1, help2, q, sizelist);
                m += 1;
            } else {
                SortSlova(help2, help1, q, sizelist);
                m += 1;
            }
            operacii.add(lab);
            for (int i1 = 0; i1 < 34; i1++) {
                for (int j1 = 0; j1 < sizelist; j1++) {

                    if (help1[i1][j1] != null) {
                        operacii2.add(help1[i1][j1]);
                        //slovi.set(m, help1[i][j]);
                        dlina += 1;
                        //m+= 1;
                    }
                    if (help2[i1][j1] != null) {
                        operacii2.add(help2[i1][j1]);
                        //slovi.set(m, help1[i][j]);
                        dlina += 1;
                        //m+= 1;
                    }


                }
            }
            operacii2.add("!");
        }


        m = 0;
        System.out.println();
        System.out.println("Отсортированный массив: ");

        for (int i = 0; i < 34; i++) {
            for (int j = 0; j < sizelist; j++) {
                if (help1[i][j] != null) {
                    slovi.set(m, help1[i][j]);
                    System.out.print(slovi.get(m) + " ");
                    m += 1;

                }
                if (help2[i][j] != null) {
                    slovi.set(m, help2[i][j]);
                    System.out.print(slovi.get(m) + " ");
                    m += 1;
                }

            }
        }

        System.out.println();
        System.out.println();
        System.out.println("operacii");
        for (Label l : operacii) {
            if (l.getText() == "!") {
                System.out.println();
            } else {
                System.out.print(l.getText() + " " + l.getTranslateX() + " ");
            }

        }

        System.out.println();
        System.out.println();

        System.out.println("operacii2");
        for (String s : operacii2) {
            if (s == "!") {
                System.out.println();
            } else {
                System.out.print(s + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();


        count = 0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            int index = 0;
            int x = 0;
            boolean a = false;

            @Override
            public void handle(ActionEvent event) {

                try {
                    if (operacii.get(count).getText() != "!") {
                        Label label = operacii.get(count);

                        listlab.add(label);
                        root.getChildren().add(label);
                        root.getChildren().remove(listlab.get(0));
                        listlab.remove(0);
                        count += 1;

                    } else {
                        a = false;
                        index = 0;
                        count2 = 0;
                        for (Label l : listlab) {
                            //System.out.print("|" + l.getText() + "|" + operacii2.get(0));
                            System.out.println();
                            if (operacii2.get(0) == "!") {
                                a = true;
                                System.out.println("++++++++++");
                                break;
                            }
                            if (l.getText() == operacii2.get(0)) {
                                break;
                            }

                            index += 1;
                        }
                        if (a == false) {
                            root.getChildren().remove(listlab.get(index));
                            listlab.remove(index);
                            Label lab = new Label();
                            lab.setText(operacii2.get(count2));
                            lab.setStyle("-fx-font-size : 15");
                            lab.setTranslateX(60 + (max * (x % sizelist) * 10));
                            lab.setTranslateY(20);
                            listlab.add(lab);
                            root.getChildren().add(lab);
                            operacii2.remove(0);
                            x += 1;
                        } else {
                            x = 0;
                            operacii2.remove(0);

                            count += 1;
                            System.out.println("operacia" + operacii.get(count));
                            for (String s : operacii2) {
                                if (s == "!") {
                                    System.out.println();
                                    System.out.println(s);
                                } else {
                                    System.out.print(s + " ");
                                }
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {

                }

            }
        }));
        timeline.setCycleCount(dlina * 2);
        timeline.play();

    }

}