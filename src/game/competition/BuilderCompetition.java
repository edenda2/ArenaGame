package game.competition;

import game.arena.Arena;
import game.arena.ArenaFactory;
import game.entities.sportsman.Skier;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;

import java.util.ArrayList;

import static game.enums.Discipline.SLALOM;
import static game.enums.Gender.FEMALE;
import static game.enums.League.ADULT;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public class BuilderCompetition implements CompetitionPlan {


    WinterCompetition wintercompetition;
    Arena arena;
    ArrayList<Competitor> competitors_races=new ArrayList<>();
    int numofraces;


    /**
     * tis function build default competition by using Builder DP, first we build arena and the the competitors
     * @param num_of_races num of racers that play in the competition
     */
    public BuilderCompetition(int num_of_races){
        BuildArena("Winter",700,SnowSurface.CRUD,WeatherCondition.CLOUDY);
        this.SetNumofraces(num_of_races);

        wintercompetition=new WinterCompetition(arena,num_of_races,SLALOM,ADULT,FEMALE);
        BuildCompetitors(numofraces);
    }

    /**
     * setter's
     * @param numofraces  num of racers that play in the competition
     */
    @Override
    public void SetNumofraces(int numofraces) {
        this.numofraces=numofraces;
    }

    /**
     * build default arena
     * @param name_arena type of the arena
     * @param length len of the arena
     * @param surface snow surface of the arena
     * @param condition weather condition of the arena
     */
    @Override
    public void BuildArena(String name_arena, double length, SnowSurface surface, WeatherCondition condition){

        ArenaFactory arena_factory=new ArenaFactory();
        try {
            arena=arena_factory.getArena(name_arena,length,surface,condition);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * getter's
     * @return arena
     */
    public Arena getArena() {
        return arena;
    }

    /**
     * build array of competitors by using prototype(clone()).
     * @param numofraces number of racer that play in the competition
     */
    @Override
    public void BuildCompetitors(int numofraces) {
        Skier skier=new Skier("Eden",25,FEMALE, 12, 60,SLALOM , arena,"Black");
        competitors_races.add(skier);
        for(int i=1;i<numofraces;i++){

            try {
            	String h=skier.getColor();
                Skier ski=(Skier)skier.clone(h);
                competitors_races.add(ski);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * getter's
     * @return array of competitors
     */
    public ArrayList<Competitor> getCompetitors_races() {
        return competitors_races;
    }

    /**
     * getter's
     * @return competition
     */
    public WinterCompetition getCompetition(){
        return wintercompetition;
    }
}
