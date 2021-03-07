package kz.aitu.oop.practice.assignment5.controllers;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    private List<T> stoneList = new ArrayList<>(); //creating new array list called stoneList

    public void addValue(T value) {
        stoneList.add(value);
    } //to add values to generic

    public void printValues() {
        for (T value : stoneList) {
            stoneList.forEach(number -> System.out.println(value)); //lambda to output all values inside generic
        }
    }

}
