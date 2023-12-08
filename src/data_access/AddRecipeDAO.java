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
    private ArrayList<Cookbook> cookbooks;
    private final File file;

    public AddRecipeDAO(String fileName){
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
    private boolean notExistByTitle(String identifier) {
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

    private Cookbook findCookbook(String cookbookName) throws Exception {
        cookbooks = convertCookbook(readFile());
        Cookbook savecookbook = null;
        if (notExistByTitle(cookbookName)) {
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

    private Cookbook[] findCookbooks(String[] cookbookNames) throws Exception {
        ArrayList<Cookbook> result = new ArrayList<Cookbook>();
        for (String cookbookName: cookbookNames){
            result.add(findCookbook(cookbookName));
        }
        return result.toArray(new Cookbook[0]);
    }
    private Recipe[] addRecipeLst(Recipe[] oldRecipes, Recipe addRecipe){
        ArrayList<Recipe> modifiedRecipes = new ArrayList<Recipe>(Arrays.asList(oldRecipes));
        if (!modifiedRecipes.contains(addRecipe))
            modifiedRecipes.add(addRecipe);
        return modifiedRecipes.toArray(new Recipe[modifiedRecipes.size()]);
    }
    private void changeCookbook(Cookbook cookbook, Recipe recipeAdd) throws Exception {
        Recipe[] recipesModified = addRecipeLst(cookbook.getRecipes(), recipeAdd);
        Cookbook newCookbook = new Cookbook(cookbook.getName(), recipesModified);
        int idx = cookbooks.indexOf(findCookbook(cookbook.getName()));
        cookbooks.set(idx, newCookbook);
    }

    private void addRecipeCookbookObj(Cookbook cookbook, Recipe recipe) throws Exception {
        if (notExistByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist.");
        } else {
            changeCookbook(cookbook, recipe);
            writeFile();
        }
    }

    @Override
    public void addRecipe(String[] cookbookNames, Recipe[] recipes) throws Exception {
        for (String cookbookName: cookbookNames){
            for (Recipe addRecipe: recipes){
                Cookbook modifyCookbook = findCookbook(cookbookName);
                if (!Arrays.asList(modifyCookbook.getRecipes()).contains(addRecipe))
                    addRecipeCookbookObj(modifyCookbook, addRecipe);
                cookbooks = convertCookbook(readFile());
            }
        }
    }
}
