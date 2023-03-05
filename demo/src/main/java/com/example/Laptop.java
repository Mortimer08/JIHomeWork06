package com.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Laptop {
    HashMap<String, String> parameters;
    static LinkedList<HashMap<String, String>> parametersNames = new LinkedList<HashMap<String, String>>();
    static {
        HashMap<String, String> parameter1 = new HashMap<>();
        parameter1.put("short name", "producer");
        parameter1.put("description", "Made by");
        parameter1.put("mesure", "none");
        parametersNames.add(parameter1);
        HashMap<String, String> parameter2 = new HashMap<>();
        parameter2.put("short name", "ram");
        parameter2.put("description", "RAM");
        parameter2.put("mesure", "Gb");
        parametersNames.add(parameter2);
        HashMap<String, String> parameter3 = new HashMap<>();
        parameter3.put("short name", "hdd");
        parameter3.put("description", "Hard disk size");
        parameter3.put("mesure", "Gb");
        parametersNames.add(parameter3);
        HashMap<String, String> parameter4 = new HashMap<>();
        parameter4.put("short name", "os");
        parameter4.put("description", "Operation system");
        parameter4.put("mesure", "none");
        parametersNames.add(parameter4);
        HashMap<String, String> parameter5 = new HashMap<>();
        parameter5.put("short name", "screenSize");
        parameter5.put("description", "Screen Size");
        parameter5.put("mesure", "Inches");
        parametersNames.add(parameter5);
        HashMap<String, String> parameter6 = new HashMap<>();
        parameter6.put("short name", "color");
        parameter6.put("description", "Color");
        parameter6.put("mesure", "none");
        parametersNames.add(parameter6);

        // parametersNames.put("parameter1", parameter1);
        // parametersNames.add("producer");
        // parametersNames.add("ram");
        // parametersNames.add("hdd");
        // parametersNames.add("os");
        // parametersNames.add("screenSize");
        // parametersNames.add("color");
    }

    Laptop() {
        parameters = new HashMap<String, String>();
    }

    Laptop(Map<String, String> parameters) {
        parameters = new HashMap<String, String>();
        for (Map.Entry<String, String> parametersSet : parameters.entrySet()) {

            for (HashMap<String, String> laptopParameters : Laptop.parametersNames) {
                if (laptopParameters.values().contains(parametersSet.getKey())) {
                    this.parameters.put(parametersSet.getKey(), parametersSet.getValue());
                }
            }

        }
    }

    // public static HashSet<String> getParameterList() {
    // return Laptop.parametersNames;

    // }

    Boolean isFiltered(Map<String, String> filterMap) {
        Boolean filterResult = true;
        for (Map.Entry<String, String> filter : filterMap.entrySet()) {
            for (HashMap<String, String> laptopParameters : Laptop.parametersNames) {
                if (laptopParameters.values().contains(filter.getKey())) {
                    try {
                        Integer parameterFilterValue = Integer.parseInt(filter.getValue());
                        Integer parameterLaptopValue = Integer.parseInt(this.getParameter(filter.getKey()));
                        if (parameterFilterValue <= parameterLaptopValue) {
                            filterResult &= true;
                        } else {
                            filterResult &= false;
                        }

                    } catch (NumberFormatException e) {
                        if (filter.getValue().equals(this.getParameter(filter.getKey()))) {
                            filterResult &= true;
                        } else {
                            filterResult &= false;
                        }

                    }
                }
            }

        }
        return filterResult;
    }

    void setParemeter(String parameterName, String parameterValue) {
        for (HashMap<String, String> laptopParameters : Laptop.parametersNames) {
            if (laptopParameters.values().contains(parameterName)) {
                this.parameters.put(parameterName, parameterValue);
            }
        }

    }

    String getParameter(String parameterName) {
        String parameterValue;
        if (this.parameters.keySet().contains(parameterName)) {
            parameterValue = parameters.get(parameterName);
        } else {
            parameterValue = "empty";
        }
        return parameterValue;
    }

    @Override
    public String toString() {
        String laptopInfo = "";
        for (HashMap<String, String> laptopParameters : Laptop.parametersNames) {

            laptopInfo += laptopParameters.get("description");
            laptopInfo += ": ";
            laptopInfo += this.getParameter(laptopParameters.get("short name"));
            if (!laptopParameters.get("mesure").equals("none")) {

                laptopInfo += " "+laptopParameters.get("mesure");
            }
            laptopInfo += " ";

        }

        return laptopInfo;
    }

}
