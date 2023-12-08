package backend.service.delete_recipe;

import backend.adapters.RecipesToTriplets;
import backend.adapters.TripletsToRecipes;
import view.recipe_objects.Triplet;

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
            deleteRecipeDAO.deleteRecipe(deleteRecipeInputData.getCookbookName(),
                    TripletsToRecipes.convert(deleteRecipeInputData.getRecipes()));
            Triplet[] recipes = RecipesToTriplets.convert(viewRecipeDAO.viewRecipes(deleteRecipeInputData.getCookbookName()));
            DeleteRecipeOutputData deleteRecipeOutputData = new DeleteRecipeOutputData(recipes);

            deleteRecipePresenter.prepareSuccessView(deleteRecipeOutputData);
        } catch (Exception e) {
            deleteRecipePresenter.prepareFailView(); //Could not delete cookbook
        }
    }
}
