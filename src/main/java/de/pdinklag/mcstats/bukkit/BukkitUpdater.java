package de.pdinklag.mcstats.bukkit;

import de.pdinklag.mcstats.Config;
import de.pdinklag.mcstats.LogWriter;
import de.pdinklag.mcstats.PlayerProfileProviderList;
import de.pdinklag.mcstats.Updater;

public class BukkitUpdater extends Updater {
    private final MinecraftStatsPlugin plugin;

    public BukkitUpdater(MinecraftStatsPlugin plugin, Config config, LogWriter log) {
        super(config, log);
        this.plugin = plugin;
    }

    @Override
    protected void gatherLocalProfileProviders(PlayerProfileProviderList providers) {
        super.gatherLocalProfileProviders(providers);
        providers.addFirst(new OfflinePlayerProfileProvider(plugin.getServer()));
    }

    @Override
    protected String getServerMotd() {
        return plugin.getServer().getMotd();
    }

    @Override
    protected String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public void run() {
        log.writeLine("Updating ...");
        super.run();
        log.writeLine("Update complete.");
    }
}