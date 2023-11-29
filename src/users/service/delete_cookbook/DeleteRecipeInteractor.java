package users.service.delete_cookbook;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary{

    final DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject;

    final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDataAccessInterface deleteRecipeDataAccessObject,
                                  DeleteRecipeOutputBoundary deleteRecipeOutputBoundary){
        this.deleteRecipeDataAccessObject = deleteRecipeDataAccessObject;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }

    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData){
        deleteRecipeDataAccessObject.removeRecipe(deleteRecipeInputData.getRecipeName());
        DeleteRecipeOutputData deleteRecipeOutputData =
                new DeleteRecipeOutputData(deleteRecipeInputData.getRecipeName());

        deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);
    }
}
