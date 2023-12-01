package backend.service.delete_cookbook;

public class DeleteRecipeInputData {
    private final String cookbookName;
    private final String recipeName;

    public DeleteRecipeInputData(String cookbookName, String recipeName){
        this.cookbookName = cookbookName;
        this.recipeName = recipeName;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    String getRecipeName() {return recipeName;}

}
