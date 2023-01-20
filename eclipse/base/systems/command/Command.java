package eclipse.base.systems.command;

public class Command {

    Cmd cmd = this.getClass().getAnnotation(Cmd.class);

    private String name = cmd.name();
    private String[] aliases = cmd.aliases();
    private String description = cmd.description();
    private String usage = cmd.usage();

    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public void execute(String[] args) {

    }
}
