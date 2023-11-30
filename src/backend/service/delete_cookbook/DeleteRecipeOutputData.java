package backend.service.delete_cookbook;

public class DeleteRecipeOutputData {
    private final String recipeName;

    public DeleteRecipeOutputData(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getRecipeName() {return recipeName;}
}
