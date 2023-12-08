package backend.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Recipe {
    private final String name;
    private final Ingredient[] ingredients;
    private final String instructionsURL; // Instructions as a link
    /** Initializes a new Recipe Object.
     * @param name name of this recipe
     * @param instructionsURL link to the instructions of this recipe
     * @param ingredients list containing the ingredients of this recipe */
    public Recipe(String name, String instructionsURL, Ingredient[] ingredients) {
        this.name = name;
        this.instructionsURL = instructionsURL;
        this.ingredients = ingredients;
    }
    /** Checks if an input object is the same as this Recipe Object.
     * @param o Object
     * @return boolean */
    @Override
    public boolean equals(Object o){
        if (o instanceof Recipe){
            ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>(Arrays.asList(ingredients)),
                    oArrayList = new ArrayList<Ingredient>(Arrays.asList(((Recipe) o).getIngredients()));
            return (Objects.equals(((Recipe) o).getName(), name) &&
                    Objects.equals(((Recipe) o).getInstructions(), instructionsURL) &&
                    oArrayList.containsAll(ingredientArrayList) && ingredientArrayList.containsAll(oArrayList));
        } return false;
    }
    /** Returns the name of this recipe.
     * @return String */
    public String getName() { return name; }
    /** Returns the list of ingredients in this recipe.
     * @return Ingredient[] */
    public Ingredient[] getIngredients() { return ingredients; }
    /** Returns the link to the instructions of this recipe.
     * @return String */
    public String getInstructions() { return instructionsURL; }

}
