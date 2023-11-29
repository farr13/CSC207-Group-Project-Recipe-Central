package users.service.delete_cookbook;

public class DeleteRecipeController {

    final DeleteRecipeInputBoundary deleteRecipeInteractor;

    public DeleteRecipeController(DeleteRecipeInputBoundary deleteRecipeInteractor){
        this.deleteRecipeInteractor = deleteRecipeInteractor;
    }

    public void execute(String recipeName) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(recipeName);

        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
