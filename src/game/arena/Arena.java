package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;

import java.lang.reflect.Constructor;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class Arena implements IArena{

    private final double length;
    private final SnowSurface surface;
    private final WeatherCondition condition;

    /**
     * Ctor for the Arena
     * @param length length of the arena
     * @param surface snow surface of the arena
     * @param condition weather condition of the arena
     */
        public Arena(double length, SnowSurface surface, WeatherCondition condition){
            this.length=length;
            this.surface=surface;
            this.condition=condition;
        }

    /**
     * getter's
     * @return the friction of arena
     */
    @Override
    public double getFriction(){
        return surface.getFriction();
    }

    /**
     * check if the mobile entity cross the finish line
     * @param mobileEntity entity to check
     * @return true if he cross else false
     */
    @Override
    public boolean isFinished(IMobileEntity mobileEntity) {
        ValidationUtils.assertNotNull(mobileEntity);
        return mobileEntity.getLocation().getY() >= length;
    }

    /**
     * getter's
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * getter's
     * @return surface
     */
    public SnowSurface getSurface() {
        return surface;
    }

    /**
     * getter's
     * @return weather condition
     */
    public WeatherCondition getCondition() {
        return condition;
    }
}
