package net.uku3lig.healthindicator.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Gui.class)
public abstract class MixinGui {
    @ModifyArgs(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderHearts(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/entity/player/Player;IIIIFIIIZ)V"))
    private void renderHealthIndicator(Args args) {
        HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();
        GuiGraphics graphics = args.get(0);
        int lastHealth = args.get(7);

        if (lastHealth <= config.getMinHealth()) {
            int x = config.getX() == -1 ? 5 : config.getX();
            int y = config.getY() == -1 ? 5 : config.getY();
            HealthIndicator.drawWarning(graphics, x, y);
        }
    }
}
