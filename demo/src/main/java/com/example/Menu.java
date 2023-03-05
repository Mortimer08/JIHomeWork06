package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<String> content;

    Menu() {
        content = new ArrayList<>();
    }

    void addPoint(String menuPoint) {

        this.content.add(menuPoint);
    }

    void show() {
        for (int index = 0; index < this.content.size(); index++) {
            System.out.printf("%d. %s\n", index + 1, this.content.get(index));
        }
    }

    String readChoice() {
        String answer = "";
        Integer chosedPoint;
        Scanner sc = new Scanner(System.in);
        Boolean success = false;
        while (!success) {
            System.out.println("Выберите пункт меню: ");
            answer = sc.nextLine();

            try {
                chosedPoint = Integer.parseInt(answer);
                if (chosedPoint > 0 && chosedPoint <= this.content.size()) {
                    success = true;
                }
                System.out.println("Недопустимая команда");
                this.show();
            } catch (Exception e) {
                System.out.println("Недопустимая команда");
                this.show();
            }
        }

        sc.close();
        return answer;

    }
}
