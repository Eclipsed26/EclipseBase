package eclipse.base.systems.module;

import eclipse.base.systems.module.modules.TestMod;
import eclipse.base.systems.module.modules.render.Overlay;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleManager {
    ArrayList<Module> modules = new ArrayList<>(); // Arraylist of modules

    public void init() { // TODO: Initialize modules
        addModule(
                new TestMod(),
                new Overlay()
        );
    }

    public void addModule(Module... module) {
         modules.addAll(Arrays.asList(module));
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
