package net.uku3lig.healthindicator.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @Shadow protected abstract void renderHealthBar(MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking);

    @Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"))
    private void renderHealthIndicator(InGameHud instance, MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking) {
        Config config = HealthIndicator.getManager().getConfig();

        if (lastHealth <= config.getMinHealth()) {
            int x1 = config.getX() == -1 ? 5 : config.getX();
            int y1 = config.getY() == -1 ? 5 : config.getY();
            HealthIndicator.drawWarning(matrices, x1, y1);
        }

        renderHealthBar(matrices, player, x, y, lines, regeneratingHeartIndex, maxHealth, lastHealth, health, absorption, blinking);
    }
}
