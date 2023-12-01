package view.view_models;

import view.states.MainMenuState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainMenuViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Central";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String SEARCH_BOX_INSTRUCTIONS = "Type in ingredients required, and separate ingredients by comma:";
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
