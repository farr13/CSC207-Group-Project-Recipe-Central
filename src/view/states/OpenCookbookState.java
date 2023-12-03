package view.states;

import view.recipe_objects.*;

public class OpenCookbookState {
    private String cookbookName;
    private Triplet[] recipes = new Triplet[]{};
    public OpenCookbookState(OpenCookbookState copy){
        this.cookbookName = copy.getCookbookName();
        this.recipes = copy.getRecipes();
    }
    public OpenCookbookState(){}

    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName;
    }

    public void setRecipes(Triplet[] recipes) {
        this.recipes = recipes;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public Triplet[] getRecipes() {
        return recipes;
    }
}
