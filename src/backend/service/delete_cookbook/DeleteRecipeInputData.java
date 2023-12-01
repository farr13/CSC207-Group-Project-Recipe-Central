package backend.service.delete_cookbook;

public class DeleteRecipeInputData {
    private final String recipeName;

    public DeleteRecipeInputData(String recipeName){
        this.recipeName = recipeName;
    }

    String getRecipeName() {return recipeName;}

}
