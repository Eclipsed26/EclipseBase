package eclipse.base.systems.command;

import eclipse.base.systems.command.commands.TestCommands;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager {
    ArrayList<Command> commands = new ArrayList<Command>();

    public void init() {
        registerCommand(
            new TestCommands()
        );
    }

    public void registerCommand(Command... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}
