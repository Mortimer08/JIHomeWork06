package com.example;

import java.util.ArrayList;

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
            System.out.printf("%d. %s\n", index+1, this.content.get(index));
        }
    }
}
