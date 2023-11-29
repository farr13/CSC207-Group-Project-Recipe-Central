package users.service.delete_recipe_from_cookbook;

public class DeleteRecipeInputData {
    private final String cookbookName;
    private final String recipeName;

    public DeleteRecipeInputData(String cookbookName, String recipeName) {
        this.cookbookName = cookbookName;
        this.recipeName = recipeName;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public String getRecipeName() {
        return recipeName;
    }
}
