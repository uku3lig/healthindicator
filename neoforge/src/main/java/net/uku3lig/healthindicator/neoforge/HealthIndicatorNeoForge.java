package net.uku3lig.healthindicator.neoforge;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.UkulibHook;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import net.uku3lig.ukulib.neoforge.UkulibNFProvider;

@Mod(value = "healthindicator", dist = Dist.CLIENT)
public class HealthIndicatorNeoForge {
    public HealthIndicatorNeoForge(ModContainer container, IEventBus modBus) {
        container.registerExtensionPoint(UkulibNFProvider.class, UkulibHook::new);
        modBus.addListener(this::onRegisterGuiLayers);
    }

    private void onRegisterGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAboveAll(Identifier.fromNamespaceAndPath("healthindicator", "gui_health_warning"),
                (graphics, _) -> {
                    HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();
                    float lastHealth = Minecraft.getInstance().player.getHealth();

                    if (lastHealth <= config.getMinHealth()) {
                        HealthIndicator.drawWarningDefault(graphics);
                    }
                });
    }
}
