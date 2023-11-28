package app;

import users.entity.Cookbook;
import data_access.AddCookbookDAO;
import java.io.IOException;

public class CookbookViewer {

    private final AddCookbookDAO cookbookDAO;

    public CookbookViewer(AddCookbookDAO cookbookDAO) {
        this.cookbookDAO = cookbookDAO;
    }

    public void displayCookbook(String cookbookName) {
        try {
            Cookbook cookbook = cookbookDAO.getCookbook(cookbookName);
            System.out.println("Cookbook: " + cookbook.getName());
            cookbook.getRecipes().forEach(recipe ->
                    System.out.println("Recipe: " + recipe.getName()));
        } catch (IOException e) {
            System.out.println("Error displaying cookbook: " + e.getMessage());
        }
    }
}
