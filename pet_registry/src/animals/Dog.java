package animals;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name-'" + getName() + '\'' +
                ", birthDate-" + getBirthDate() +
                ", commands-" + getCommands() + '}';
    }
}
