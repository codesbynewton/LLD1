package command.pattern.commands;

public class FanOnOffCommand implements Command{
    @Override
    public boolean matches(String command) {
        String tokens[] = command.split(" ");

        return tokens[0].equalsIgnoreCase("fan");
    }

    @Override
    public void execute(String command) {
        String tokens[] = command.split(" ");

    }
}
