package net.uku3lig.healthindicator;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import net.uku3lig.ukulib.config.ConfigManager;

public class HealthIndicator {
    public static final Identifier ICONS = Identifier.fromNamespaceAndPath("healthindicator", "warning.png");

    @Getter
    private static final ConfigManager<HealthIndicatorConfig> manager = ConfigManager.createDefault(HealthIndicatorConfig.class, "healthindicator");

    @Getter
    @Setter
    private static long lastPlayedSound = 0;

    public static void drawWarning(GuiGraphicsExtractor graphics, int x, int y) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, HealthIndicator.ICONS, x, y, 0, 0, 32, 32, 32, 32);
    }

    public static void drawWarningDefault(GuiGraphicsExtractor graphics) {
        int x = manager.getConfig().getX() == -1 ? 5 : manager.getConfig().getX();
        int y = manager.getConfig().getY() == -1 ? 5 : manager.getConfig().getY();
        HealthIndicator.drawWarning(graphics, x, y);
    }

    private HealthIndicator() {
    }
}
