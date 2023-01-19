package eclipse.base;

import eclipse.base.systems.event.KeyEvent;
import eclipse.base.systems.module.ModuleManager;
import eclipse.base.systems.module.modules.render.Overlay;
import best.azura.eventbus.core.EventBus;
import best.azura.eventbus.handler.EventHandler;
import best.azura.eventbus.handler.Listener;
import org.lwjgl.opengl.Display;

/**
 *
 * Before you start, you need to know that this is a client base, it is a BASE for YOU START coding your own client.
 * -
 * First things first, you need to call the ClientMain class in Minecraft.java. Search for the "startGame" method, and add this line:
 * ClientMain.getInstance.init();
 * -
 * Next, you need to call the events:
 * For the key event, you need to go to Minecraft.java, and search for "k == 1" (line 1950 - 1960), and add this line:
 * ClientMain.getInstance.eventBus.call(new KeyEvent(k));
 * -
 * For the tick event, you need to go to Minecraft.java, and search for "runTick" (line 1120 - 1134), and add this line:
 * ClientMain.getInstance.eventBus.call(new TickEvent());
 * -
 * For the render event, you need to go to GuiIngame.java, and search for "renderGameOverlay", at the very bottom of the method (before GlStateManager.color), add this line:
 * ClientMain.getInstance.eventBus.call(new OverlayEvent(partialTicks));
 * -
 * To create a new event, you need to create a new class, and implements Event:
 * public class TestEvent implements Event (if you want a cancelable event, you need to implement CancellableEvent) {
 *      TODO: Event code
 * }
 * -
 * To create a new module, you need to create a new class, extends Module and before "public class" @Mod(name = "name", description = "desc", key = 0 (Keyboard.KEY_R):
 * @Mod(name = "name", description = "desc", key = 0)
 * public class TestMod extends Module {
 *      TODO: Module code
 * }
 *
 */

public enum ClientMain {
    getInstance;

    public final ClientInfo clientInfo = new ClientInfo("BaseClient", "?", 1.0); // TODO: Client information

    public final String fullName = clientInfo.getName() + " " + clientInfo.getVersion();

    public EventBus eventBus; // TODO: Create the EventBus instance
    public ModuleManager moduleManager; // TODO: Create the ModuleManager instance

    public void init() {
        Display.setTitle(clientInfo.getName() + " " + clientInfo.getVersion());

        eventBus = new EventBus(); // TODO: Initialize the EventBus instance
        eventBus.register(this); // TODO: Register this class as a listener (for the KeyEvent)

        moduleManager = new ModuleManager(); // TODO: Initialize the ModuleManager instance
        moduleManager.init(); // TODO: Initialize the modules

        moduleManager.getModule(Overlay.class).setEnabled(true); // TODO: Enable the Overlay module
    }

    @EventHandler // TODO: This method will be called when a KeyEvent is posted (called)
    public final Listener<KeyEvent> keyListener = event -> {
        moduleManager.getModules().forEach(module -> {
            if (module.getKey() == event.getKey()) {
                module.toggle();
            }
        });
    };

    public class ClientInfo { // TODO: ClientInfo class

        // TODO: Information vars

        public String name;
        public String dev;
        public double version;

        public ClientInfo(String name, String dev, double version) { // TODO: Constructor
            this.name = name;
            this.dev = dev;
            this.version = version;
        }

        // TODO: Getters

        public String getName() {
            return name;
        }

        public String getDev() {
            return dev;
        }

        public double getVersion() {
            return version;
        }
    }
}
