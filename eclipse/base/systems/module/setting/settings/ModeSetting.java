package eclipse.base.systems.module.setting.settings;

import eclipse.base.systems.module.setting.Setting;

import java.util.Arrays;
import java.util.List;

public class ModeSetting extends Setting<List<String>> {

    private int index;

    public ModeSetting(String name, String value, String... modes) {
        super(name, Arrays.asList(modes));

        this.index = Arrays.asList(modes).indexOf(value);
    }

    public boolean is(String mode) {
        return getValue().get(index).equalsIgnoreCase(mode);
    }

    public void set(String value) {
        this.index = getValue().indexOf(value);
    }

    public String get() {
        return getValue().get(index);
    }

    public void next() {
        if(index == getValue().size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    public void previous() {
        if(index == 0) {
            index = getValue().size() - 1;
        } else {
            index--;
        }
    }

}
