package view.states;

public class MainMenuState {
    private String ingredients = "";
    private String errorMessage = "";
    public MainMenuState(MainMenuState copy){
        this.ingredients = copy.getIngredients();
    }
    public MainMenuState(){}

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}