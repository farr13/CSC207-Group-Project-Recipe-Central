package view.view_models;

import view.states.AddRecipeState;
import view.view_managers.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Add Recipe";
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String RECIPE_LABEL = "Recipes Selected";
    public static final String COOKBOOK_LABEL = "Cookbooks";
    private AddRecipeState state = new AddRecipeState();
    public AddRecipeViewModel() {
        super(TITLE_LABEL);
    }
    public void setState(AddRecipeState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public AddRecipeState getState() {
        return state;
    }
}
