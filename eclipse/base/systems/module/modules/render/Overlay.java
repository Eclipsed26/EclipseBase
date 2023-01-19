package eclipse.base.systems.module.modules.render;

import eclipse.base.ClientMain;
import eclipse.base.systems.event.OverlayEvent;
import eclipse.base.systems.module.Mod;
import eclipse.base.systems.module.Module;
import best.azura.eventbus.handler.EventHandler;
import best.azura.eventbus.handler.Listener;
import net.minecraft.client.gui.ScaledResolution;

import java.util.Comparator;

@Mod(name = "Overlay", description = "Overlay", key = 0)
public class Overlay extends Module {

    @EventHandler
    public Listener<OverlayEvent> overlayListener = event -> {
        ScaledResolution sr = new ScaledResolution(mc);

        mc.fontRendererObj.drawStringWithShadow(ClientMain.getInstance.fullName, 2, 2, -1);

        ClientMain.getInstance.moduleManager.getModules().sort(Comparator.comparingDouble(m -> mc.fontRendererObj.getStringWidth(((Module) m).getName())).reversed());

        int index = 0;
        for (Module module : ClientMain.getInstance.moduleManager.getModules()) {
            if (module.isEnabled()) {
                mc.fontRendererObj.drawStringWithShadow(module.getName(), sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(module.getName()) - 2, index + 2, -1);
                index += mc.fontRendererObj.FONT_HEIGHT + 2;
            }
        }
    };

}