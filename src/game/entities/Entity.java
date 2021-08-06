package game.entities;

import game.arena.Arena;
import game.arena.WinterArena;
import utilities.Point;
import utilities.ValidationUtils;

import java.util.Observable;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public abstract class Entity extends Observable {
    private Point location;

    protected Arena arena;

    /**
     * Default ctor places entity at (0,0)
     */
    public Entity(){
        this(new Point());
    }

    /**
     * Ctor
     * @param location current location
     */
    public Entity(Point location) {
        this.location = location;
    }

    public Entity(Entity other){

        this.location=new Point(other.location);
    }
    //region Getters & setters
    /**
     * @return the current location of the entity
     */
    public Point getLocation() {
        return location;
    }
    /**
     * the methods give information about the place of the competitor to the competition.
     * @param location the new location of the entity
     * @throws IllegalArgumentException if argument is null
     */
    public void setLocation(Point location) {
        ValidationUtils.assertNotNull(location);
        this.location = location;
        notifyGUIObservers();

    }

    /**
     * notify to the observer the we change the location of the racer
     */
    public void notifyGUIObservers() {
        setChanged();
        notifyAllObservers();
    }

    /**
     * getter's
     * @return arena
     */
    public Arena getArena() {
        return arena;
    }


    /**
     * methods of observable.
     */
    private void notifyAllObservers(){
        super.notifyObservers();
    }
    //endregion
}
