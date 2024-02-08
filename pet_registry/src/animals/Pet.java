package animals;

import java.time.LocalDate;

public class Pet extends Animal{

    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
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
                "{name-'" + getName() + '\'' +
                ", birthDate-" + getBirthDate() +
                ", commands-" + getCommands() + '}';
    }
}
