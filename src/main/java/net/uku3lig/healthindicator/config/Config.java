package net.uku3lig.healthindicator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.uku3lig.ukulib.config.IConfig;
import net.uku3lig.ukulib.config.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Config implements IConfig<Config> {
    private int minHealth = 6;
    private Position position = Position.TOP_LEFT;
    private boolean playSound = false;

    @Override
    public Config defaultConfig() {
        return new Config();
    }
}
