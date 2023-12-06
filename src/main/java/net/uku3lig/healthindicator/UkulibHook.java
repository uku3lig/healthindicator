package net.uku3lig.healthindicator;

import net.minecraft.client.gui.screen.Screen;
import net.uku3lig.healthindicator.config.HealthIndicatorConfigScreen;
import net.uku3lig.ukulib.api.UkulibAPI;

import java.util.function.UnaryOperator;

public class UkulibHook implements UkulibAPI {
    @Override
    public UnaryOperator<Screen> supplyConfigScreen() {
        return HealthIndicatorConfigScreen::new;
    }
}
