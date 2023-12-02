package backend.service.add_recipe;

public class AddRecipeInputData {
    private final String recipeName;
    private final String cookbookName;
    private final String ingredientDesc;
    private final String instructions;
    public AddRecipeInputData(String recipeName, String cookbookName, String ingredientDesc, String instructions){
        this.recipeName = recipeName;
        this.cookbookName = cookbookName;
        this.ingredientDesc = ingredientDesc;
        this.instructions = instructions;
    }

    String getRecipeName(){return recipeName;}
    String getCookbookName(){return cookbookName;}

    String getInstructions(){return instructions;}

    String getIngredientDesc(){return ingredientDesc;}
}
