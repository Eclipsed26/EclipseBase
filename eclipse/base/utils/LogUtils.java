package eclipse.base.utils;

import eclipse.base.ClientBase;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class LogUtils {
    public static void inGameLog(String message) {
        if (Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§l" + ClientBase.getInstance().clientInfo.getName() + "§l§f> §r" + message));
        }
    }
}