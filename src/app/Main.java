package app;

import backend.entity.Cookbook;
import data_access.*;
import view.states.CookbookListState;
import view.usecase_views.CookbookListView;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // The main application window.
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);

        //This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);

        //Creating data access objects
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("saved_data.json");
        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("saved_data.json");
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("saved_data.json");
        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("saved_data.json");
        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("saved_data.json");

        //Making View Models
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel("Main Screen");
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel("Cookbook List");
        cookbookListViewModel.getState().setCookbookNames(new String[]{"Breakfast", "Lunch"});

        //Making Views
        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel, mainMenuViewModel,
                cookbookListViewModel, viewCookbookDAO);
        view.add(mainMenuView);
        CookbookListView cookbookListView = CookbookListUseCaseFactory.create(cookbookListViewModel, viewManagerModel,
                mainMenuViewModel, viewCookbookDAO, deleteCookbookDAO);
        view.add(cookbookListView);

        //Final Steps
        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
}


//
//
//public class Main {
//    public static void main(String[] args) {
//        // The main application window.
//>>>>>>> ViewModels
//        JFrame frame = new JFrame("Main Menu");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//        JPanel view = new JPanel(cardLayout);
//        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        frame.add(view, BorderLayout.CENTER);
//
//<<<<<<< HEAD
//        // This keeps track of and manages which view is currently showing.
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(view, cardLayout, viewManagerModel);
//
//        //Making View Models
//        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
//
//        //Making Views
//        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel);
//        view.add(mainMenuView);
//=======
//        //This keeps track of and manages which view is currently showing.
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(view, cardLayout, viewManagerModel);
//
//        //Creating data access objects
//        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("saved_data.json");
//        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("saved_data.json");
//        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("saved_data.json");
//        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("saved_data.json");
//        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("saved_data.json");
//
//        //Making View Models
//        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel("Main Screen");
//        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel("Cookbook List");
//        cookbookListViewModel.getState().setCookbookNames(new String[]{"Breakfast", "Lunch"});
//
//        //Making Views
//        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel, mainMenuViewModel,
//                cookbookListViewModel, viewCookbookDAO);
//        view.add(mainMenuView);
//        CookbookListView cookbookListView = CookbookListUseCaseFactory.create(cookbookListViewModel, viewManagerModel,
//                mainMenuViewModel, viewCookbookDAO, deleteCookbookDAO);
//        view.add(cookbookListView);
//>>>>>>> ViewModels
//
//        //Final Steps
//        viewManagerModel.setActiveView(mainMenuView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//<<<<<<< HEAD
//
//    public void resultsGUI() {
//        JFrame frame = new JFrame("Results");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//        JPanel view = new JPanel(cardLayout);
//        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(view, cardLayout, viewManagerModel);
//
//        frame.add(view, BorderLayout.CENTER);
//
//        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
//
//        //Making Views
//        //SearchResultsView = new SearchResultsView();
//        //view.add(searchResultsView);
//
//        //Final Steps
//        //viewManagerModel.setActiveView(searchResultsView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//    public static void main(String[] args) {
//        // Search results screen
//        // new Main().mainGUI();
//        // Results screen
//        new Main().resultsGUI();
//
//        JFrame application = new JFrame("Recipe Central");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//
//        // The various View objects. Only one view is visible at a time.
//        JPanel views = new JPanel(cardLayout);
//        application.add(views);
//
//        // This keeps track of and manages which view is currently showing.
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, cardLayout, viewManagerModel);
//
//        // The data for the views, such as username and password, are in the ViewModels.
//        // This information will be changed by a presenter object that is reporting the
//        // results from the use case. The ViewModels are observable, and will
//        // be observed by the Views.
//
//        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
//        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
//    }
//
//}