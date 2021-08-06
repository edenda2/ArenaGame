package game.entities.sportsman;

import game.arena.Arena;
import game.arena.WinterArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.SnowSurface;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class Snowboarder extends WinterSportsman{
    /**
     * Ctor
     * @param name
     * @param age
     * @param gender
     * @param acceleration
     * @param maxSpeed
     * @param discipline
     */
    public Snowboarder(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline, Arena arena,String color) {
        super(name, age, gender, acceleration, maxSpeed, discipline, arena,color);
    }

    /**
     * copy of the competitor
     * @return copy of the competitor
     * @throws CloneNotSupportedException
     */
    public Snowboarder clone() throws CloneNotSupportedException {
        return (Snowboarder) super.clone();
    }
}
