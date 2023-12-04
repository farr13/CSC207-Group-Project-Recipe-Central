package backend.service.go_add_recipe;

import backend.entity.Cookbook;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class GoAddRecipeInteractor implements GoAddRecipeInputBoundary {
    private final GoAddRecipeOutputBoundary goAddCookbookPresenter;
    private final SeeListCookbooksDAI seeListCookbooksDAO;
    public GoAddRecipeInteractor(GoAddRecipeOutputBoundary goAddCookbookPresenter, SeeListCookbooksDAI seeListCookbooksDAO) {
        this.goAddCookbookPresenter = goAddCookbookPresenter;
        this.seeListCookbooksDAO = seeListCookbooksDAO;
    }
    private String[] getCookbookNames(Cookbook[] cookbooks){
        ArrayList<String> cookbookNames = new ArrayList<String>();
        for (Cookbook cookbook: cookbooks)
            cookbookNames.add(cookbook.getName());
        return cookbookNames.toArray(new String[0]);
    }

    @Override
    public void execute(GoAddRecipeInputData goAddRecipeInputData) {
        try {
            String[] cookbookNames = getCookbookNames(seeListCookbooksDAO.viewCookbooks());
            Triplet[] recipes = goAddRecipeInputData.getRecipes();
            if (recipes.length != 0)
                goAddCookbookPresenter.prepareSuccessView(new GoAddRecipeOutputData(recipes, cookbookNames));
            else
                throw new Exception();
        } catch (Exception e) {
            goAddCookbookPresenter.prepareFailView("Cannot add recipes.");
        }
    }
}
