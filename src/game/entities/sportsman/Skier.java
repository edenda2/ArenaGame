package game.entities.sportsman;

import game.arena.Arena;
import game.arena.WinterArena;
import game.enums.Discipline;
import game.enums.Gender;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class Skier extends WinterSportsman{
    /**
     * Ctor
     * @param name
     * @param age
     * @param gender
     * @param acceleration
     * @param maxSpeed
     * @param discipline
     */
    public Skier(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline, Arena arena,String color) {
        super(name, age, gender, acceleration, maxSpeed, discipline, arena,color);
    }

    /**
     * prototype DP
     * @return copy of the competitor
     * @throws CloneNotSupportedException
     */
    public Skier clone() throws CloneNotSupportedException {
        return (Skier) super.clone();
    }
}
