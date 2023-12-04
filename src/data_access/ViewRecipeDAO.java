package data_access;

import backend.entity.Recipe;
import backend.service.delete_recipe.ViewRecipeDAI;
import backend.service.make_cookbook.MakeCookbookAddDAI;
import backend.service.make_cookbook.MakeCookbookViewDAI;
import backend.service.rename_cookbook.DAI.RenameCookbookViewDAI;
import backend.service.view_cookbook.ViewCookbookDAI;
import backend.entity.Cookbook;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ViewRecipeDAO implements ViewRecipeDAI {
    private String jsonPath;
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public ViewRecipeDAO(String fileName){
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
            if (Objects.equals(cookbook.getName(), identifier))
                return true;
        }
        return false;
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    private Cookbook viewCookbook(String cookbookName) {
        if (existByTitle(cookbookName)){
            for (Cookbook cookbook: cookbooks){
                if (Objects.equals(cookbook.getName(), cookbookName))
                    return cookbook;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public Recipe[] viewRecipes(String cookbookName) {
        cookbooks = convertCookbook(readFile());
        return viewCookbook(cookbookName).getRecipes();
    }
}