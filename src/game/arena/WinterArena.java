package game.arena;

import game.entities.IMobileEntity;
import game.enums.WeatherCondition;
import game.enums.SnowSurface;
import utilities.ValidationUtils;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class WinterArena extends Arena {

    /**
     * Ctor for a generic arena
     * @param length the length of the arena
     * @param surface the snow surface of the arena
     * @param condition the weather condition in the arena
     */
    public WinterArena(double length, SnowSurface surface, WeatherCondition condition) {
        super(length,surface,condition);
    }


}
