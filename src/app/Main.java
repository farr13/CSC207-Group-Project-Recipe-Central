package app;

import backend.entity.Cookbook;
import data_access.*;
import view.recipe_objects.Triplet;
import view.states.CookbookListState;
import view.usecase_views.CookbookListView;
import view.usecase_views.MainMenuView;
import view.usecase_views.OpenCookbookView;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.OpenCookbookViewModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // The main application window.
        JFrame frame = new JFrame("Recipe Central");
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
        cookbookListViewModel.getState().setCookbookNames(new String[]{"Breakfast", "Lunch", "Dinner"});
        OpenCookbookViewModel openCookbookViewModel = new OpenCookbookViewModel("Open Cookbook");

        //Making Views
        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel, mainMenuViewModel,
                cookbookListViewModel, viewCookbookDAO);
        view.add(mainMenuView, mainMenuView.viewName);
        CookbookListView cookbookListView = CookbookListUseCaseFactory.create(cookbookListViewModel, viewManagerModel,
                mainMenuViewModel, viewCookbookDAO, deleteCookbookDAO);
        view.add(cookbookListView, cookbookListView.viewName);
        OpenCookbookView openCookbookView = OpenCookbookViewUseCaseFactory.create(viewManagerModel, openCookbookViewModel,
                cookbookListViewModel, mainMenuViewModel, viewCookbookDAO, deleteRecipeDAO);
        view.add(openCookbookView, openCookbookView.viewName);

        //Final Steps
        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
}
