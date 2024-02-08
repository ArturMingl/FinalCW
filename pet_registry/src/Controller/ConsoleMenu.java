package Controller;

import Model.AnimalLists;
import Model.Counter;
import View.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class ConsoleMenu {
    private String[] options = {"1- Завести новое животное",
                                "2- Увидеть колличество животных",
                                "3- Увидеть список животных",
                                "4- Увидеть список команд, которое выполняет животное",
                                "5- Обучить животное новым командам",
                                "6- Выход"
                                };
    public void getOptions() {
        for (String option : options){
            System.out.println(option);
        }
    }
    public void choose(int option) {
        switch (option) {
            case 1 -> {
                View.whatThePet();
            }
            case 2 -> System.out.println("Всего животных - " + Counter.getCount());
            case 3 -> View.getPetsList();
            case 4 -> System.out.println("4 действие");
            case 5 -> System.out.println("5 действие");
            case 6 -> exit(0);
            default ->
                    System.out.printf("\033[31m Такого действия нет в меню. Введите целое число от 1 до %d \033[0m \n", options.length);
        }
    }
}
