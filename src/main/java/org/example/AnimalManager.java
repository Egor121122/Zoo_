package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager implements AnimalsBased{
    private ArrayList<Animal> animalsDB = new ArrayList<>();
    private ArrayList<Volier> voliersDB = new ArrayList<>();


    @Override
    public void addAnimal(Animal a) {
        animalsDB.add(a);
        System.out.println(animalsDB.size());
    }

    @Override
    public void removeAnimal(Animal a) {
        int i = 0;
        while (i != animalsDB.size()){
            if(animalsDB.get(i) == a){
                System.out.println("Animal " + animalsDB.get(i).getTypeOfAnimal() + ", with name \"" + animalsDB.get(i).getName() + "\" successfully removed");
                animalsDB.remove(i);
                return;
            }
            //++i;
        }
        System.out.println("Animal not found");
    }

    @Override
    public void editAnimal(Animal a, Animal na) {
        int i = 0;
        while (i != animalsDB.size()){
            if(animalsDB.get(i) == a){
                System.out.println("Animal " + animalsDB.get(i).getTypeOfAnimal() + ", with name \"" + animalsDB.get(i).getName() + "\" successfully edited");
                animalsDB.set(i, na);
                return;
            }
            ++i;
        }
        System.out.println("Animal not found");
    }

    @Override
    public void addInVolier(Animal a, Volier v) {
        int i = 0;
        int j = 0;
        while (j != voliersDB.size()){                                  //цикл на нахождения вольера
            if(voliersDB.get(j) == v){                                  //если вольер найден:
                while (i != animalsDB.size()){                          //цикл на нахождения животного
                    if(animalsDB.get(i) == a){                          //если животное найдено:
                        if(animalsDB.get(i).getVolier() == null) {      //проверка на нахождения животного в вольере
                            if(v.getPlaces() > v.getCountOfAnimals()){
                                animalsDB.get(i).setVolier(v);
                                v.getAnimalsInVolier().add(a);
                                v.setCountOfAnimals(v.getCountOfAnimals() + 1);
                                System.out.println("Animal " + animalsDB.get(i).getTypeOfAnimal() + ", with name \"" + animalsDB.get(i).getName()
                                        + "\" successfully added in " + v.getTypeOfVolier() + " volier, with name \"" + v.getName() + "\"");
                            } else {
                                System.out.println("volier is full (" + v.getCountOfAnimals() + "/" + v.getCountOfAnimals() + ")");
                            }
                            return;
                        } else {
                            System.out.println("Animal already have volier (type: " + animalsDB.get(i).getVolier().getTypeOfVolier()
                                    + ", name: \"" + animalsDB.get(i).getVolier().getName() + "\")");
                        }
                        return;
                    }
                    ++i;
                }
                System.out.println("Animal not found");
                return;
            }
            j++;
        }
        System.out.println("Volier not found");
    }

    @Override
    public void replaceVolier(Animal a, Volier v) {
        int i = 0;
        int j = 0;
        while (j != animalsDB.size()){                                  //цикл на нахождения вольера
            if(voliersDB.get(j) == v){                                  //если вольер найден:
                while (i != animalsDB.size()){                          //цикл на нахождения животного
                    if(animalsDB.get(i) == a){                          //если животное найдено:
                        if(animalsDB.get(i).getVolier() != null) {      //проверка на нахождения животного в вольере
                            animalsDB.get(i).setVolier(v);
                            System.out.println("Animal " + animalsDB.get(i).getTypeOfAnimal() + ", with name \"" + animalsDB.get(i).getName()
                                    + "\" successfully added in " + v.getTypeOfVolier() + " volier, with name \"" + v.getName() + "\"");
                        } else {
                            System.out.println("Animal not have volier yet");
                        }
                        return;
                    }
                    ++i;
                }
                System.out.println("Animal not found");
                return;
            }
            j++;
        }
        System.out.println("Volier not found");
    }

    @Override
    public void removeFromVolier(Animal a) {
        if(a.getVolier() != null) {
            int i = 0;
            while (i != animalsDB.size()) {
                if (animalsDB.get(i) == a) {
                    System.out.println("Animal " + a.getTypeOfAnimal() + ", with name \"" + a.getName() + "\" removed from "
                            + a.getVolier().getTypeOfVolier() + " volier, with name \"" + a.getVolier().getName() + "\"");
                    a.getVolier().setCountOfAnimals(a.getVolier().getCountOfAnimals() - 1);
                    a.setVolier(null);
                    return;
                }
                ++i;
            }
            System.out.println("Animal not found");
        } else {
            System.out.println("Animal not have volier yet");
        }
    }

    @Override
    public void addVolier(Volier v) {
        voliersDB.add(v);
    }

    @Override
    public void removeVolier(Volier v) {
        int i = 0;
        while (i != voliersDB.size()){
            if(voliersDB.get(i) == v){
                System.out.println("Volier " + v.getTypeOfVolier() + ", with name \"" + v.getName() + "\" successfully removed");
                removeLink(voliersDB, i);
                voliersDB.remove(i);
                return;
            }
            ++i;
        }
        System.out.println("volier not found");
    }

    @Override
    public void printAnimals() {
        System.out.println();
        int i = 0;
        while (i != animalsDB.size()){
            System.out.print("Type: " + animalsDB.get(i).getTypeOfAnimal()+";    ");
            System.out.print("Name: " + animalsDB.get(i).getName()+";    ");
            System.out.print("Weight: " + animalsDB.get(i).getWeight()+";    ");
            System.out.print("Age: " + animalsDB.get(i).getAge()+";    ");
            if(animalsDB.get(i).getVolier() != null)
                System.out.print("Volier: \"" + animalsDB.get(i).getVolier().getName()+"\", (" + animalsDB.get(i).getVolier().getTypeOfVolier() + ")");
            else
                System.out.print("Animal not have volier");
            System.out.println();
            ++i;
        }
    }

    @Override
    public void printVoliers() {
        System.out.println();
        System.out.println();
        int i = 0;
        while (i != voliersDB.size()){
            System.out.print("Type: " + voliersDB.get(i).getTypeOfVolier()+";    ");
            System.out.print("Name: " + voliersDB.get(i).getName()+";    ");
            if(voliersDB.get(i).getCountOfAnimals() != 0){
                System.out.print("Animals: ");
                int j = 0;
                while (j != voliersDB.get(i).getAnimalsInVolier().size()){
                    System.out.print(voliersDB.get(i).getAnimalsInVolier().get(j).getName() + " ("
                            + voliersDB.get(i).getAnimalsInVolier().get(j).getTypeOfAnimal() + "); ");
                    ++j;
                }
            }
            else {System.out.print("volier not have animals");}
            System.out.println();
            ++i;
        }
    }

    private void removeLink(ArrayList<Volier> voliersDB, int i){
        int j = 0;
        while (j != voliersDB.get(i).getAnimalsInVolier().size()){
            voliersDB.get(i).getAnimalsInVolier().get(j).setVolier(null);
            j++;
        }
    }

    public String getDataToSave(){
        final String sp = "|space|";
        final String mSp = "|mSpace|";
        String a = "";
        String v = "";
        for (int i = 0; i < animalsDB.size(); i++) {
            a += animalsDB.get(i).getTypeOfAnimal() + sp;
            a += animalsDB.get(i).getName() + sp;
            a += animalsDB.get(i).getWeight() + sp;
            a += animalsDB.get(i).getAge() + sp;
        }
        for (int i = 0; i < voliersDB.size(); i++) {
            v += voliersDB.get(i).getTypeOfVolier() + sp;
            for (int j = 0; j < voliersDB.get(i).getAnimalsInVolier().size(); j++) {
                v += voliersDB.get(i).getAnimalsInVolier().get(j).getTypeOfAnimal() + mSp;
                v += voliersDB.get(i).getAnimalsInVolier().get(j).getName() + mSp;
                v += voliersDB.get(i).getAnimalsInVolier().get(j).getWeight() + mSp;
                v += voliersDB.get(i).getAnimalsInVolier().get(j).getAge() + mSp;
            }
        }
        return a + v;
    }
}
