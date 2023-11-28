package data_access;

import app.NotImplementedException;
import backend.entity.Cookbook;
import backend.entity.Recipe;
import backend.entity.Cookbook;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class AddRecipeDAO { // implements AddRecipeInterface {
    String jsonPath = "cookbooks.json";
    String json;
    public void AddRecipe (Recipe recipe, Cookbook cookbook) throws Exception {
        Cookbook tempbook = get(cookbook.getName());
        assert tempbook != null;
        tempbook.getRecipes().add(recipe);
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO();
        deleteCookbookDAO.DeleteCookbook(cookbook);
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO();
        addCookbookDAO.AddCookbook(tempbook);
    }

    private Cookbook[] readFile(){
        try (FileReader reader = new FileReader(jsonPath)) {
            return new Gson().fromJson(reader, Cookbook[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Cookbook get(String findName) {
        Cookbook[] cookbooks = readFile();
        assert cookbooks != null;
        for (Cookbook cookbook : cookbooks) {
            String name = cookbook.getName();
            if (name.equals(findName))
                return cookbook;
        }
        return null;
    }
}
