package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

/**
 * this class is Factory DP
 */
public class ArenaFactory {

    private ClassLoader are;
    private Class ar;
    private Constructor con;
    private Arena arena;
    String namearena;

    /**
     * we build object with dynamic class because we dont know which arena the user will choose.
     * @param arenaType the type of the arena
     * @param length the length of the arena
     * @param surface snow surface of the arena
     * @param condition weather condition of the arena
     * @return object of the type Arena, created by dynamic class
     * @throws ClassNotFoundException
     */
    public Arena getArena(String arenaType, double length, SnowSurface surface, WeatherCondition condition) throws ClassNotFoundException {


        try {

            switch (arenaType) {
                case "Winter":
                    {
                    namearena = "game.arena.WinterArena";
                    break;

                }
                case "Summer": {
                    namearena = "game.arena.SummerArena";
                    break;
                }
            }
            this.are = ClassLoader.getSystemClassLoader();
            ar = are.loadClass(namearena);
            this.con = ar.getConstructor(double.class, SnowSurface.class, WeatherCondition.class);
            return (Arena) con.newInstance(length, surface, condition);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return arena;
    }

}
