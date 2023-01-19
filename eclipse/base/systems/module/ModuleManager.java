package eclipse.base.systems.module;

import eclipse.base.systems.module.modules.TestMod;
import eclipse.base.systems.module.modules.render.Overlay;
import eclipse.base.utils.LogUtils;

import java.util.ArrayList;

public class ModuleManager {
    ArrayList<Module> modules = new ArrayList<>(); // Arraylist of modules

    public void init() { // TODO: Initialize modules
        addModule(
                new TestMod(),
                new Overlay()
        );
    }

    public void addModule(Module... module) {
        for (Module m : module) {
            modules.add(m);
            LogUtils.consoleLog("Registered " + m.getName(), LogUtils.LogType.SUCCESS);
        }
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module getModule(Class<? extends Module> clazz) {
        for (Module module : modules) {
            if (module.getClass() == clazz) {
                return module;
            }
        }
        return null;
    }
}
