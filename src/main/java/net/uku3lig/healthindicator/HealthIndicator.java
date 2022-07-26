package net.uku3lig.healthindicator;

import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.uku3lig.healthindicator.config.Config;

import java.io.File;

public class HealthIndicator implements ModInitializer {
    public static final Identifier ICONS = new Identifier("healthindicator", "gui/icons.png");
    public static final File CONFIG_FILE = new File("./config/healthindicator.toml");
    @Getter
    private static Config config;

    @Override
    public void onInitialize() {
        config = Config.readConfig(CONFIG_FILE);
    }
}
