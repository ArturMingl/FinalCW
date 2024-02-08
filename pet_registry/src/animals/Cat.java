package animals;

import java.time.LocalDate;
import java.util.Objects;

public class Cat extends Pet{
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getName(), cat.getName()) && Objects.equals(getBirthDate(), cat.getBirthDate());
    }
}
