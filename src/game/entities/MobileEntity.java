package game.entities;

import game.arena.Arena;
import game.arena.WinterArena;
import game.entities.ActivityStates.ActiveState;
import game.entities.ActivityStates.ActivityState;
import utilities.Point;
import utilities.ValidationUtils;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */


public class MobileEntity extends Entity implements IMobileEntity,Runnable{
    private final double maxSpeed;
    private double acceleration;
    private double speed;
    private ActivityState activityState;
    private Point stop_place=null;
    private boolean finished = false;


    /**
     * Ctor for a mobile entity in the game
     * @param initialSpeed initial speed of the entity
     * @param acceleration entity acceleration
     * @param maxSpeed entity maximum speed
     */
    public MobileEntity(double initialSpeed, double acceleration, double maxSpeed, Arena arena){
        ValidationUtils.assertPositive(maxSpeed);
        ValidationUtils.assertPositive(acceleration);
        this.setSpeed(initialSpeed);
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
        this.arena = arena;
        activityState = new ActiveState(this);
    }

    public MobileEntity(MobileEntity other){
        super(other.getLocation());
        this.setSpeed(0);
        this.acceleration = other.getAcceleration();
        this.maxSpeed = other.getMaxSpeed();
        this.arena = other.arena;
    }

    //region IMobileEntity Implementation

    /**
     * @see IMobileEntity#move(double)
     */
    @Override
    public void move(double friction) {
        activityState.action(friction);
    }
    //endregion

    //region Setters

    /**
     * Note: speed can theoretically be negative
     * @param speed the current speed of the entity
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    //endregion

    //region Getters

    /**
     * @return the acceleration of the entity
     */
    public void setAcceleration(double acceleration){
        this.acceleration=acceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }
    //endregion
    public double getMaxSpeed(){
        return this.maxSpeed;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * this function has while loop and in the loop we had Thread sleep and after that we active the method move.
     */
    @Override
    public void run() {

        while(!finished){

            try {
                Thread.sleep(100);
                move(arena.getFriction());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * change the state of the racer
     * setter's
     * @param newState
     */
    public void setActivityState(ActivityState newState){
        activityState = newState;
    }

    /**
     * getter's
     * @return finish
     */
    public boolean finished() {
        return finished;
    }

    /**
     * getter's
     * @return state
     */
    public String getActivityState(){
        return activityState.getClass().getSimpleName();
    }

    /**
     * setter's
     * @param stop_place
     */
    public void setStop_place(Point stop_place) {
        this.stop_place = stop_place;
    }

    /**
     * getter's
     * @return
     */
    public Point getStop_place() {
        return stop_place;
    }
}
