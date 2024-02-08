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
            switch (type) {
                case 1 -> {
                    Cat cat = new Cat(counter.getCount(),name, birthDate);
                    addPet(cat);
                }
                case 2 -> {
                    Dog dog = new Dog(counter.getCount(), name, birthDate);
                    addPet(dog);
                }
                case 3 -> {
                    Hamster hamster = new Hamster(counter.getCount(), name, birthDate);
                    addPet(hamster);
                }
            }
            counter.add();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void getPetCommands(Pet p){
        p.getCommands();
    }
}
