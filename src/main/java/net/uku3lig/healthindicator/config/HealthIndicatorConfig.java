package net.uku3lig.healthindicator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthIndicatorConfig implements Serializable {
    private int minHealth = 6;
    private int x = -1;
    private int y = -1;
    private boolean playSound = false;
}
