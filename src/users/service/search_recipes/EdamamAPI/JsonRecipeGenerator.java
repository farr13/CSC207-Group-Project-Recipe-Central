package users.service.search_recipes.EdamamAPI;

import users.entity.Ingredient;
import users.entity.Recipe;
import users.service.search_recipes.application_business_rules.API_Interface.JsonOutputDataConverter;
import users.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonRecipeGenerator implements JsonOutputDataConverter {
    @Override
    public SearchOutputData convertRecipes(String requestResponse) {
        Gson gson = new Gson();
        JsonCallResponseObj jsonCallResponseObj = gson.fromJson(requestResponse, JsonCallResponseObj.class);
        Recipe[] recipesResponse = getRecipesResponses(jsonCallResponseObj);
        return new SearchOutputData(recipesResponse);
    }

    private Recipe[] getRecipesResponses(JsonCallResponseObj jsonCallResponseObj){
        Hit[] hits = jsonCallResponseObj.getRecipes();
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
            recipes.add(new Recipe(recipeName, recipeUrl, ingredientsArr);
        }

        return recipes.toArray(new Recipe[0]);
    }

    private class Link{ private String herf, title; }
    private class _Links{ private Link self, next; }
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
    private class Nutrient{
        private String label, unit;
        private double quantity;
    }
    private class NutrientsResponceObj{
        private Nutrient ENERC_KCAL, FAT, FASAT, FATRN, FAMS, FAPU, CHOCDF, FIBTG, SUGAR, PROCNT, CHOLE, NA, CA, MG, K, FE, ZN,
                P, VITA_RAE, VITC, THIA, RIBF, NIA, VITB6A, FOLDFE, FOLFD, FOLAC, VITB12, VITD, TOCPHA, VITK1, WATER;

        @SerializedName(value = "CHOCDF.net", alternate = "CHOCDF_net")
        private Nutrient CHOCDF_net;
    }
    private class Digest{
        private String label, tag, schemaOrgTag, unit;
        private double total, daily;
        private Boolean hasRDI;
        private Digest[] sub;
    }
    private class RecipeResponseObj{
        private String uri, label, image, source, url, shareAs, co2EmissionsClass, externalId;
        private int yield;
        private double calories, glycemicIndex, totalCO2Emissions, totalWeight;
        private RecipeRequiredImages images;
        private String[] dietLabels, healthLabels, cautions, ingredientLines, cuisineType, mealType, dishType, instructions, tags;
        private IngredientResponseObj[] ingredients;
        private NutrientsResponceObj totalNutrients, totalDaily;
        private Digest[] digest;
        private _Links _links;
        IngredientResponseObj[] getIngredients() { return ingredients; }

        String getLabel() { return label; }

        String getUrl() { return url; }
    }

    private class JsonCallResponseObj{
        private int from,to,count;
        private _Links _links;
        private Hit[] recipes;
        Hit[] getRecipes() { return recipes; }
    }
}
