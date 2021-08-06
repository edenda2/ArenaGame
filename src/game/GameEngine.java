package game;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.WinterSportsman;
import utilities.ValidationUtils;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class GameEngine {

    private static GameEngine instance;
    private Thread thread;

    /**.
     * @return singleton instance of the game engine
     */
    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * private empty Ctor for game engine
     */
    private GameEngine() {
    }

    /**
     * Start a race at a competition
     * This method will play competition turns until finished by using thread.
     * @param competition The competition to be run
     */
    public void startRace(Competition competition) {
        ValidationUtils.assertNotNull(competition);
        for(Competitor competitor: competition.getActiveCompetitors()){

            WinterSportsman winterSportsman = (WinterSportsman)competitor;
            new Thread(winterSportsman).start();
        }

        }

}
