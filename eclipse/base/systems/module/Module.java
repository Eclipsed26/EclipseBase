package eclipse.base.systems.module;

import eclipse.base.ClientMain;
import eclipse.base.utils.LogUtils;
import net.minecraft.client.Minecraft;

public class Module {

    public Minecraft mc = Minecraft.getMinecraft();

    // TODO: Get the module information from the module class with "@Mod" annotation

    Mod mod = getClass().getAnnotation(Mod.class);

    String name = mod.name();
    String description = mod.description();
    int key = mod.key();

    // TODO: Enable/Disable methods

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }


    public void onEnable() {
        enabled = true;
        ClientMain.getInstance.eventBus.register(this);
        LogUtils.inGameLog("Module " + getName() + " enabled.", LogUtils.LogType.SUCCESS);
    }

    public void onDisable() {
        enabled = false;
        ClientMain.getInstance.eventBus.unregister(this);
        LogUtils.inGameLog("Module " + getName() + " disabled.", LogUtils.LogType.ERROR);
    }

    // TODO: Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getKey() {
        return key;
    }

}
