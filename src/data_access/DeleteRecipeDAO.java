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
    private final File file;

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
    @Override
    public void deleteRecipe(String cookbookName, String recipeName) throws Exception {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), cookbookName)){
                for (Recipe recipe: cookbook.getRecipes()){
                    if (Objects.equals(recipe.getName(), recipeName)){
                        deleteRecipeObject(cookbook, recipe);
                        break;
                    }
                }
                break;
            }
        }
    }
    public void deleteRecipeObject(Cookbook cookbook, Recipe recipe) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook doesn't exist");
        } else {
            if (cookbooks.contains(cookbook)){
                changeCookbook(cookbook, recipe);
            }
            writeFile();
        }
    }
    public void deleteRecipeList(Cookbook cookbook, Recipe[] recipes) throws Exception {
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

// ** Alternate Code, keeping just in case implementation fails
//    @Override
//    public void removeRecipe(String cookbookName, String recipeName) throws Exception {
//        Recipe recipe = null;
//        for (Cookbook cookbook: cookbooks){
//            if (Objects.equals(cookbook.getName(), cookbookName)){
//                recipe = getRecipe(cookbook.getRecipes(), recipeName);
//                changeCookbook(cookbook, recipe);
//            }
//            writeFile();
//        }
//    }
//
//    public Recipe getRecipe(Recipe[] recipes, String recipeName) throws Exception {
//        Recipe saveRecipe = null;
//        for (Recipe recipe: recipes){
//            if (Objects.equals(recipe.getName(), recipeName))
//                saveRecipe = recipe;
//        }
//        return saveRecipe;
//    }
}
