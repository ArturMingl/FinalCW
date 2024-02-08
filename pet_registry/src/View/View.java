package View;

import Controller.ConsoleMenu;
import Model.AnimalLists;

import java.time.LocalDate;
import java.util.Scanner;

public class View{

    ConsoleMenu menu = new ConsoleMenu();
    static AnimalLists animals = new AnimalLists();

    public void hello(){
        System.out.println("Добро пожаловать в реестр животных");
    }
    public void getMenu(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (true){
            menu.getOptions();
            System.out.println("Выберите действие:");
            option = scanner.nextInt();
            menu.choose(option);
        }
    }

    public static void whatThePet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println( "1-Кошка\n" +
                            "2-Собака\n" +
                            "3-Хомяк\n" +
                            "Введите тип животного:");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int year = scanner.nextInt();
        System.out.println("Введите номер месяца рождения:");
        int month = scanner.nextInt();
        System.out.println("Введите день рождения:");
        int day = scanner.nextInt();
        animals.createPet(type, name, LocalDate.of(year, month, day));
    }

    public static void getPetsList(){
        System.out.println(animals.getPets());
    }
}
