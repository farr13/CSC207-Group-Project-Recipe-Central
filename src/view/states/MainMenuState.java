package view.states;

public class MainMenuState {
    private String ingredients = "";
    public MainMenuState(MainMenuState copy){
        this.ingredients = copy.getIngredients();
    }
    public MainMenuState(){}

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }
}
