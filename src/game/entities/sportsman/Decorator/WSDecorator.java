package game.entities.sportsman.Decorator;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public abstract class WSDecorator implements IWinterSportsman {

    private IWinterSportsman iwintersportsman;

    /**
     * c'tor
     * @param iWinterSportsman the competitor
     */
    public WSDecorator(IWinterSportsman iWinterSportsman){

        this.iwintersportsman=iWinterSportsman;
    }

    /**
     * conecting between WinterSportsman to this class
     * @param object competitor
     * @return competitor
     */
    @Override
    public IWinterSportsman makeIWinterSportsman(IWinterSportsman object) {
        return iwintersportsman.makeIWinterSportsman(object);
    }

}
