package view.view_models;

import view.states.SearchResultsState;
import view.usecase_views.SearchResultsView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import backend.entity.Recipe;
import backend.entity.Ingredient;
public class SearchResultViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Results";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "Add to Cookbook";
    public static final String MAIN_BUTTON_LABEL = "Main Menu";
    public static String[] recipeNames = {
            "Spaghetti Bolognese",
            "Chicken Alfredo",
            "Vegetarian Chili",
            "Beef Stir-Fry",
            "Lemon Garlic Shrimp Pasta",
            "Homemade Pizza",
            "Grilled Salmon",
            "Caprese Salad",
            "Chicken Parmesan",
            "Vegetable Curry",
            "Pesto Pasta",
            "Taco Salad",
            "Mushroom Risotto",
            "Baked Ziti",
            "BBQ Chicken Skewers",
            "Lentil Soup",
            "Garlic Butter Shrimp",
            "Spinach and Feta Stuffed Chicken",
            "Tomato Basil Bruschetta",
            "Eggplant Parmesan",
            "Cauliflower Fried Rice",
            "Greek Salad",
            "Butternut Squash Soup",
            "Teriyaki Chicken Bowl",
            "Honey Mustard Glazed Salmon",
            "Crispy Baked Chicken Wings",
            "Quinoa Salad",
            "Creamy Mushroom Risotto",
            "Beef Tacos",
            "Sweet Potato and Chickpea Curry"
    };
    public static final String[] RECIPES = recipeNames;
    private SearchResultsState state = new SearchResultsState();
    public SearchResultViewModel() {super("Results");}

    public void setState(SearchResultsState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchResultsState getState() {return state;}
}
