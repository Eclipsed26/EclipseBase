package eclipse.base.systems.module.modules;

import eclipse.base.systems.event.TickEvent;
import eclipse.base.systems.module.Mod;
import eclipse.base.systems.module.Module;
import eclipse.base.utils.LogUtils;
import best.azura.eventbus.handler.EventHandler;
import best.azura.eventbus.handler.Listener;
import org.lwjgl.input.Keyboard;

@Mod(name = "Exemple", description = "Exemple", key = Keyboard.KEY_R) // TODO: Module info, name, description, key
public class TestMod extends Module {

    @EventHandler // TODO: Event handler, for the event
    public Listener<TickEvent> onTick = event -> { // TODO: Create the Listener to call the event
        LogUtils.consoleLog("Tick", LogUtils.LogType.INFO); // TODO: Log "Tick" in the console every tick
    };

}
