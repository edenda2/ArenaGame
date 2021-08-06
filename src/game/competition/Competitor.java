package game.competition;

import game.entities.IMobileEntity;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public interface Competitor extends IMobileEntity {
    /**
     * start the race for this competitor
     */
    void initRace();
}
