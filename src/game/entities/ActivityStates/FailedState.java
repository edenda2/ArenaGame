package game.entities.ActivityStates;


import game.entities.MobileEntity;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class FailedState  implements ActivityState {
    private final MobileEntity mobileEntity;

    /**
     * c'tor
     * @param mobileEntity
     */
    public FailedState(MobileEntity mobileEntity) {
        this.mobileEntity = mobileEntity;
    }

    /**
     * change his set the parameters in the competitor to finished=true
     * @param friction the friction of the competitor
     */
    @Override
    public void action(double friction ) {
        mobileEntity.setFinished(true);

    }
}
