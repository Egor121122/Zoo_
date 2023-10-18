package org.example;

import java.util.ArrayList;

public class Volier {
    private ArrayList<Animal> animalsInVolier = new ArrayList<>();

    public Volier(Voliers typeOfVolier, String name) {
        this.typeOfVolier = typeOfVolier;
        this.name = name;
        switch (typeOfVolier){
            case SMALL -> this.places = 2;
            case MIDDLE -> this.places = 5;
            case LARGE -> this.places = 10;
        }
    }

    private Voliers typeOfVolier;
    private String name;
    private int places;
    private int countOfAnimals;
    private boolean full;

    public Voliers getTypeOfVolier() {return typeOfVolier;}
    public void setTypeOfVolier(Voliers typeOfVolier) {this.typeOfVolier = typeOfVolier;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPlaces() {return places;}
    public int getCountOfAnimals() {return countOfAnimals;}
    public void setCountOfAnimals(int countOfAnimals) {this.countOfAnimals = countOfAnimals;}
    public boolean isFull() {return places <= countOfAnimals;}

    public ArrayList<Animal> getAnimalsInVolier() {return animalsInVolier;}
    public void setAnimalsInVolier(ArrayList<Animal> animalsInVolier) {this.animalsInVolier = animalsInVolier;}
}
