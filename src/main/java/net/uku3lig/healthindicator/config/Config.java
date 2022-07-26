package net.uku3lig.healthindicator.config;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
public class Config {
    private static final Logger logger = LogManager.getLogger("HealthIndicatorConfig");

    private int minHealth;

    public Config() {
        this(6);
    }

    public static Config readConfig(File file) {
        if (!file.exists()) {
            try {
                new Config().writeConfig(file);
            } catch (IOException e) {
                logger.warn("Could not write default configuration file", e);
            }
            return new Config();
        } else {
            return new Toml().read(file).to(Config.class);
        }
    }

    public void writeConfig(File file) throws IOException {
        new TomlWriter().write(this, file);
    }
}
