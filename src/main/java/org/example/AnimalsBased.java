package org.example;

public interface AnimalsBased {
    void addAnimal(Animal a);
    void removeAnimal(Animal a);
    void editAnimal(Animal a, Animal na);
    void addInVolier(Animal a, Volier v);
    void replaceVolier(Animal a, Volier v);
    void removeFromVolier(Animal a);
    void addVolier(Volier v);
    void removeVolier(Volier v);
    void printAnimals();
    void printVoliers();
}
