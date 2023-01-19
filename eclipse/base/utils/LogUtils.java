package eclipse.base.utils;

import eclipse.base.ClientMain;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.opencl.CL;

public class LogUtils {


    // TODO: This can be used to log something on the console. Exemple: LogUitls.consoleLog("Hello World!", LogType.SUCCESS);
    public static void consoleLog(String message, LogType type) {
        String prefix;

        switch (type) {
            case SUCCESS:
                prefix = "[SUCCESS]";
                break;
            case ERROR:
                prefix = "[ERROR]";
                break;
            case INFO:
                prefix = "[INFO]";
                break;
            default:
                prefix = "[OTHER]";
                break;
        }

        System.out.println(prefix + " " + message);
    }


    // TODO: This can be used to send a message in the chat. Exemple: LogUtils.inGameLog("Hello World!", LogType.SUCCESS);
    public static void inGameLog(String message, LogType type) {
        if (Minecraft.getMinecraft().thePlayer != null) {
            String prefix = "";

            switch (type) {
                case ERROR:
                    prefix = "§c> ";
                    break;
                case WARN:
                    prefix = "§e> ";
                    break;
                case INFO:
                    prefix = "§b> ";
                    break;
                case SUCCESS:
                    prefix = "§a> ";
                    break;
                default:
                    prefix = "§r> ";
                    break;
            }

            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§l" + ClientMain.getInstance.clientInfo.getName() + " " + prefix + message));
        }
    }

    public enum LogType { // TODO: LogType enum
        ERROR, WARN, INFO, SUCCESS
    }
}