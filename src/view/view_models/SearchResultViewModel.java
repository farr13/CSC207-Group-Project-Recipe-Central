package view.view_models;

import view.states.SearchResultsState;
import view.usecase_views.SearchResultsView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchResultViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Results";
    public static final String ADD_COOKBOOK_BUTTON_LABEL = "Add to Cookbook";
    public static final String MAIN_BUTTON_LABEL = "Main Menu";
    public static final String[] RECIPES = new String[]{"FakeRecipe1" ,"FakeRecipe2", "FakeRecipe3",
            "FakeRecipe4", "FakeRecipe5"};
    private SearchResultsState state = new SearchResultsState();
    public SearchResultViewModel(String viewName) {super(viewName);}

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
