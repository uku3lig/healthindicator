package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class ConfigScreen extends AbstractConfigScreen {
    public ConfigScreen(Screen parent) {
        super(parent, Text.of("HealthIndicator Config"));
    }

    @Override
    protected SimpleOption<?>[] getOptions() {
        return new SimpleOption[] {
                new SimpleOption<>("healthindicator.health", SimpleOption.constantTooltip(Text.translatable("healthindicator.health.tooltip")),
                        GameOptions::getGenericValueText, new SimpleOption.ValidatingIntSliderCallbacks(0, 20), config.getMinHealth(), config::setMinHealth)
        };
    }
}
