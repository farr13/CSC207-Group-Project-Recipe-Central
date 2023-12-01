package backend.service.delete_recipe;

public class DeleteRecipeController {

    final DeleteRecipeInputBoundary deleteRecipeInteractor;

    public DeleteRecipeController(DeleteRecipeInputBoundary deleteRecipeInteractor){
        this.deleteRecipeInteractor = deleteRecipeInteractor;
    }

    public void execute(String cookbookName, String recipeName) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(cookbookName, recipeName);

        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
