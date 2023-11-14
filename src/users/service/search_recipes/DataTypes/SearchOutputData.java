package users.service.search_recipes.DataTypes;

import users.entity.Recipe;

import java.util.ArrayList;

public class SearchOutputData {
    private ArrayList<Recipe> recipes;

    public SearchOutputData(ArrayList<Recipe> recipes){
        this.recipes = recipes;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
}
