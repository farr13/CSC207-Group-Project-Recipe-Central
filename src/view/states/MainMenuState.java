package view.states;

public class MainMenuState {
    private String ingredients = "";
<<<<<<< HEAD
=======
    private String errorMessage = "";
>>>>>>> ViewModels
    public MainMenuState(MainMenuState copy){
        this.ingredients = copy.getIngredients();
    }
    public MainMenuState(){}

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

<<<<<<< HEAD
    public String getIngredients() {
        return ingredients;
    }
=======
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
>>>>>>> ViewModels
}
