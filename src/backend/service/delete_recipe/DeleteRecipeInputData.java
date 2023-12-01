package backend.service.delete_recipe;

public class DeleteRecipeInputData {
    private final String recipeName;

    private final String cookbookName;

    public DeleteRecipeInputData(String recipeName, String cookbookName){
        this.cookbookName = cookbookName;
        this.recipeName = recipeName;
    }

    String getRecipeName() {return recipeName;}
    String getCookbookName() {return cookbookName;}

}
