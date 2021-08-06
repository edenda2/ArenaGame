package game.entities.ActivityStates;


import game.entities.MobileEntity;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class FinishedState  implements ActivityState {
    private final MobileEntity mobileEntity;

    /**
     * c'tor
     * @param mobileEntity
     */
    public FinishedState(MobileEntity mobileEntity) {
        this.mobileEntity = mobileEntity;
    }

    /**
     * set the parameter finish to true and notify the gui
     * @param friction the friction of the competitor
     */
    @Override
    public void action(double friction ) {
        mobileEntity.setFinished(true);
        mobileEntity.notifyGUIObservers();

    }
}
