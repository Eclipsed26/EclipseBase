package eclipse.base.systems.module.modules;

import eclipse.base.ClientBase;
import eclipse.base.systems.event.TickEvent;
import eclipse.base.systems.module.Mod;
import eclipse.base.systems.module.Module;
import eclipse.base.systems.module.setting.settings.BoolSetting;
import eclipse.base.systems.module.setting.settings.ModeSetting;
import eclipse.base.systems.module.setting.settings.NumberSetting;
import best.azura.eventbus.handler.EventHandler;
import best.azura.eventbus.handler.Listener;
import eclipse.base.utils.LogUtils;
import org.lwjgl.input.Keyboard;

@Mod(name = "Exemple", description = "Exemple", key = Keyboard.KEY_R) // Module info, name, description, key
public class TestMod extends Module {

    BoolSetting boolSetting = new BoolSetting("Bool", true); // Setting name, default value
    NumberSetting numberSetting = new NumberSetting("Number", 7d, 0d, 10d, 1d); // Setting name, default value, min value, max value, step
    ModeSetting modeSetting = new ModeSetting("Mode", "Mode 1", "Mode 1", "Mode 2"); // Setting name, default value, modes

    public TestMod() {
        this.addSetting(boolSetting, numberSetting, modeSetting); // Add settings
    }

    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("Bool: " + boolSetting.getValue());
        System.out.println("Number: " + numberSetting.getValue());
        System.out.println("Mode: " + modeSetting.get()); // Use get() to get the current mode, use getValue() to get the list of modes
    }

    @EventHandler
    public Listener<TickEvent> onTick = event -> {
        LogUtils.inGameLog("Tick");
    };

}
