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
    private int minHealth;
    private Position position;
    private boolean playSound;

    @Override
    public Config defaultConfig() {
        return new Config(6, Position.TOP_LEFT, false);
    }
}
