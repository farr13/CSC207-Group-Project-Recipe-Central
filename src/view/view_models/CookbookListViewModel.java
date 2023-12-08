package view.view_models;

import view.states.CookbookListState;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CookbookListViewModel extends ViewModel {
    public static final String TITLE_LABEL = "All Cookbooks";
    public static final String MAIN_MENU_BUTTON_LABEL = "Main Menu";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "New Cookbook";
    public static final String DELETE_COOKBOOK_BUTTON_LABEL = "Delete Cookbook";
    public static final String OPEN_COOKBOOK_BUTTON_LABEL = "View Cookbook";
    private CookbookListState state = new CookbookListState();
    public CookbookListViewModel() {
        super(TITLE_LABEL);
    }
    public void setState(CookbookListState state) {
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
    public CookbookListState getState() {
        return state;
    }
}
