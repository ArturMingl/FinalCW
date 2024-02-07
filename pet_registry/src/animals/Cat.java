package animals;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name-'" + getName() + '\'' +
                ", birthDate-" + getBirthDate() +
                ", commands-" + getCommands() + '}';
    }
}
