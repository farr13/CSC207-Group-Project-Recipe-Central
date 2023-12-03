package view.states;

import view.recipe_objects.*;

public class OpenCookbookState {
    private String cookbookName = "";
    private String[] recipeBlocks = new String[]{};
    public OpenCookbookState(OpenCookbookState copy){
        this.cookbookName = copy.getCookbookName();
        this.recipeBlocks = copy.getRecipeBlocks();
    }
    public OpenCookbookState(){}

    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName;
    }

    public void setRecipeBlocks(String[] recipeBlocks) {
        this.recipeBlocks = recipeBlocks;
    }

    public String getCookbookName() {
        return cookbookName;
    }

    public String[] getRecipeBlocks() {
        return recipeBlocks;
    }
}
