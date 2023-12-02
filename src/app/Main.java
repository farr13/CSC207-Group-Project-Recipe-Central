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
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();

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

        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();

        //Making Views
        //SearchResultsView = new SearchResultsView();
        //view.add(searchResultsView);

        //Final Steps
        //viewManagerModel.setActiveView(searchResultsView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // Search results screen
        // new Main().mainGUI();
        // Results screen
        new Main().resultsGUI();

        JFrame application = new JFrame("Recipe Central");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.

        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
    }

}