package game.competition;

import game.arena.IArena;
import game.entities.sportsman.WinterSportsman;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public abstract class Competition{
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW2.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private IArena arena;
    private  ArrayList<Competitor> activeCompetitors;
    private  ArrayList<Competitor> finishedCompetitors;
    private final int maxCompetitors;

    /**
     * Ctor for an abstract competition
     * @param arena Arena in which the competition takes place in
     * @param maxCompetitors Maximum number of competitor allowed in the competition
     */
    public Competition(IArena arena, int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
        this.activeCompetitors = new ArrayList<>();
        this.finishedCompetitors = new ArrayList<>();
        this.arena = arena;
    }

    /**
     * Validate if a competitor can compete
     * @param competitor contending competitor
     * @return true if competitor is validated else false
     */
    public abstract boolean isValidCompetitor(Competitor competitor);

    /**
     *
     * @return the name of the class
     */
    public String nameClass(){
        return this.getClass().getSimpleName();
    }
    /**
     * adds a valid competitor to the competition
     * @param competitor competitor to be added
     */
    public void addCompetitor(Competitor competitor){

        ValidationUtils.assertNotNull(competitor);
        if(maxCompetitors <= activeCompetitors.size()){
            throw new IllegalStateException("WinterArena is full max = "+ maxCompetitors);
        }
        if(isValidCompetitor(competitor)){
            if (competitor instanceof WinterSportsman){
                competitor.initRace();
                activeCompetitors.add(competitor);
            }
        }

        else{
            throw new IllegalArgumentException("Invalid competitor "+ competitor);
        }
    }



    /**
     * Get competitors who have finished (used later so we could print them)
     * @return all finished competitors.
     */
    public ArrayList<Competitor> getFinishedCompetitors() {
        synchronized (finishedCompetitors){
            return new ArrayList<>(finishedCompetitors);
        }
    }

    /**
     * Get all active competitors
     * @return all active competitors.
     */
    public ArrayList<Competitor> getActiveCompetitors() {
        return new ArrayList<>(activeCompetitors);
    }
    
    public int getMaxComp(){
    return maxCompetitors; }



}
