package game.arena;

import game.entities.IMobileEntity;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public interface IArena {
    /**
     * returns the friction of the arena
     * @return friction
     */
    double getFriction();

    /**
     * indicated if a mobile entity has finished the arena course.
     * @param mobileEntity entity to check
     * @return true if finished else false
     */
    boolean isFinished(IMobileEntity mobileEntity);
}
