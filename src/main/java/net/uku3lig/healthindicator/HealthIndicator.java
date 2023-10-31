package net.uku3lig.healthindicator;

import lombok.Getter;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import net.uku3lig.healthindicator.config.Config;
import net.uku3lig.ukulib.config.ConfigManager;

public class HealthIndicator {
    public static final Identifier ICONS = new Identifier("healthindicator", "warning.png");
    @Getter
    private static final ConfigManager<Config> manager = ConfigManager.createDefault(Config.class, "healthindicator");

    public static void drawWarning(DrawContext drawContext, int x, int y) {
        drawContext.drawTexture(HealthIndicator.ICONS, x, y, 0, 0, 32, 32, 32, 32);
    }

    private HealthIndicator() {
    }
}
