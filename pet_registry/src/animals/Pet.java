package animals;

import java.time.LocalDate;

public class Pet extends Animal{

    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public void addCommand(String command) {
        if(super.getCommands().contains(command)){
            System.out.println(getName() + " уже знает команду " + command);
        }else {
            super.getCommands().add(command);
        }
    }
    @Override
    public String toString() {
        return "Pet{" +
                "name-'" + getName() + '\'' +
                ", birthDate-" + getBirthDate() +
                ", commands-" + getCommands() + '}';
    }
}
