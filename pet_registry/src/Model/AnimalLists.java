package Model;

import animals.Cat;
import animals.Dog;
import animals.Hamster;
import animals.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalLists {
    private ArrayList<Pet> pets = new ArrayList<>();

    private void addPet(Pet p) {
        pets.add(p);
    }

    public void createPet(int type, String name, LocalDate birthDate) {
        try (Counter counter = new Counter()) {
            counter.add();
            switch (type) {
                case 1 -> {
                    Cat cat = new Cat(name, birthDate);
                    addPet(cat);
                }
                case 2 -> {
                    Dog dog = new Dog(name, birthDate);
                    addPet(dog);
                }
                case 3 -> {
                    Hamster hamster = new Hamster(name, birthDate);
                    addPet(hamster);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }
}
