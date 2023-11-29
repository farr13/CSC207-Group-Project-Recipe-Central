package data_access;

import app.NotImplementedException;
import backend.entity.Cookbook;
import backend.entity.Recipe;
import backend.entity.Cookbook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddRecipeDAO {
    private String jsonPath;
    private String json;
    private ArrayList<Cookbook> cookbooks;
    private File cookbookFile;

    public void AddCookbookDAO(String fileName){
        jsonPath = fileName;

        cookbookFile = new File(fileName);
        createFile();

        String cookbookStr;

        cookbookStr = readFile();

        this.cookbooks = convertCookbook(cookbookStr);
    }

    private String readFile(){
        return getString(cookbookFile);
    }

    static String getString(File cookbookFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cookbookFile))) {
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
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(cookbookFile));
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
        recipeModified.add(recipe);
        Cookbook newCookbook = new Cookbook(oldCookbook.getName(), recipeModified);
        cookbooks.set(cookbooks.indexOf(cookbook), newCookbook);
    }
    public void addRecipe(Cookbook cookbook, Recipe recipe) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist");
        } else {
            if (cookbooks.contains(cookbook)){
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
            cookbookFile.createNewFile();
        } catch (IOException ignored) { }
    }
}
