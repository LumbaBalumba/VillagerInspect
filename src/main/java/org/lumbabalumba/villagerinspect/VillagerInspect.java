package org.lumbabalumba.villagerinspect;

import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerInspect extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("VillagerInspect is enabled");
        this.getCommand("villagerinspect").setExecutor(new Inspect());
    }

    @Override
    public void onDisable() {
        getLogger().info("VillagerInspect is disabled");
    }
}
