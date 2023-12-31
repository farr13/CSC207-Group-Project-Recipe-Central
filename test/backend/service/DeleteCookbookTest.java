package backend.service;

import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import data_access.*;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class DeleteCookbookTest {
    private static DeleteCookbookController setUp() {
        JFrame frame = new JFrame("Recipe Central");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setLayout(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel();

        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("test.json");
        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("test.json");

        DeleteCookbookPresenter deleteCookbookPresenter = new DeleteCookbookPresenter(cookbookListViewModel);
        DeleteCookbookInteractor deleteCookbookInteractor = new DeleteCookbookInteractor(deleteCookbookDAO, viewCookbookDAO,
                deleteCookbookPresenter);
        return new DeleteCookbookController(deleteCookbookInteractor);
    }

    @Test
    public void BasicTest(){
        DeleteCookbookController deleteCookbookController = setUp();
        deleteCookbookController.execute(new String[]{"Tester"});
        deleteCookbookController.execute(new String[]{"Tester"});
    }
}
