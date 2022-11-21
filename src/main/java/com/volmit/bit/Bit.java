package com.volmit.bit;

import art.arcane.spatial.space.Space;
import com.volmit.bit.util.C;
import com.volmit.bit.util.Instance;
import com.volmit.bit.util.VolmitPlugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Bit extends VolmitPlugin {
    @Instance
    public static Bit instance;

    @Override
    public void onEnable()
    {
        instance = this;
        super.onEnable();
    }

    @Override
    public void start() {
        instance = this;
    }

    @Override
    public void stop() {

    }

    @Override
    public String getTag(String subTag) {
        return C.BOLD + "" + C.DARK_GRAY + "[" + C.BOLD + "" + C.BLUE + "Bit" + C.BOLD + C.DARK_GRAY + "]" + C.RESET + "" + C.GRAY + ": ";
    }

    public static void actionbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
    }

    public static void warn(String string) {
        msg(C.YELLOW + string);
    }

    public static void error(String string) {
        msg(C.RED + string);
    }

    public static void verbose(String string) {
        if (BitConfig.get().isVerbose()) {
            msg(C.LIGHT_PURPLE + string);
        }
    }

    public static void success(String string) {
        msg(C.GREEN + string);
    }

    public static void info(String string) {
        msg(C.WHITE + string);
    }

    public static void msg(String string) {
        try {
            if (instance == null) {
                System.out.println("[Bit]: " + string);
                return;
            }

            String msg = C.GRAY + "[" + C.BLUE + "Bit" + C.GRAY + "]: " + string;
            Bukkit.getConsoleSender().sendMessage(msg);
        } catch (Throwable e) {
            System.out.println("[Bit]: " + string);
        }
    }
}
