package game.entities.sportsman;

import Gui.gui_panel;
import game.arena.Arena;
import game.competition.Competitor;
import game.entities.ActivityStates.ActiveState;
import game.entities.sportsman.Decorator.IWinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;
import utilities.ValidationUtils;

/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

public class WinterSportsman extends Sportsman implements Competitor , Cloneable, IWinterSportsman {
    /**
     * Important note:
     * Those fields (and more in this project) are currently final due to them not changing in HW2.
     * If in future tasks you will need to change them you could remove the final modifier and add a setter.
     */
    private final Discipline discipline;
    private int NumberCount;
    private String color;
    /**
     * Ctor
     * @param name
     * @param age
     * @param gender
     * @param acceleration
     * @param maxSpeed
     * @param discipline
     */
    public WinterSportsman(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline, Arena arena, String color) {
        super(name, age, gender, acceleration, maxSpeed,arena);
        gui_panel.Identif_number++;
        this.setNumberCount(gui_panel.Identif_number);
        this.color=color;
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }

    /**
     * copy c'tor
     * @param other
     */
    public WinterSportsman(WinterSportsman other){
        super(other.getName(),other.getAge(),other.getGender(),other.getAcceleration(),other.getMaxSpeed(), other.arena);
        this.discipline=other.getDiscipline();
    }

    @Override
    public void initRace() {
        this.setLocation(new Point(this.getLocation().getX(),0));
    }

//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + " " + getName();
//    }

    //region Getters & setters

    /**
     * @return winter sportsman's discipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public double getAcceleration() {
        return super.getAcceleration()+ League.calcAccelerationBonus(this.getAge());
    }

    public void setAcceleration(double acceleration){
        super.setAcceleration(acceleration);
    }

    /**
     * getter's
     * @return color of the racer
     */
    public String getColor() {
        return color;
    }

    /**
     * setter's
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * setter's
     * @param numberCount
     */
    public void setNumberCount(int numberCount) {
        NumberCount = numberCount;
    }

    /**
     * getter's
     * @return id of the competitor
     */
    public int getNumberCount() {
        return NumberCount;
    }

    /**
     * copy of the competitor by using Prototype DP
     * @return copy of the competitor
     * @throws CloneNotSupportedException
     */
    public WinterSportsman clone(String color) throws CloneNotSupportedException {

        WinterSportsman copy= (WinterSportsman) super.clone();
        gui_panel.Identif_number++;
        copy.setNumberCount(gui_panel.Identif_number);
        copy.setActivityState(new ActiveState(copy));
        copy.setFinished(false);
        copy.setColor(color);
        return copy;
    }


    @Override
    public IWinterSportsman makeIWinterSportsman(IWinterSportsman object) {
        return object.makeIWinterSportsman(this);
    }
}
