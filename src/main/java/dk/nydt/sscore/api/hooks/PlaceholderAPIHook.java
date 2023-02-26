package dk.nydt.sscore.api.hooks;

import org.bukkit.plugin.java.JavaPlugin;

public class PlaceholderAPIHook extends Hook{
    public PlaceholderAPIHook() {
        super("PlaceholderAPI", dk.nydt.sscore.api.enums.Hook.PLACEHOLDERAPI);
    }

    /**
     *
     * Initialising the {@link PlaceholderAPIHook}.
     *
     * @param paramPlugin The core plugin.
     * @return if the hook is established currently.
     */
    @Override
    public boolean init(JavaPlugin paramPlugin) {
        return super.isEnabled();
    }
}
