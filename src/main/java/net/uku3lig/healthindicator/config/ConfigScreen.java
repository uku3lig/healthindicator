package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.CyclingOption;
import net.minecraft.client.option.DoubleOption;
import net.minecraft.client.option.Option;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ConfigScreen extends AbstractConfigScreen {
    public ConfigScreen(Screen parent) {
        super(parent, Text.of("HealthIndicator Config"));
    }

    @Override
    protected Option[] getOptions() {
        return new Option[] {
                new DoubleOption("healthindicator.health", 0, 20, 1, opt -> (double) config.getMinHealth(), (opt, value) -> config.setMinHealth(value.intValue()),
                        (opt, value) -> new TranslatableText("healthindicator.health").append(": ").append(String.valueOf((int) value.get(opt)))),
                CyclingOption.create("healthindicator.position", Position.values(), pos -> new TranslatableText(pos.getTranslationKey()), opt -> config.getPosition(), (opt, option, value) -> config.setPosition(value)),
                CyclingOption.create("healthindicator.playSound", opt -> config.isPlaySound(), (opt, option, value) -> config.setPlaySound(value))
        };
    }
}
