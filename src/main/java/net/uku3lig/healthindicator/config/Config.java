package net.uku3lig.healthindicator.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.uku3lig.ukulib.utils.Position;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Config implements Serializable {
    private int minHealth = 6;
    private Position position = Position.TOP_LEFT;
    private boolean playSound = false;
}
