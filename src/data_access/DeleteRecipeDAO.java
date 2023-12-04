package data_access;

import backend.entity.Cookbook;
import backend.entity.Recipe;
import backend.service.delete_recipe.DeleteRecipeDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DeleteRecipeDAO implements DeleteRecipeDAI {
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public DeleteRecipeDAO(String fileName){
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
            if (Objects.equals(cookbook.getName(), identifier))
                return true;
        }
        return false;
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    private Recipe[] removeRecipeLst(Recipe[] oldRecipes, Recipe removedRecipe){
        ArrayList<Recipe> modifiedRecipes = new ArrayList<Recipe>(Arrays.asList(oldRecipes));
        if (modifiedRecipes.contains(removedRecipe))
            modifiedRecipes.remove(removedRecipe);
        return modifiedRecipes.toArray(new Recipe[modifiedRecipes.size()]);
    }
    private void changeCookbook(Cookbook cookbook, Recipe recipeRemove) {
        int idx = cookbooks.indexOf(cookbook);                              //idx = -1 is not possible
        Cookbook oldCookbook = cookbooks.get(idx);
        Recipe[] recipesModified = removeRecipeLst(oldCookbook.getRecipes(), recipeRemove);
        Cookbook newCookbook = new Cookbook(oldCookbook.getName(), recipesModified);
        cookbooks.set(idx, newCookbook);
    }
    private void deleteRecipeList(Cookbook cookbook, Recipe[] recipes) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist");
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
    @Override
    public void deleteRecipe(String cookbookName, Recipe[] recipes) throws Exception {
        cookbooks = convertCookbook(readFile());
        int i = 0;
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), cookbookName)){
                deleteRecipeList(cookbook, recipes);
                i ++;
                break;
            }
        }
        if (i == 0) {
            throw new Exception("Cookbook doesn't exist");
        }
    }
}
