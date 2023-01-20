package eclipse.base.systems.module;

import eclipse.base.ClientBase;
import eclipse.base.systems.module.setting.Setting;
import eclipse.base.utils.LogUtils;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ClientBase.getInstance().getEventBus().register(this);
        LogUtils.inGameLog("Module " + getName() + " enabled.");
    }

    public void onDisable() {
        enabled = false;
        ClientBase.getInstance().getEventBus().unregister(this);
        LogUtils.inGameLog("Module " + getName() + " disabled.");
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

    public List<Setting> settings = new ArrayList<Setting>();

    public void addSetting(Setting... settings) {
        this.settings.addAll(Arrays.asList(settings));
    }

    public List<Setting> getSettings() {
        return settings;
    }

}
