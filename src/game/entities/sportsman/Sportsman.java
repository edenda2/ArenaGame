package game.entities.sportsman;

import game.arena.Arena;
import game.arena.WinterArena;
import game.entities.MobileEntity;
import game.enums.Gender;
import utilities.ValidationUtils;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class Sportsman extends MobileEntity {
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW2.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private final String name;
    private final double age;
    private final Gender gender;

    /**
     * Ctor
     * @param name
     * @param age
     * @param gender
     * @param acceleration
     * @param maxSpeed
     */
    public Sportsman(String name, double age, Gender gender, double acceleration, double maxSpeed, Arena arena) {
        super(0, acceleration,maxSpeed,arena);
        ValidationUtils.assertNotNullOrEmptyString(name);
        ValidationUtils.assertPositive(age);
        ValidationUtils.assertNotNull(gender);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public Sportsman(Sportsman other){

        super(0,other.getAcceleration(), other.getMaxSpeed(), other.arena);
        this.name=other.name;
        this.age=other.age;
        this.gender=other.gender;
    }
    //region Getters & setters

    /**
     * @return sportsman's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return sportsman's age
     */
    public double getAge() {
        return age;
    }

    /**
     * @return sportsman's gender
     */
    public Gender getGender() {
        return gender;
    }
    //endregion
}
