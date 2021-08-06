package game.entities.sportsman.Decorator;

import game.entities.sportsman.WinterSportsman;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class SpeedySportsman extends WSDecorator {
    private double acceleration;

    /**
     *
     * @param iWinterSportsman the competitor
     * @param acceleration the acceleration theat we want to add the acceleration's competitor
     */
    public SpeedySportsman(IWinterSportsman iWinterSportsman, double acceleration){
        super(iWinterSportsman);
        this.acceleration=acceleration;
    }

    /**
     * getter's
     * @return acceleration
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * add to the acceleration's competitor
     * @param object the competitor
     * @return competitor
     */
    @Override
    public IWinterSportsman makeIWinterSportsman(IWinterSportsman object) {
        WinterSportsman sportsman=(WinterSportsman)object;
        sportsman.setAcceleration(sportsman.getAcceleration()+this.getAcceleration());
        return sportsman;
    }
}
