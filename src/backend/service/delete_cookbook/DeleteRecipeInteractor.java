package backend.service.delete_cookbook;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {

    final DeleteRecipeDeleteDAI deleteRecipeDAO;

    final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDeleteDAI deleteRecipeDAO,
                                  DeleteRecipeOutputBoundary deleteRecipeOutputBoundary){
        this.deleteRecipeDAO = deleteRecipeDAO;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }

    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData){
        try {
            deleteRecipeDAO.deleteRecipe(deleteRecipeInputData.getCookbookName(), deleteRecipeInputData.getRecipeName());
            DeleteRecipeOutputData deleteRecipeOutputData =
                    new DeleteRecipeOutputData(deleteRecipeInputData.getRecipeName());

            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);
        } catch (Exception e) {
            deleteRecipePresenter.prepareFailView();
        }
    }
}
