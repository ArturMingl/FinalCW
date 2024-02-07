package animals;

import java.time.LocalDate;

public class Hamster extends Pet{
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "name-'" + getName() + '\'' +
                ", birthDate-" + getBirthDate() +
                ", commands-" + getCommands() + '}';
    }
}
