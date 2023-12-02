package view.states;

public class SearchResultsState {
    private String recipeName = "";
    private String cookbookName = "";
    private String ingredientDesc = "";
    private String instructions = "";

    public SearchResultsState(SearchResultsState copy) {
        recipeName = copy.recipeName;
        cookbookName = copy.cookbookName;
        instructions = copy.instructions;
        ingredientDesc = copy.ingredientDesc;
    }
    public SearchResultsState(){
    }

    public String getRecipeName() {return recipeName;}
    public String getInstructions() {return instructions;}
    public String getIngredientDesc() {return ingredientDesc;}
    public String getCookbookName() {return cookbookName;}

    public void setRecipeName(String recipeName) {this.recipeName = recipeName;}
    public void setCookbookName(String cookbookName) {this.cookbookName = cookbookName;}

    public void setIngredientDesc(String ingredientDesc) {this.ingredientDesc = ingredientDesc;}
    public void setInstructions(String instructions) {this.instructions = instructions;}

}
