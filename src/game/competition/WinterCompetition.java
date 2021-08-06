package game.competition;

import game.arena.Arena;
import game.arena.WinterArena;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

import java.util.Observable;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class WinterCompetition extends Competition {
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW2.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private final Discipline discipline;
    private final League league;
    private final Gender gender;
    /**
     * Ctor for the competition
     * @param arena Winter arena in which the competition takes place in
     * @param maxCompetitors max competitors in the competition
     * @param discipline discipline
     * @param league age league
     * @param gender gender
     */
    public WinterCompetition(Arena arena, int maxCompetitors, Discipline discipline, League league, Gender gender) {
        super(arena, maxCompetitors);
        this.discipline = discipline;
        this.league = league;
        this.gender = gender;
    }

    /**

     * checking if the competitor is valid
     * @param competitor contending competitor
     * @return true if he valid else false
     */
    @Override
    public boolean isValidCompetitor(Competitor competitor){
        if(competitor instanceof WinterSportsman){
            WinterSportsman winterSportsman = (WinterSportsman) competitor;
            return discipline.equals(winterSportsman.getDiscipline()) &&
                    league.isInLeague(winterSportsman.getAge()) &&
                    gender.equals(winterSportsman.getGender());
        }
        return false;
    }

    /**
     * getter's
     * @return discipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * getter's
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * getter's
     * @return league
     */
    public League getLeague() {
        return league;
    }

    /**
     *
     * @return the name of the class
     */
    public String nameClass(){
        return this.getClass().getSimpleName();
    }
}
