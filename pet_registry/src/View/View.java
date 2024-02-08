package View;

import Controller.ConsoleMenu;
import Model.AnimalLists;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    ConsoleMenu menu = new ConsoleMenu();
    static AnimalLists animals = new AnimalLists();

    public void hello() {
        System.out.println("Добро пожаловать в реестр животных");
    }

    public void getMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (true) {
            menu.getOptions();
            System.out.println("Выберите действие:");
            option = scanner.nextInt();
            menu.choose(option);
        }
    }

    public void whatThePet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Кошка\n" +
                "2-Собака\n" +
                "3-Хомяк\n" +
                "Введите тип животного:");
        int type = scanner.nextInt();
        try {
            if (type >= 1 && type <= 3) {
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
            } else {
                System.out.println("\033[31m Не верно выбран тип животного, попробуйте ещё раз \033[0m");
            }
        } catch (InputMismatchException | DateTimeException e) {
            System.out.println("\033[31m Вы ввели не валидные данные, попробуйте ещё раз \033[0m");
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void getPetsList() {
        for (int i = 0; i < animals.getPets().size(); i++) {
            System.out.println(animals.getPets().get(i));
        }
    }

    public void whatPetCan(){
        getPetsList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID животного");
        int id = scanner.nextInt();
        System.out.println(animals.getPets().get(id).getCommands());
    }

    public void learnCommand(){
        getPetsList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID животного");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите команду");
        String command = scanner.nextLine();
        animals.getPets().get(id).addCommand(command);
    }
}
