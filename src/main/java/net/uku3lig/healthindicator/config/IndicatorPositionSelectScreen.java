package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.screen.PositionSelectScreen;

public class IndicatorPositionSelectScreen extends PositionSelectScreen {
    protected IndicatorPositionSelectScreen(Screen parent, ConfigManager<Config> manager) {
        super("Position Selection", parent, manager.getConfig().getX(), manager.getConfig().getY(), manager, (x, y) -> {
            manager.getConfig().setX(x);
            manager.getConfig().setY(y);
        });
    }

    @Override
    protected void draw(DrawContext drawContext, int mouseX, int mouseY, float delta, int x, int y) {
        HealthIndicator.drawWarning(drawContext, x, y);
    }
}
