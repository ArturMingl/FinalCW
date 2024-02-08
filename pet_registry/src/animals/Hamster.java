package animals;

import java.time.LocalDate;
import java.util.Objects;

public class Hamster extends Pet{
    public Hamster(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hamster hamster = (Hamster) o;
        return Objects.equals(getName(), hamster.getName()) && Objects.equals(getBirthDate(), hamster.getBirthDate());
    }
}
