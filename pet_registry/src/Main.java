import animals.Cat;
import animals.Pet;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Mary", LocalDate.of(2021, 8, 15));
        cat1.addCommand("дай лапу");
        cat1.addCommand("дай другую лапу");
        cat1.addCommand("дай лапу");
        System.out.println(cat1);


    }
}