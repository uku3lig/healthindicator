package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.CyclingOption;
import net.minecraft.client.option.DoubleOption;
import net.minecraft.client.option.Option;
import net.minecraft.text.Text;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.Position;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;

import java.util.EnumSet;
import net.minecraft.text.TranslatableText;

public class ConfigScreen extends AbstractConfigScreen<Config> {
    public ConfigScreen(Screen parent, ConfigManager<Config> manager) {
        super(parent, Text.of("HealthIndicator Config"), manager);
    }

    @Override
    protected Option[] getOptions(Config config) {
        return new Option[] {
                new DoubleOption("healthindicator.health", 0, 20, 1, opt -> (double) config.getMinHealth(), (opt, value) -> config.setMinHealth(value.intValue()),
                        (opt, value) -> new TranslatableText("healthindicator.health").append(": ").append(String.valueOf((int) value.get(opt)))),
                Position.getOption(EnumSet.complementOf(EnumSet.of(Position.MIDDLE)), config::getPosition, config::setPosition),
                CyclingOption.create("healthindicator.playSound", opt -> config.isPlaySound(), (opt, option, value) -> config.setPlaySound(value))
        };
    }
}
