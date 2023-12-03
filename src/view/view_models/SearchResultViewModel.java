package view.view_models;

import backend.entity.Recipe;
import view.states.SearchResultState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import view.view_managers.ViewModel;

public class SearchResultViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Results";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "Add to Cookbook";
    public static final String MAIN_BUTTON_LABEL = "Main Menu";

    public static final Recipe[] RECIPES = {};

    private SearchResultState state = new SearchResultState();
    public SearchResultViewModel(String viewName) {
        super(viewName);
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

    public void setState(SearchResultState state){this.state = state;}
    public SearchResultState getState() {return state;}
}
