package animals;

import java.time.LocalDate;
import java.util.Objects;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getName(), dog.getName()) && Objects.equals(getBirthDate(), dog.getBirthDate());
    }
}
