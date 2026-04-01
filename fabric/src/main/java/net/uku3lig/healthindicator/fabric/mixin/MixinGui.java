package net.uku3lig.healthindicator.fabric.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Gui.class)
public abstract class MixinGui {
    @ModifyArgs(method = "extractPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;extractHearts(Lnet/minecraft/client/gui/GuiGraphicsExtractor;Lnet/minecraft/world/entity/player/Player;IIIIFIIIZ)V"))
    private void renderHealthIndicator(Args args) {
        HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();
        GuiGraphicsExtractor graphics = args.get(0);
        int lastHealth = args.get(7);

        if (lastHealth <= config.getMinHealth()) {
            HealthIndicator.drawWarningDefault(graphics);
        }
    }
}
