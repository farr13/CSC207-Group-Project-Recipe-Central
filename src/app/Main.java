package app;

import view.usecase_views.MainMenuView;
import view.usecase_views.SearchResultsView;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public void mainGUI() {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);

        //Making View Models
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel("Main Screen");

        //Making Views
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel);
        view.add(mainMenuView);

        //Final Steps
        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }

    public void resultsGUI() {
        JFrame frame = new JFrame("Results");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);

        frame.add(view, BorderLayout.CENTER);

        SearchResultViewModel searchResultViewModel = new SearchResultViewModel("Results Screen");

        //Making Views
        SearchResultsView searchResultsView = new SearchResultsView(searchResultViewModel);
        view.add(searchResultsView);

        //Final Steps
        viewManagerModel.setActiveView(searchResultsView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // new Main().mainGUI();
        new Main().resultsGUI();
    }
}
