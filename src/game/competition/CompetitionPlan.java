package game.competition;

import game.enums.*;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */
public interface CompetitionPlan {

    public void SetNumofraces(int numofraces);
    public void BuildArena(String name_arena, double length, SnowSurface surface, WeatherCondition condition);
    public void BuildCompetitors(int numofraces);
}
