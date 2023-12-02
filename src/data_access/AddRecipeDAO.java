package data_access;

import backend.entity.Cookbook;
import backend.entity.Recipe;
import backend.service.add_recipe.AddRecipeDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AddRecipeDAO implements AddRecipeDAI {
    private String jsonPath;
    private String json;
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public AddRecipeDAO(String fileName){
        jsonPath = fileName;
        file = new File(fileName);

        if (!file.exists())
            createFile();

        cookbooks = convertCookbook(readFile());
    }
    private void createFile(){
        try {
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(file.getName()));
            cookbookWriter.write("[]");
            cookbookWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getName()))) {
            String result = "";
            String nextLine = reader.readLine();
            while (nextLine != null) {
                result = result + nextLine;
                nextLine = reader.readLine();
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(){
        try {
            PrintWriter cookbookWriter = new PrintWriter(file);
            cookbookWriter.print("");
            cookbookWriter.print(new Gson().toJson(cookbooks));
            cookbookWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), identifier.trim()))
                return false;
        }
        return true;
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    private Recipe[] addRecipeLst(Recipe[] oldRecipes, Recipe addRecipe){
        ArrayList<Recipe> modifiedRecipes = new ArrayList<Recipe>(Arrays.asList(oldRecipes));
        if (!modifiedRecipes.contains(addRecipe))
            modifiedRecipes.add(addRecipe);
        return modifiedRecipes.toArray(new Recipe[modifiedRecipes.size()]);
    }
    private void changeCookbook(Cookbook cookbook, Recipe recipeRemove){
        int idx = cookbooks.indexOf(cookbook);                              //idx = -1 is not possible
        Cookbook oldCookbook = cookbooks.get(idx);
        Recipe[] recipesModified = addRecipeLst(oldCookbook.getRecipes(), recipeRemove);
        Cookbook newCookbook = new Cookbook(oldCookbook.getName(), recipesModified);
        cookbooks.set(idx, newCookbook);
    }
    @Override
    public Cookbook getCookbook(String cookbookName) throws Exception {
        Cookbook savecookbook = null;
        if (existByTitle(cookbookName)) {
            throw new Exception("Cookbook doesn't exist.");
        } else {
            for (Cookbook cookbook: cookbooks){
                if(cookbook.getName().equals(cookbookName)){
                    savecookbook = cookbook;
                }
            }
        }
        return savecookbook;
    }

    @Override
    public void addRecipe(Cookbook cookbook, Recipe recipe) throws Exception {
        if (existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist.");
        } else {
            if (cookbooks.contains(cookbook)){
                changeCookbook(cookbook, recipe);
            }
            writeFile();
        }
    }
    public void addRecipe(Cookbook cookbook, Recipe[] recipes) throws Exception {
        if (existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist.");
        } else {
            if (cookbooks.contains(cookbook)){
                for (Recipe recipe: recipes){
                    int idx = cookbooks.indexOf(cookbook);
                    changeCookbook(cookbook, recipe);
                    cookbook = cookbooks.get(idx);
                }
            }
            writeFile();
        }
    }
}
