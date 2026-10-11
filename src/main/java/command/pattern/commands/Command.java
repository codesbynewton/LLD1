package command.pattern.commands;

public interface Command {

    boolean matches(String command);
    void execute(String command);
}
