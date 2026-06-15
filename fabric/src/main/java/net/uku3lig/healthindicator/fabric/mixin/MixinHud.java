package net.uku3lig.healthindicator.fabric.mixin;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.world.entity.player.Player;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hud.class)
public abstract class MixinHud {
    @Inject(method = "extractHearts", at = @At("HEAD"))
    private void renderHealthIndicator(GuiGraphicsExtractor graphics, Player player, int xLeft, int yLineBase, int healthRowHeight, int heartOffsetIndex, float maxHealth, int currentHealth, int oldHealth, int absorption, boolean blink, CallbackInfo ci) {
        HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();

        if (currentHealth <= config.getMinHealth()) {
            HealthIndicator.drawWarningDefault(graphics);
        }
    }
}
