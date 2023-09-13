package com.example;

import java.util.List;

public class Lion {
//класс Lion не должен зависеть от класса Feline. Используй принцип иньекции зависимости
    private final boolean hasMane;
    private final Feline feline;


    public Lion(Feline feline, String sex) throws Exception {
        this.feline=feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    // Feline feline = new Feline();

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
