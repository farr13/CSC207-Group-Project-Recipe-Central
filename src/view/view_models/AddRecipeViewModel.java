package view.view_models;

import view.view_managers.ViewModel;
import java.beans.PropertyChangeListener;

public class AddRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "All Cookbooks";
    public static final String CONFIRM_BUTTON_LABEL = "Confirm";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public AddRecipeViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
