package view.view_models;

import java.beans.PropertyChangeListener;

public class MainMenuViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Recipe Central";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String SEARCH_BOX_INSTRUCTIONS = "Type in ingredients required, and separate ingredients by comma:";

    public MainMenuViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
