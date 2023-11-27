package app;

import backend.entity.Cookbook;
import backend.entity.Recipe;
import data_access.*;

import java.io.IOException;

public class CookbookController {

    private final AddCookbookDAO addCookbookDAO;
    private final DeleteCookbookDAO deleteCookbookDAO;
    private final AddRecipeDAO addRecipeDAO;
    private final DeleteRecipeDAO deleteRecipeDAO;

    public CookbookController(AddCookbookDAO addCookbookDAO, DeleteCookbookDAO deleteCookbookDAO,
                              AddRecipeDAO addRecipeDAO, DeleteRecipeDAO deleteRecipeDAO) {
        this.addCookbookDAO = addCookbookDAO;
        this.deleteCookbookDAO = deleteCookbookDAO;
        this.addRecipeDAO = addRecipeDAO;
        this.deleteRecipeDAO = deleteRecipeDAO;
    }

    public void addCookbook(Cookbook cookbook) {
        try {
            addCookbookDAO.addCookbook(cookbook);
        } catch (IOException e) {
            System.out.println("Error adding cookbook: " + e.getMessage());
        }
    }

    public void deleteCookbook(Cookbook cookbook) {
        try {
            deleteCookbookDAO.deleteCookbook(cookbook);
        } catch (IOException e) {
            System.out.println("Error deleting cookbook: " + e.getMessage());
        }
    }

    public void addRecipe(Recipe recipe, Cookbook cookbook) {
        try {
            addRecipeDAO.addRecipe(recipe, cookbook.getName());
        } catch (IOException e) {
            System.out.println("Error adding recipe: " + e.getMessage());
        }
    }

    public void deleteRecipe(Recipe recipe, Cookbook cookbook) {
        try {
            deleteRecipeDAO.deleteRecipe(recipe, cookbook);
        } catch (IOException e) {
            System.out.println("Error deleting recipe: " + e.getMessage());
        }
    }
}
