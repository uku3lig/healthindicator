package net.uku3lig.healthindicator.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.Config;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @Shadow @Final private MinecraftClient client;

    @ModifyArgs(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"))
    private void renderHealthIndicator(Args args) {
        Config config = HealthIndicator.getManager().getConfig();
        DrawContext context = args.get(0);
        int lastHealth = args.get(7);

        if (lastHealth <= config.getMinHealth()) {
            int x1 = config.getPosition().isRight() ? this.client.getWindow().getScaledWidth() - 5 - 32 : 5;
            int y1 = config.getPosition().isBottom() ? this.client.getWindow().getScaledHeight() - 5 - 32 : 5;
            context.drawTexture(HealthIndicator.ICONS, x1, y1, 0, 0, 32, 32);
        }
    }
}
