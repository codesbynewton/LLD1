package command.pattern.commands;

public class LightOnOffCommand implements Command{

    @Override
    public boolean matches(String command) {
        String tokens[] = command.split(" ");

        return tokens[0].equalsIgnoreCase("light");
    }

    @Override
    public void execute(String command) {
        String tokens[] = command.split(" ");

        if(tokens[1].equalsIgnoreCase("on")) System.out.println("The light is turned on");
        else if(tokens[1].equalsIgnoreCase("off")) System.out.println("the light is turned off");

    }
}
