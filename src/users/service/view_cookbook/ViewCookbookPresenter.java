package users.service.view_cookbook;

import users.entity.Cookbook;
import users.entity.Recipe;
import users.entity.Ingredient;

public class ViewCookbookPresenter implements ViewCookbookOutputBoundary {

    @Override
    public void presentSuccess(ViewCookbookOutputData outputData) {
        prepareSuccessView(outputData);
    }

    @Override
    public void presentError(String errorMessage) {
        // Enhanced error presentation logic for console application
        System.out.println("--------------------------------------------------");
        System.out.println("Error occurred while viewing the cookbook:");
        System.out.println(errorMessage);
        System.out.println("Please try again or contact support if the issue persists.");
        System.out.println("--------------------------------------------------");
    }

    public void prepareSuccessView(ViewCookbookOutputData outputData) {
        // Logic to display the cookbooks in a console view
        for (Cookbook cookbook : outputData.getCookbooks()) {
            System.out.println("Cookbook: " + cookbook.getName());
            for (Recipe recipe : cookbook.getRecipes()) {
                System.out.println(" - Recipe: " + recipe.getName());
                System.out.println("   Ingredients:");
                for (Ingredient ingredient : recipe.getIngredients()) {
                    System.out.println("    * " + ingredient); // Assuming Ingredient has a meaningful toString() method
                }
                System.out.println("   Instructions URL: " + recipe.getInstructionsURL());
            }
        }
    }
}
