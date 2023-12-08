package view.states;

public class AddRecipeState {
    private String[] recipesSelected = {};
    private String[] cookbookNames = {};

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
