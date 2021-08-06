package game.entities.ActivityStates;

import game.entities.MobileEntity;
import utilities.Point;

import java.util.Random;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class InjuredState  implements ActivityState {
    private final MobileEntity mobileEntity;

    /**
     * c'tor
     * @param mobileEntity
     */
    public InjuredState(MobileEntity mobileEntity) {
            this.mobileEntity = mobileEntity;
    }

    /**
     *  Moves the competitor and checks if he come to the place that he needs to be faild. if he come to the place that he needs to be faild we set his state to faild
     * @param friction the friction of the competitor
     */
    @Override
    public void action(double friction ) {


        mobileEntity.setSpeed(Math.min(mobileEntity.getMaxSpeed(), mobileEntity.getSpeed() + mobileEntity.getAcceleration()* (1-friction)));
        Point newLocation = mobileEntity.getLocation().offset(0, mobileEntity.getSpeed(),mobileEntity.getArena().getLength());
        mobileEntity.setLocation(newLocation);
        if (mobileEntity.getStop_place().getY()<=newLocation.getY()){
            mobileEntity.setActivityState(new FailedState(mobileEntity));
        }
    }
}
