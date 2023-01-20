package eclipse.base.systems.module.setting.settings;

import eclipse.base.systems.module.setting.Setting;

public class BoolSetting extends Setting<Boolean> {

    public BoolSetting(String name, Boolean value) {
        super(name, value);
    }

    public void toggle() {
        setValue(!getValue());
    }

    public void set(boolean value) {
        setValue(value);
    }

    public boolean get() {
        return getValue();
    }
}