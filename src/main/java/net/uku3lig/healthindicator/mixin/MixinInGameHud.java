package net.uku3lig.healthindicator.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.Config;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @Shadow @Final private MinecraftClient client;
    @Shadow protected abstract void renderHealthBar(MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking);

    @Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"))
    private void renderHealthIndicator(InGameHud instance, MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking) {
        Config config = HealthIndicator.getManager().getConfig();

        if (lastHealth <= config.getMinHealth()) {
            RenderSystem.setShaderTexture(0, HealthIndicator.ICONS);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

            int x1 = config.getPosition().isRight() ? this.client.getWindow().getScaledWidth() - 5 - 32 : 5;
            int y1 = config.getPosition().isBottom() ? this.client.getWindow().getScaledHeight() - 5 - 32 : 5;
            this.client.inGameHud.drawTexture(new MatrixStack(), x1, y1, 0, 0, 32, 32);
        }
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, DrawableHelper.GUI_ICONS_TEXTURE);
        renderHealthBar(matrices, player, x, y, lines, regeneratingHeartIndex, maxHealth, lastHealth, health, absorption, blinking);
    }
}
