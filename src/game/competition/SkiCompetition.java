package game.competition;

import game.arena.Arena;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class SkiCompetition extends WinterCompetition {
    /**
     * Ctor for the competition
     * @param arena Winter arena in which the competition takes place in
     * @param maxCompetitors max competitors in the competition
     * @param discipline discipline
     * @param league age league
     * @param gender gender
     */
    public SkiCompetition(Arena arena, int maxCompetitors, Discipline discipline, League league, Gender gender) {
        super(arena, maxCompetitors, discipline, league, gender);
    }

    /**
     * checking if the competitor is valid
     * @param competitor
     * @return true if he valid else false
     */
    
    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        return competitor instanceof Skier && super.isValidCompetitor(competitor);
    }

    /**
     *
     * @return the name of the class
     */
    public String nameClass(){
        return this.getClass().getSimpleName();
    }
}
