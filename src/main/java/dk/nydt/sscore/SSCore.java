package dk.nydt.sscore;

import dev.triumphteam.gui.guis.Gui;
import dk.nydt.sscore.api.hooks.PlaceholderAPIHook;
import dk.nydt.sscore.api.hooks.VaultHook;
import dk.nydt.sscore.api.enums.Hook;
import dk.nydt.sscore.api.hooks.Actionbar;
import dk.nydt.sscore.api.interfaces.IHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class SSCore extends JavaPlugin {
    private static SSCore INSTANCE;
    private static final HashMap<String, Plugin> DEPENDANTS = new HashMap<>();
    private static final HashMap<Hook, Boolean> HOOKS = new HashMap<>();
    @Override
    public void onEnable() {
        INSTANCE = this;

        Bukkit.getLogger().info("Loading dependant plugins.");
        for(Plugin dependant : getServer().getPluginManager().getPlugins()){
            PluginDescriptionFile pdf = dependant.getDescription();
            if(pdf.getDepend().contains(getName()) || pdf.getSoftDepend().contains(getName()))
                DEPENDANTS.put(dependant.getName(), dependant);
        }
        Bukkit.getLogger().info(String.format("Loaded dependants (%d): %s", DEPENDANTS.size(), DEPENDANTS.values()));

        initialiseHooks();

    }

    private void initialiseHooks(){
        IHook[] hooks = new IHook[]{
                new VaultHook(),
                new PlaceholderAPIHook(),
                new Actionbar(),
        };
        for(IHook hook : hooks)
            HOOKS.put(hook.getEnum(), hook.init(this));
    }

    public static boolean isHookInitialised(Hook paramHook) {
        return HOOKS.getOrDefault(paramHook, false);
    }

    public static SSCore getInstance() {
        return INSTANCE;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
