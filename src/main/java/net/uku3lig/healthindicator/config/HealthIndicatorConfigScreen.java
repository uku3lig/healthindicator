package net.uku3lig.healthindicator.config;

import net.minecraft.client.gui.screen.Screen;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.ukulib.config.option.CyclingOption;
import net.uku3lig.ukulib.config.option.ScreenOpenButton;
import net.uku3lig.ukulib.config.option.SliderOption;
import net.uku3lig.ukulib.config.option.WidgetCreator;
import net.uku3lig.ukulib.config.screen.AbstractConfigScreen;
import net.uku3lig.ukulib.utils.Position;

public class HealthIndicatorConfigScreen extends AbstractConfigScreen<HealthIndicatorConfig> {
    public HealthIndicatorConfigScreen(Screen parent) {
        super("HealthIndicator Config", parent, HealthIndicator.getManager());
    }

    @Override
    protected WidgetCreator[] getWidgets(HealthIndicatorConfig config) {
        return new WidgetCreator[]{
                new SliderOption("healthindicator.health", config.getMinHealth(), d -> config.setMinHealth((int) d),
                        SliderOption.INTEGER_VALUE_TO_TEXT, 0, 20, 1),
                new ScreenOpenButton(Position.KEY, parent -> new IndicatorPositionSelectScreen(parent, this.manager)),
                CyclingOption.ofBoolean("healthindicator.playSound", config.isPlaySound(), config::setPlaySound)
        };
    }
}
