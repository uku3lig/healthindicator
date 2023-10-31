package net.uku3lig.healthindicator;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Getter;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.uku3lig.healthindicator.config.Config;
import net.uku3lig.ukulib.config.ConfigManager;

public class HealthIndicator {
    public static final Identifier ICONS = new Identifier("healthindicator", "warning.png");
    @Getter
    private static final ConfigManager<Config> manager = ConfigManager.create(Config.class, "healthindicator");

    public static void drawWarning(MatrixStack matrices, int x, int y) {
        int old = RenderSystem.getShaderTexture(0);
        RenderSystem.setShaderTexture(0, HealthIndicator.ICONS);
        DrawableHelper.drawTexture(matrices, x, y, 0, 0, 32, 32, 32, 32);
        RenderSystem.setShaderTexture(0, old);
    }

    private HealthIndicator() {
    }
}
