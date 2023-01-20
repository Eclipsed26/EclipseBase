package eclipse.base.systems.module.setting.settings;

import eclipse.base.systems.module.setting.Setting;

public class NumberSetting extends Setting<Double> {

    double min;
    double max;
    double increment;

    public NumberSetting(String name, Double value, Double min, Double max, Double increment) {
        super(name, value);

        this.min = min;
        this.max = max;
        this.increment = increment;
    }

}
