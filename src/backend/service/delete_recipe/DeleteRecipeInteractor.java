package backend.service.delete_recipe;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {
    private final DeleteRecipeDAI deleteRecipeDAO;
    private final ViewRecipeDAI viewRecipeDAO;
    private final DeleteRecipeOutputBoundary deleteRecipePresenter;

    public DeleteRecipeInteractor(DeleteRecipeDAI deleteRecipeDAO, ViewRecipeDAI viewRecipeDAO,
                                  DeleteRecipeOutputBoundary deleteRecipeOutputBoundary){
        this.deleteRecipeDAO = deleteRecipeDAO;
        this.viewRecipeDAO = viewRecipeDAO;
        this.deleteRecipePresenter = deleteRecipeOutputBoundary;
    }
    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData){
        try {
            deleteRecipeDAO.deleteRecipe(deleteRecipeInputData.getCookbookName(), deleteRecipeInputData.getRecipes());
            DeleteRecipeOutputData deleteRecipeOutputData =
                    new DeleteRecipeOutputData(viewRecipeDAO.viewRecipes(deleteRecipeInputData.getCookbookName()));

            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);
        } catch (Exception e) {
            deleteRecipePresenter.prepareFailView("Could not delete cookbook.");
        }
    }
}
