package animals;

import java.time.LocalDate;
import java.util.Objects;

public class Pet extends Animal{

    public Pet(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public void addCommand(String command) {
        if(super.getCommands().contains(command)){
            System.out.println(getClass().getSimpleName() + " " + getName() + " уже знает команду " + command);
        }else {
            super.getCommands().add(command);
        }
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ID-'" + getId() + '\'' +
                ", Имя-'" + getName() + '\'' +
                ", Дата рождения-" + getBirthDate() +
                ", Изученные команды-" + getCommands() + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
