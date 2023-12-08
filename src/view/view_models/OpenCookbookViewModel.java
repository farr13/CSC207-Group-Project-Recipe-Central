package view.view_models;

import view.states.OpenCookbookState;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenCookbookViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Open Cookbook";
    public static final String MAIN_MENU_BUTTON_LABEL = "Main Menu";
    public static final String COOKBOOK_LIST_BUTTON_LABEL = "Back";
    public static final String DELETE_RECIPE_BUTTON_LABEL = "Delete Recipe";
    private OpenCookbookState state = new OpenCookbookState();
    public OpenCookbookViewModel() {
        super(TITLE_LABEL);
    }
    public void setState(OpenCookbookState state) {
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
    public OpenCookbookState getState() {
        return state;
    }
}
