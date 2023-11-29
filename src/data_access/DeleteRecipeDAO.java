package data_access;

import backend.entity.Cookbook;
import backend.entity.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeleteRecipeDAO {

    private String jsonPath;
    private String json;
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public DeleteRecipeDAO(String fileName){
        jsonPath = fileName;

        file = new File(fileName);
        createFile();

        String cookbookStr;

        cookbookStr = readFile();

        this.cookbooks = convertCookbook(cookbookStr);
    }

    private String readFile(){
        return getString(file);
    }

    static String getString(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.readLine();
            while (result != null) {
                result = result + reader.readLine();
            }
            reader.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(){
        try {
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(file));
            String jsonPrint = new Gson().toJson(cookbooks);
            cookbookWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    private void changeCookbook(Cookbook cookbook, Recipe recipe){
        Cookbook oldCookbook = cookbooks.get(cookbooks.indexOf(cookbook));
        ArrayList<Recipe> recipeModified = oldCookbook.getRecipes();
        recipeModified.remove(recipe);
        Cookbook newCookbook = new Cookbook(oldCookbook.getName(), recipeModified);
        cookbooks.set(cookbooks.indexOf(cookbook), newCookbook);
    }
    public void deleteRecipe(Cookbook cookbook, Recipe recipe) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist");
        } else {
            if (cookbooks.contains(cookbook)){
                changeCookbook(cookbook, recipe);
            }
            writeFile();
        }
    }
    public void deleteRecipe(Cookbook cookbook, Recipe[] recipes) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist");
        } else {
            if (cookbooks.contains(cookbook)){
                for (Recipe recipe: recipes)
                    changeCookbook(cookbook, recipe);
            }
            writeFile();
        }
    }
    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (cookbook.getName() == identifier.trim())
                return false;
        }
        return true;
    }
    private void createFile(){
        try {
            file.createNewFile();
        } catch (IOException ignored) { }
    }

}
