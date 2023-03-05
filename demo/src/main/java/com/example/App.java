package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы.
 * Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии)
 * фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
 * хранить в Map.
 * Например: “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев
 * - сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки из первоначального множества и вывести проходящие по
 * условиям.
 */
public final class App {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();
        fillLaptopsList(laptops);

        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("ram", "8");
        filterMap.put("hdd", "512");
        filterMap.put("producer", "HP");
        // filterMap.put("producer", "Dell");
        showLaptopsList(filterLaptops(laptops, filterMap));
        Menu mainMenu = new Menu();
        fillMainMenu(mainMenu);
        mainMenu.show();

        // System.out.println(mainMenu.readChoice());
        Menu filterMenu = new Menu();
        fillFilterMenu(filterMenu);
        filterMenu.show();
        Menu filterParameterMenu = new Menu();
        String parameterName = "ram";
        fillFilterParameterMenu(filterParameterMenu, laptops,parameterName);

        filterParameterMenu.show();
    }

    public static ArrayList<Laptop> filterLaptops(ArrayList<Laptop> laptops, Map<String, String> filterMap) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptopToCheck : laptops) {
            if (laptopToCheck.isFiltered(filterMap)) {
                filteredLaptops.add(laptopToCheck);
            }
        }
        return filteredLaptops;
    }

    public static void showLaptopsList(ArrayList<Laptop> laptopsList) {
        for (Laptop laptop : laptopsList) {
            System.out.println(laptop.toString());
        }

    }

    public static void fillLaptopsList(ArrayList<Laptop> laptops) {

        Laptop laptop1 = new Laptop();
        laptop1.setParemeter("producer", "Apple");
        laptop1.setParemeter("ram", "24");
        laptop1.setParemeter("hdd", "512");
        laptop1.setParemeter("screenSize", "13");
        laptop1.setParemeter("os", "macOS");
        laptop1.setParemeter("color", "starlight");
        laptops.add(laptop1);
        Laptop laptop2 = new Laptop();
        laptop2.setParemeter("producer", "Dell");
        laptop2.setParemeter("ram", "8");
        laptop2.setParemeter("hdd", "512");
        laptop2.setParemeter("screenSize", "16");
        laptop2.setParemeter("os", "Windows 10");
        laptop2.setParemeter("color", "silver");
        laptops.add(laptop2);
        Laptop laptop3 = new Laptop();
        laptop3.setParemeter("producer", "MSI");
        laptop3.setParemeter("ram", "32");
        laptop3.setParemeter("hdd", "512");
        laptop3.setParemeter("screenSize", "16");
        laptop3.setParemeter("os", "Windows 11");
        laptop3.setParemeter("color", "red");
        laptops.add(laptop3);
        Laptop laptop4 = new Laptop();
        laptop4.setParemeter("producer", "Sony");
        laptop4.setParemeter("ram", "16");
        laptop4.setParemeter("hdd", "1000");
        laptop4.setParemeter("screenSize", "14");
        laptop4.setParemeter("os", "Windows 11");
        laptop4.setParemeter("color", "white");
        laptops.add(laptop4);
        Laptop laptop5 = new Laptop();
        laptop5.setParemeter("producer", "Apple");
        laptop5.setParemeter("ram", "8");
        laptop5.setParemeter("hdd", "256");
        laptop5.setParemeter("screenSize", "13");
        laptop5.setParemeter("os", "macOS");
        laptop5.setParemeter("color", "white");
        laptops.add(laptop5);
        Laptop laptop6 = new Laptop();
        laptop6.setParemeter("producer", "HP");
        laptop6.setParemeter("ram", "8");
        laptop6.setParemeter("hdd", "256");
        laptop6.setParemeter("screenSize", "15");
        laptop6.setParemeter("os", "DOS");
        laptop6.setParemeter("color", "white");
        laptops.add(laptop6);
        Laptop laptop7 = new Laptop();
        laptop7.setParemeter("producer", "Lenovo");
        laptop7.setParemeter("ram", "32");
        laptop7.setParemeter("hdd", "1000");
        laptop7.setParemeter("screenSize", "15");
        laptop7.setParemeter("os", "Linux");
        laptop7.setParemeter("color", "blue");
        laptops.add(laptop7);
        Laptop laptop8 = new Laptop();
        laptop8.setParemeter("producer", "Lenovo");
        laptop8.setParemeter("ram", "32");
        laptop8.setParemeter("hdd", "512");
        laptop8.setParemeter("screenSize", "14");
        laptop8.setParemeter("os", "Windows 10");
        laptop8.setParemeter("color", "blue");
        laptops.add(laptop8);
        Laptop laptop9 = new Laptop();
        laptop9.setParemeter("producer", "Acer");
        laptop9.setParemeter("ram", "8");
        laptop9.setParemeter("hdd", "512");
        laptop9.setParemeter("screenSize", "16");
        laptop9.setParemeter("os", "Windows 11");
        laptop9.setParemeter("color", "silver");
        laptops.add(laptop9);
        Laptop laptop10 = new Laptop();
        laptop10.setParemeter("producer", "Horizont");
        laptop10.setParemeter("ram", "8");
        laptop10.setParemeter("hdd", "256");
        laptop10.setParemeter("screenSize", "14");
        laptop10.setParemeter("os", "Windows Home");
        laptop10.setParemeter("color", "black");
        laptops.add(laptop10);
    }

    static void fillMainMenu(Menu mainMenu) {
        mainMenu.addPoint("Настроить фильтр");
        mainMenu.addPoint("Подобрать ноутбуки по фильтру");
        mainMenu.addPoint("Показать фильтр");
        mainMenu.addPoint("Очистить фильтр");
        mainMenu.addPoint("Выход");
    }

    static void fillFilterMenu(Menu filterMenu) {
        for (HashMap<String, String> parameterName : Laptop.parametersNames) {
            String poinString;
            poinString = String.format("Выбрать параметр \"%s\"", parameterName.get("description"));
            filterMenu.addPoint(poinString);
        }
        filterMenu.addPoint("Выход");
    }

    static void fillFilterParameterMenu(Menu filterParameterMenu, ArrayList<Laptop> laptops,String parameterName) {
        HashSet<String> currentParametersValues = new HashSet<>();
        for (Laptop laptop : laptops) {

            if (laptop.parameters.containsKey(parameterName)) {
                currentParametersValues.add((laptop.parameters.get(parameterName)));
            }
        }
        for (String parameter : currentParametersValues) {
            filterParameterMenu.addPoint(parameter);
        }
        filterParameterMenu.addPoint("Выход");
    }
}
