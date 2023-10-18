package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Volier volier = new Volier(Voliers.MIDDLE, "volier");
        ArrayList<Animal> mainDB = new ArrayList<>();

        Animal tiger1 = new Animal(Animals.DOG, "tiger1", 20, 10);
        Animal tiger2 = new Animal(Animals.TIGER, "tiger2", 20, 10);
        Animal tiger3 = new Animal(Animals.TIGER, "tiger31", 20, 10);
        Animal tiger33 = new Animal(Animals.TIGER, "tiger32", 20, 10);
        Animal tiger43 = new Animal(Animals.TIGER, "tiger33", 20, 10);
        Animal tiger12 = new Animal(Animals.DOG, "tiger12", 20, 10);
        Animal tiger22 = new Animal(Animals.TIGER, "tiger22", 20, 10);
        Animal tiger32 = new Animal(Animals.TIGER, "tiger312", 20, 10);
        Animal tiger332 = new Animal(Animals.TIGER, "tiger322", 20, 10);
        Animal tiger432 = new Animal(Animals.TIGER, "tiger332", 20, 10);

        AnimalManager animalManager = new AnimalManager();
        Volier mainVolier = new Volier(Voliers.SMALL, "main");
        Volier mainVolier2 = new Volier(Voliers.SMALL, "main1");
        Volier mainVolier3 = new Volier(Voliers.SMALL, "main2");
        Volier mainVolier22 = new Volier(Voliers.SMALL, "main");
        Volier mainVolier222 = new Volier(Voliers.SMALL, "main1");
        Volier mainVolier32 = new Volier(Voliers.SMALL, "main2");

        animalManager.addAnimal(tiger1);
        animalManager.addAnimal(tiger2);
        animalManager.addAnimal(tiger3);
        animalManager.addAnimal(tiger33);
        animalManager.addAnimal(tiger43);
        animalManager.addAnimal(tiger12);
        animalManager.addAnimal(tiger22);
        animalManager.addAnimal(tiger32);
        animalManager.addAnimal(tiger332);
        animalManager.addAnimal(tiger432);

        animalManager.addVolier(mainVolier);
        animalManager.addVolier(mainVolier2);
        animalManager.addVolier(mainVolier3);
        animalManager.addVolier(mainVolier22);
        animalManager.addVolier(mainVolier222);
        animalManager.addVolier(mainVolier32);

        animalManager.addInVolier(tiger1, mainVolier);
        animalManager.addInVolier(tiger2, mainVolier);

        //animalManager.addInVolier(tiger3, mainVolier2);
        //animalManager.addInVolier(tiger33, mainVolier2);

        animalManager.addInVolier(tiger43, mainVolier3);

        //animalManager.addInVolier(tiger12, mainVolier22);
        //animalManager.addInVolier(tiger22, mainVolier22);

        animalManager.addInVolier(tiger32, mainVolier32);
        animalManager.addInVolier(tiger332, mainVolier32);

        animalManager.addInVolier(tiger432, mainVolier222);

        animalManager.printAnimals();
        System.out.println();
    }
}