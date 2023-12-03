package view.view_models;

import backend.entity.Recipe;
import view.states.SearchResultState;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchResultViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search Results";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "Add to Cookbook";
    public static final String MAIN_BUTTON_LABEL = "Main Menu";
    public static final String[] RECIPES = {};

    private SearchResultState state = new SearchResultState();
    public SearchResultViewModel() {
        super(TITLE_LABEL);
    }
    public void setState(SearchResultState state){this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public SearchResultState getState() {return state;}
}
