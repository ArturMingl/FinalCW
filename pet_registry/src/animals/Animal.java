package animals;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Класс животное. Животное имеет имя, дату рождения
 * и список изученных команд.
 */
public class Animal {
    private int id;
    private String name;
    private LocalDate birthDate;
    private ArrayList<String> commands = new ArrayList<>();


    public Animal(int id, String name, LocalDate birthDate) {
        setId(id);
        setName(name);
        setBirthDate(birthDate);
    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setId(int id) {this.id = id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void addCommand(String command) {
        if (this.commands.contains(command)) {
            return;
        } else {
            this.commands.add(command);
        }
    }


}
