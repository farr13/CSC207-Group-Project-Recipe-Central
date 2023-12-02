package backend.service.add_recipe;

public class AddRecipeOutputData {
    private final String recipeName;

    public AddRecipeOutputData(String recipeName){this.recipeName = recipeName;}

    public String getRecipeName() {return recipeName;}
}
