package backend.service.view_cookbook;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {

    final ViewCookbookDAI viewCookbookDAO;

    final ViewCookbookOutputBoundary viewCookbookPresenter;

    public ViewCookbookInteractor(ViewCookbookDAI viewCookbookDAO,
                                  ViewCookbookOutputBoundary viewCookbookPresenter) {
        this.viewCookbookDAO = viewCookbookDAO;
        this.viewCookbookPresenter = viewCookbookPresenter;
    }

    private Triplet[] convertTriplet(Recipe[] recipes){
        ArrayList<Triplet> triplets = new ArrayList<Triplet>();
        for (Recipe recipe: recipes){
            String name = recipe.getName();
            String link = recipe.getInstructions();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (Ingredient ingredient: recipe.getIngredients())
                arrayList.add(ingredient.getTextDescription());
            triplets.add(new Triplet(name, link, arrayList.toArray(new String[0])));
        }
        return triplets.toArray(new Triplet[0]);
    }
    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        ViewCookbookOutputData viewCookbookOutputData;
        try {
            Cookbook cookbook = viewCookbookDAO.viewCookbook(viewCookbookInputData.getName());
            viewCookbookOutputData = new ViewCookbookOutputData(cookbook.getName(), convertTriplet(cookbook.getRecipes()));

            viewCookbookPresenter.prepareSuccessView(viewCookbookOutputData);
        } catch (Exception e) {
            viewCookbookPresenter.prepareFailView("Could not retrieve cookbooks.");
        }
    }
}
