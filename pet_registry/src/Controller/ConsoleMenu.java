package Controller;

import Model.AnimalLists;
import Model.Counter;
import View.View;

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
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void choose(int option) {
        Counter counter = new Counter();
        View view = new View();
        switch (option) {
            case 1 -> {
                view.whatThePet();
            }
            case 2 -> System.out.println("Всего животных - " + counter.getCount());
            case 3 -> view.getPetsList();
            case 4 -> view.whatPetCan();
            case 5 -> view.learnCommand();
            case 6 -> exit(0);
            default ->
                    System.out.printf("\033[31m Такого действия нет в меню. Введите целое число от 1 до %d \033[0m \n", options.length);
        }
    }
}
