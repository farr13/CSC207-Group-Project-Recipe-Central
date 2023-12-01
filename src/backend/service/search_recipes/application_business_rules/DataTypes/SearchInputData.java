package backend.service.search_recipes.application_business_rules.DataTypes;

public class SearchInputData {
    private String[] ingredients, mealType, diet, health;

    public SearchInputData(String[] ingredients, String[] mealType, String[] diet, String[] health){
        this.ingredients = ingredients;
        this.mealType = mealType;
        this.diet = diet;
        this.health = health;
    }

    public String[] getIngredients() { return ingredients; }

    public String[] getMealType() { return mealType; }

    public String[] getDiet() { return diet; }

    public String[] getHealth() { return health; }
}
