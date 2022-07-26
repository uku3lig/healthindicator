package net.uku3lig.healthindicator.config;

import lombok.Getter;
import net.minecraft.util.TranslatableOption;

import java.util.Arrays;

@Getter // lombok generates the methods that have to be implemented
public enum Position implements TranslatableOption {
    TOP_LEFT(0, "position.topLeft"),
    TOP_RIGHT(1, "position.topRight"),
    BOTTOM_LEFT(2, "position.bottomLeft"),
    BOTTOM_RIGHT(3, "position.bottomRight");

    private final int id;
    private final String translationKey;

    Position(int id, String translationKey) {
        this.id = id;
        this.translationKey = translationKey;
    }

    public boolean isRight() {
        return Arrays.asList(TOP_RIGHT, BOTTOM_RIGHT).contains(this);
    }

    public boolean isBottom() {
        return Arrays.asList(BOTTOM_LEFT, BOTTOM_RIGHT).contains(this);
    }
}
