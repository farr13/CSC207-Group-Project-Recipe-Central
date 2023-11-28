package users.service.view_cookbook;

import users.entity.Cookbook;
import users.entity.Recipe;
import users.entity.Ingredient;
import data_access.AddCookbookDAO;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {
    private AddCookbookDAO addCookbookDAO; // Dependency on AddCookbookDAO

    public ViewCookbookInteractor(AddCookbookDAO addCookbookDAO) {
        this.addCookbookDAO = addCookbookDAO;
    }

    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        String cookbookName = viewCookbookInputData.getCookbookName();
        try {
            Cookbook cookbook = addCookbookDAO.get(cookbookName);
            if (cookbook == null) {
                System.out.println("Cookbook not found: " + cookbookName);
                return;
            }
            displayCookbook(cookbook);
        } catch (Exception e) {
            // Handle exceptions, such as issues with file reading
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayCookbook(Cookbook cookbook) {
        System.out.println("Cookbook: " + cookbook.getName());
        System.out.println("Recipes:");
        for (Recipe recipe : cookbook.getRecipes()) {
            System.out.println(" - " + recipe.getName());
            System.out.println("   Ingredients:");
            for (Ingredient ingredient : recipe.getIngredients()) {
                System.out.println("    * " + ingredient); // Assuming Ingredient class has a meaningful toString()
            }
            System.out.println("   Instructions URL: " + recipe.getInstructionsURL());
        }
    }
}
