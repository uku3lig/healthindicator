package net.uku3lig.healthindicator;

import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.uku3lig.healthindicator.config.Config;
import net.uku3lig.ukulib.config.ConfigManager;

public class HealthIndicator implements ModInitializer {
    public static final Identifier ICONS = new Identifier("healthindicator", "gui/icons.png");
    @Getter
    private static final ConfigManager<Config> manager = ConfigManager.create(Config.class, "healthindicator");

    @Override
    public void onInitialize() {
        // hi
    }
}
