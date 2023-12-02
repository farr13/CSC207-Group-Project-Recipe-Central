package users.service.delete_recipe_from_cookbook.;

import users.entity.Cookbook;
import users.entity.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileDeleteRecipeDAO implements DeleteRecipeDAI {
    private static final String JSON_PATH = "cookbooks.json";
    private final Gson gson = new Gson();

    @Override
    public void deleteRecipe(Cookbook cookbook, String recipeName) throws IOException {
        List<Cookbook> cookbooks = readCookbooks();
        boolean cookbookUpdated = false;

        for (Cookbook cb : cookbooks) {
            if (cb.getName().equals(cookbook.getName())) {
                List<Recipe> updatedRecipes = cb.getRecipes().stream()
                        .filter(recipe -> !recipe.getName().equals(recipeName))
                        .collect(Collectors.toList());
                cb.setRecipes(updatedRecipes);
                cookbookUpdated = true;
                break;
            }
        }

        if (cookbookUpdated) {
            writeCookbooks(cookbooks);
        } else {
            throw new IOException("Cookbook not found or recipe not found in the cookbook.");
        }
    }

    private List<Cookbook> readCookbooks() throws IOException {
        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type listType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
            List<Cookbook> cookbooks = gson.fromJson(reader, listType);
            return cookbooks != null ? cookbooks : new ArrayList<>();
        }
    }

    private void writeCookbooks(List<Cookbook> cookbooks) throws IOException {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            gson.toJson(cookbooks, writer);
        }
    }
}
