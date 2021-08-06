package game.entities.ActivityStates;

import game.entities.MobileEntity;
import utilities.Point;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class ActiveState implements ActivityState {

    private final MobileEntity mobileEntity;

    /**
     * c'tor
     * @param mobileEntity
     */
    public ActiveState(MobileEntity mobileEntity) {
        this.mobileEntity = mobileEntity;
    }

    /**
     * Moves the competitor and checks if he has crossed the finish line. if he has crossed the finish line we set his state to finish
     * @param friction the friction of the competitor
     */
    @Override
    public void action(double friction ) {
        mobileEntity.setSpeed(Math.min(mobileEntity.getMaxSpeed(), mobileEntity.getSpeed() + mobileEntity.getAcceleration()* (1-friction)));
        Point newLocation = mobileEntity.getLocation().offset(0, mobileEntity.getSpeed(),mobileEntity.getArena().getLength());
        mobileEntity.setLocation(newLocation);

         if(mobileEntity.getArena().isFinished(mobileEntity)){
             mobileEntity.setActivityState(new FinishedState(mobileEntity));
        }
    }
}
