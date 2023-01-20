package eclipse.base.systems.command.commands;

import eclipse.base.systems.command.Cmd;
import eclipse.base.systems.command.Command;
import eclipse.base.utils.LogUtils;

@Cmd(name = "test", aliases = {"test", "t"}, description = "test", usage = "test")
public class TestCommands extends Command {

    public void execute(String[] args) {
        LogUtils.inGameLog("test");
    }

}