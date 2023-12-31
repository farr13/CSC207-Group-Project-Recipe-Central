package view.view_managers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewManagerModel {
    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
