package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<String> content;
    String menuName;
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    Menu(String menuName) {
        this.menuName = menuName;
        content = new ArrayList<>();
    }

    void addPoint(String menuPoint) {
        this.content.add(menuPoint);
    }

    void show() {
        System.out.println();
        for (int index = 0; index < this.content.size(); index++) {
            System.out.printf("\t%d. %s\n", index + 1, this.content.get(index));
        }
        System.out.println();
    }

    public void clear() {
        this.content.clear();
    }

    ArrayList<String> readChoice() {
        ArrayList<String> answers = new ArrayList<>();
        String answer = "";
        Boolean check = false;
        Boolean success = false;
        while (!success) {
            System.out.print("Выберите пункт меню: ");
            check = sc.hasNextInt();
            if (check) {
                answer = sc.next();

                if (Integer.parseInt(answer) > 0 && Integer.parseInt(answer) <= this.content.size()) {
                    success = true;
                    answers.add(answer);

                    answers.add(this.content.get(Integer.parseInt(answer) - 1));
                    if(this.menuName.equals("mainMenu")&&this.content.get(Integer.parseInt(answer) - 1).equals("Выход")){
                        sc.close();
                    }
                } else {
                    System.out.println("Недопустимая команда");
                    this.show();
                }
            } else {
                System.out.println("Недопустимая команда");
                this.show();
            }
        }
        return answers;
    }
}
