package view.view_models;

import view.states.AddCookbookState;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddCookbookViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Add Cookbook";
    public static final String VIEW_COOKBOOKS_BUTTON_LABEL = "Cancel";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "Add";
    private AddCookbookState state = new AddCookbookState();
    public AddCookbookViewModel() {
        super(TITLE_LABEL);
    }

    public void setState(AddCookbookState state) {
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

    public AddCookbookState getState() {
        return state;
    }
}