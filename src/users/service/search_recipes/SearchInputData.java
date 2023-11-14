package users.service.search_recipes;

import java.util.ArrayList;

public class SearchInputData {
    private ArrayList<String> ingredients, mealType, diet, health;

    public SearchInputData(ArrayList<String> ingredients, ArrayList<String> mealType, ArrayList<String> diet, ArrayList<String> health){
        this.ingredients = ingredients;
        this.mealType = mealType;
        this.diet = diet;
        this.health = health;
    }

    public ArrayList<String> getIngredients() { return ingredients; }

    public ArrayList<String> getMealType() { return mealType; }

    public ArrayList<String> getDiet() { return diet; }

    public ArrayList<String> getHealth() { return health; }
}
