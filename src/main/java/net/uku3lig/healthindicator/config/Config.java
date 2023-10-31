package net.uku3lig.healthindicator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.uku3lig.ukulib.config.IConfig;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Config implements IConfig<Config> {
    private int minHealth = 6;
    private int x = -1;
    private int y = -1;
    private boolean playSound = false;

    @Override
    public Config defaultConfig() {
        return new Config();
    }
}
