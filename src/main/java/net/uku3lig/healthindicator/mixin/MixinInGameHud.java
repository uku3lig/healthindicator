package net.uku3lig.healthindicator.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @ModifyArgs(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"))
    private void renderHealthIndicator(Args args) {
        Config config = HealthIndicator.getManager().getConfig();
        DrawContext drawContext = args.get(0);
        int lastHealth = args.get(7);

        if (lastHealth <= config.getMinHealth()) {
            int x = config.getX() == -1 ? 5 : config.getX();
            int y = config.getY() == -1 ? 5 : config.getY();
            HealthIndicator.drawWarning(drawContext, x, y);
        }
    }
}
