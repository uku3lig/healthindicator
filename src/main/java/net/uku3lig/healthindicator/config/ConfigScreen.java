package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.option.CyclingOption;
import net.uku3lig.ukulib.config.option.SliderOption;
import net.uku3lig.ukulib.config.option.WidgetCreator;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;
import net.uku3lig.ukulib.utils.Position;

import java.util.EnumSet;

public class ConfigScreen extends AbstractConfigScreen<Config> {
    public ConfigScreen(Screen parent, ConfigManager<Config> manager) {
        super("HealthIndicator Config", parent, manager);
    }

    @Override
    protected WidgetCreator[] getWidgets(Config config) {
        return new WidgetCreator[]{
                new SliderOption("healthindicator.health", config.getMinHealth(), d -> config.setMinHealth((int) d),
                        SliderOption.INTEGER_VALUE_TO_TEXT, 0, 20, 1),
                Position.getOption(EnumSet.complementOf(EnumSet.of(Position.MIDDLE)), config.getPosition(), config::setPosition),
                CyclingOption.ofBoolean("healthindicator.playSound", config.isPlaySound(), config::setPlaySound)
        };
    }
}
