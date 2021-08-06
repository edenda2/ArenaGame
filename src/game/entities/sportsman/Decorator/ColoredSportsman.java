package game.entities.sportsman.Decorator;

import game.entities.sportsman.WinterSportsman;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

/**
 * Dcorator DP
 */
public class ColoredSportsman extends WSDecorator {

    private String color;

    /**
     * c'tor of the Decorator DP
     * @param iWinterSportsman the competitor
     * @param color color of the competitor's image
     */
    public ColoredSportsman(IWinterSportsman iWinterSportsman, String color){
        super(iWinterSportsman);
        this.color=color;
    }

    /**
     * setter's
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * change the color of the competitor by using Decorator DP
     * @param object the competitor
     * @return competitor
     */
    @Override
    public IWinterSportsman makeIWinterSportsman(IWinterSportsman object) {
        WinterSportsman sportsman=(WinterSportsman)object;
        sportsman.setColor(this.getColor());
        return object;
    }
}
