package backend.service;

import app.CookbookListUseCaseFactory;
import app.Main;
import app.MainMenuUseCaseFactory;
import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInputBoundary;
import backend.service.back_to_search.BackToSearchController;
import backend.service.back_to_search.BackToSearchInteractor;
import backend.service.back_to_search.BackToSearchPresenter;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.search_recipes.EdamamAPI.EdamamCaller;
import backend.service.search_recipes.EdamamAPI.EdamamURLGenerator;
import backend.service.search_recipes.EdamamAPI.JsonRecipeGenerator;
import backend.service.search_recipes.application_business_rules.SearchInteractor;
import backend.service.search_recipes.interface_adapters.SearchController;
import backend.service.search_recipes.interface_adapters.SearchPresenter;
import backend.service.view_cookbook.ViewCookbookDAI;
import data_access.AddCookbookDAO;
import data_access.DeleteCookbookDAO;
import data_access.ViewCookbookDAO;
import org.junit.Test;
import view.usecase_views.CookbookListView;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class SearchRecipeTest {
    private static SearchController setUp() {
        JFrame frame = new JFrame("Recipe Central");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setLayout(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel();
        OpenCookbookViewModel openCookbookViewModel = new OpenCookbookViewModel();
        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
        AddRecipeViewModel addRecipeViewModel = new AddRecipeViewModel();
        AddCookbookViewModel addCookbookViewModel = new AddCookbookViewModel();

        SearchPresenter searchPresenter = new SearchPresenter(viewManagerModel, searchResultViewModel);
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
        SearchInteractor searchInteractor = new SearchInteractor(edamamCaller, edamamURLGenerator, jsonRecipeGenerator, searchPresenter);
        return new SearchController(searchInteractor);
    }

    @Test
    public void BasicControllerTest() {
        SearchController searchController = setUp();
        searchController.execute("cookies", new String[]{}, new String[]{}, new String[]{});
    }
}
