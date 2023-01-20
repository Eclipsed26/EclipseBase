package eclipse.base;

import best.azura.eventbus.core.EventBus;
import best.azura.eventbus.handler.EventHandler;
import best.azura.eventbus.handler.Listener;
import eclipse.base.systems.command.Command;
import eclipse.base.systems.command.CommandManager;
import eclipse.base.systems.event.ChatEvent;
import eclipse.base.systems.event.KeyEvent;
import eclipse.base.systems.module.Module;
import eclipse.base.systems.module.ModuleManager;
import eclipse.base.systems.module.modules.render.Overlay;
import eclipse.base.utils.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.util.Arrays;

/**
 * This class contains all the information and methods that are needed to run the client.
 *
 * @author Eclipsed
 * @version 1.0.3
 */
public class ClientBase {
    private static ClientBase instance;

    public final Logger logger = LogManager.getLogger(this);

    public final ClientInfo clientInfo;
    public final String fullName;

    private EventBus eventBus; public EventBus getEventBus() { return eventBus; }
    private ModuleManager moduleManager; public ModuleManager getModuleManager() { return moduleManager; }
    private CommandManager commandManager; public CommandManager getCommandManager() { return commandManager; }

    public ClientBase() {
        instance = this;

        clientInfo = new ClientInfo("BaseClient", "Me", 1.0);
        fullName = clientInfo.getName() + " " + clientInfo.getVersion();

        eventBus = new EventBus(); eventBus.register(this);
        moduleManager = new ModuleManager(); moduleManager.init();
        commandManager = new CommandManager(); commandManager.init();
    }

    public static ClientBase getInstance() {
        return instance;
    }

    public void init() {
        Display.setTitle(fullName);
        moduleManager.getModule(Overlay.class).setEnabled(true);
    }

    @EventHandler
    public Listener<KeyEvent> onKey = event -> {
        try {
            for(Module module : moduleManager.getModules()){
                if (module.getKey() == event.getKey()) {
                    module.toggle();
                }
            }
        } catch (Exception e) {
           logger.error("Error in keyListener: ", e);
        }
    };

    @EventHandler
    public Listener<ChatEvent> onChat = event -> {
        boolean foundCommand = false;
        String prefix = ".";

        String message = event.getMessage();

        if (!message.startsWith(prefix)) {
            return;
        }

        event.setCancelled(true);

        message = message.substring(prefix.length());

        if (message.isEmpty()) LogUtils.inGameLog("Please enter a command!");

        if (message.split(" ").length > 0) {
            String commandName = message.split(" ")[0];
            for (Command c : getCommandManager().getCommands()) {
                if (Arrays.toString(c.getAliases()).equalsIgnoreCase(commandName) || c.getName().equalsIgnoreCase(commandName)) {
                    c.execute(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length));
                    foundCommand = true;
                    break;
                }
            }
        }

        if (!foundCommand && !message.isEmpty()) {
            LogUtils.inGameLog("Command not found.");
        }

    };
}