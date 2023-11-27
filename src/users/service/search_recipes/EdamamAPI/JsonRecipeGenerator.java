package users.service.search_recipes.EdamamAPI;

import users.entity.Ingredient;
import users.entity.Recipe;
import users.service.search_recipes.application_business_rules.API_Interface.JsonOutputDataConverter;
import users.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonRecipeGenerator implements JsonOutputDataConverter {
    @Override
    public SearchOutputData convertRecipes(String requestResponse) {
        Gson gson = new Gson();
        JsonCallResponseObj jsonCallResponseObj = gson.fromJson(requestResponse, JsonCallResponseObj.class);
        Recipe[] recipesResponse = getRecipesResponses(jsonCallResponseObj);
        return new SearchOutputData(recipesResponse);
    }

    private Recipe[] getRecipesResponses(JsonCallResponseObj jsonCallResponseObj){
        Hit[] hits = jsonCallResponseObj.getHits();
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        for (Hit hit: hits){
            RecipeResponseObj recipeResponseObj = hit.getRecipe();

            String recipeName = recipeResponseObj.getLabel();
            String recipeUrl = recipeResponseObj.getUrl();

            ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

            IngredientResponseObj[] ingredientResponseObjs = recipeResponseObj.getIngredients();
            for (IngredientResponseObj ingredientResponseObj: ingredientResponseObjs)
                ingredients.add(new Ingredient(ingredientResponseObj.getText()));

            Ingredient[] ingredientsArr = ingredients.toArray(new Ingredient[0]);
            recipes.add(new Recipe(recipeName, recipeUrl, ingredientsArr));
        }

        return recipes.toArray(new Recipe[0]);
    }

    private class Hit{
        private  RecipeResponseObj recipe;
        RecipeResponseObj getRecipe() { return recipe; }
    }
    private class Images{
        private int width, height;
        private String url;
    }
    private class RecipeRequiredImages{ private Images THUMBNAIL, SMALL, REGULAR, LARGE; }
    private class IngredientResponseObj{
        private double quantity, weight;
        private String text, measure, food, foodId;

        String getText() { return text; }
    }
    private class RecipeResponseObj{
        private String label, url;
        private RecipeRequiredImages images;
        private IngredientResponseObj[] ingredients;
        IngredientResponseObj[] getIngredients() { return ingredients; }

        String getLabel() { return label; }

        String getUrl() { return url; }

        RecipeRequiredImages getImages() {
            return images;
        }
    }

    private class JsonCallResponseObj{
        private Hit[] hits;
        Hit[] getHits() { return hits; }
    }
}
