package view.view_models;

import view.states.CookbookListState;
import view.states.OpenCookbookState;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenCookbookViewModel extends ViewModel {
    public static final String MAIN_MENU_BUTTON_LABEL = "Main Menu";
    public static final String COOKBOOK_LIST_BUTTON_LABEL = "Back";
    public static final String DELETE_RECIPE_BUTTON_LABEL = "Delete Recipe";
    public static final String RENAME_RECIPE_BUTTON_LABEL = "Rename Cookbook";

    private OpenCookbookState state = new OpenCookbookState();
    public OpenCookbookViewModel(String viewName) {
        super(viewName);
    }

    public void setState(OpenCookbookState state) {
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

    public OpenCookbookState getState() {
        return state;
    }
}
