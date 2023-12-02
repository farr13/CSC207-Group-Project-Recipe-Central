package view.states;

import view.recipe_objects.Triplet;

public class OpenCookbookState {
    private String cookbookName;
    private Triplet<String, String, String[]>[] recipes;
    public OpenCookbookState(OpenCookbookState copy){
        this.cookbookName = copy.getCookbookName();
        this.recipes = copy.recipes;
    }
    public OpenCookbookState(){}

    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName;
    }

    public void setRecipes(Triplet<String, String, String[]>[] recipes) {
        this.recipes = recipes;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public Triplet<String, String, String[]>[] getRecipes() {
        return recipes;
    }
}
