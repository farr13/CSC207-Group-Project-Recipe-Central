package view.view_models;

import view.states.SelectCookbookState;
import view.usecase_views.SelectCookbookpopup;
import view.view_managers.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectCookbookpopupViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Select Cookbook";

    public static final String CANCEL_BUTTON = "Cancel";
    public static String[] cookbookNames = {
            "Cookbook 1",
            "Cookbook 2",
            "Cookbook 3",
            "Cookbook 4",
            "Cookbook 5",
            "Cookbook 6",
            "Cookbook 7",
            "Cookbook 8",
            "Cookbook 9",
            "Cookbook 10",
    };
    public static final String[] COOKBOOKS = cookbookNames;

    private SelectCookbookpopupViewModel() {super("Select pop-up");}

    private SelectCookbookState state = new SelectCookbookState();

    public void setState(SelectCookbookState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
