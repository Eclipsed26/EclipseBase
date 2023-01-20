package eclipse.base.systems.module.setting;

public class Setting<Setting> {
    private String name;
    private Setting value;
    private boolean hidden;

    public Setting(String name, Setting value) {
        this.name = name;
        this.value = value;
        this.hidden = false;
    }

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public Setting getValue() {
        return value;
    }

    public void setValue(Setting value) {
        this.value = value;
    }
}