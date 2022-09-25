package net.uku3lig.healthindicator.config;

import com.mojang.serialization.Codec;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import net.uku3lig.ukulib.config.ConfigManager;
import net.uku3lig.ukulib.config.Position;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;

import java.util.Arrays;

public class ConfigScreen extends AbstractConfigScreen<Config> {
    public ConfigScreen(Screen parent, ConfigManager<Config> manager) {
        super(parent, Text.of("HealthIndicator Config"), manager);
    }

    @Override
    protected SimpleOption<?>[] getOptions(Config config) {
        return new SimpleOption[] {
                new SimpleOption<>("healthindicator.health", SimpleOption.constantTooltip(Text.translatable("healthindicator.health.tooltip")),
                        GameOptions::getGenericValueText, new SimpleOption.ValidatingIntSliderCallbacks(0, 20), config.getMinHealth(), config::setMinHealth),
                new SimpleOption<>("healthindicator.position", SimpleOption.emptyTooltip(), SimpleOption.enumValueText(),
                        new SimpleOption.PotentialValuesBasedCallbacks<>(Arrays.asList(Position.values()), Codec.STRING.xmap(Position::valueOf, Position::name)),
                        config.getPosition(), config::setPosition),
                SimpleOption.ofBoolean("healthindicator.playSound", config.isPlaySound(), config::setPlaySound)
        };
    }
}
