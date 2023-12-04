package view.states;

public class AddRecipeState {
    private String[] recipesSelected = {};
    private String[] cookbookNames = {};
    private String errorMessage = "";

    public AddRecipeState(AddRecipeState copy){
        recipesSelected = copy.getRecipesSelected();
        cookbookNames = copy.getCookbookNames();
    }

    public AddRecipeState(){}

    public void setRecipesSelected(String[] recipesSelected) {
        this.recipesSelected = recipesSelected;
    }
    public void setCookbookNames(String[] cookbookNames) {
        this.cookbookNames = cookbookNames;
    }
    public String[] getRecipesSelected() {
        return recipesSelected;
    }

    public String[] getCookbookNames() {
        return cookbookNames;
    }
}
