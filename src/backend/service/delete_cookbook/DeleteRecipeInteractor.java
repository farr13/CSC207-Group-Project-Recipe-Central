package backend.service.delete_cookbook;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {

    final DeleteRecipeDAI deleteRecipeDAO;

    final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDAI deleteRecipeDAO,
                                  DeleteRecipeOutputBoundary deleteRecipeOutputBoundary){
        this.deleteRecipeDAO = deleteRecipeDAO;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }

    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData){
        try {
            deleteRecipeDAO.removeRecipe(deleteRecipeInputData.getRecipeName());
            DeleteRecipeOutputData deleteRecipeOutputData =
                    new DeleteRecipeOutputData(deleteRecipeInputData.getRecipeName());

            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);
        } catch (Exception e) {
            deleteRecipePresenter.prepareFailView();
        }
    }
}
