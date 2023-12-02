package view.view_models;

import view.states.MainMenuState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainMenuViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Central";
    public static final String SEARCH_BUTTON_LABEL = "Search", VIEW_COOKBOOKS_BUTTON_LABEL = "View Cookbooks";
    public static final String SEARCH_BOX_INSTRUCTIONS = "Type in ingredients required, and separate ingredients by comma:";
    public static final String FILTER_2_LABEL = "Diet", FILTER_3_LABEL = "Health", FILTER_1_LABEL = "Meal Type";
    public static final String[] FILTER_2_OPTIONS = new String[]{"balanced", "high-fiber", "high-protein", "low-carb", "low-fat", "low-sodium"},
            FILTER_3_OPTIONS = new String[]{"alcohol-cocktail", "alcohol-free", "dairy-free", "egg-free", "fish-free", "gluten-free", "immuno-supportive", "keto-friendly", "kosher", "low-sugar", "paleo", "peanut-free", "pescatarian", "pork-free", "red-meat-free", "vegan", "vegetarian"},
            FILTER_1_OPTIONS = new String[]{"Breakfast", "Dinner", "Lunch", "Snack"};

    private MainMenuState state = new MainMenuState();
    public MainMenuViewModel(String viewName) {
        super(viewName);
    }

    public void setState(MainMenuState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public MainMenuState getState() {
        return state;
    }
}
