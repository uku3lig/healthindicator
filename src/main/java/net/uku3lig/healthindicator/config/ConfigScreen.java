package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;
import net.uku3lig.ukulib.utils.Ukutils;

public class ConfigScreen extends AbstractConfigScreen<Config> {
    public ConfigScreen(Screen parent, ConfigManager<Config> manager) {
        super(parent, Text.of("HealthIndicator Config"), manager);
    }

    @Override
    protected SimpleOption<?>[] getOptions(Config config) {
        return new SimpleOption[] {
                new SimpleOption<>("healthindicator.health", SimpleOption.constantTooltip(Text.translatable("healthindicator.health.tooltip")),
                        GameOptions::getGenericValueText, new SimpleOption.ValidatingIntSliderCallbacks(0, 20), config.getMinHealth(), config::setMinHealth),
                Ukutils.createOpenButton("ukulib.position", parent -> new IndicatorPositionSelectScreen(parent, manager)),
                SimpleOption.ofBoolean("healthindicator.playSound", config.isPlaySound(), config::setPlaySound)
        };
    }
}
