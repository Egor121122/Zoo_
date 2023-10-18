package org.example;

public class Animal {

    public Animal(Animals typeOfAnimal, String name, int weight, int age) {
        this.typeOfAnimal = typeOfAnimal;
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    private Animals typeOfAnimal;
    private String name;
    private int weight;
    private int age;
    private Volier volier;

    public Animals getTypeOfAnimal() {return typeOfAnimal;}
    public String getName() {return name;}
    public int getWeight() {return weight;}
    public int getAge() {return age;}
    public Volier getVolier() {return volier;}

    public void setTypeOfAnimal(Animals typeOfAnimal) {this.typeOfAnimal = typeOfAnimal;}
    public void setName(String name) {this.name = name;}
    public void setWeight(int weight) {this.weight = weight;}
    public void setAge(int age) {this.age = age;}
    public void setVolier(Volier volier) {this.volier = volier;}
}
