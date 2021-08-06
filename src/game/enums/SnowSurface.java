package game.enums;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public enum SnowSurface {
    POWDER(0.7),
    CRUD(0.5),
    ICE(0.3);

    public final double friction;

    SnowSurface(double friction){
        this.friction = friction;
    }

    public double getFriction(){
        return friction;
    }
}
