package backend.service;

import app.CookbookListUseCaseFactory;
import app.Main;
import app.MainMenuUseCaseFactory;
import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInputBoundary;
import backend.service.delete_cookbook.DeleteCookbookDAI;
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

public class BackToMenuTest {
    private MainMenuView mmv_test;
    private CookbookListView clv_test;
    private ViewManagerModel vmm_test;

    private void setUp() {  // Mimics main.java for testing
        JFrame frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setLayout(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(view, BorderLayout.CENTER);

        // Need VM Model for verifying view change
        vmm_test = new ViewManagerModel();
        new ViewManager(view, cardLayout, vmm_test);

        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel();
        OpenCookbookViewModel openCookbookViewModel = new OpenCookbookViewModel();
        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
        AddCookbookViewModel addCookbookViewModel = new AddCookbookViewModel();

        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("thisDAOTest.json");
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("thisDAOTest.json");

        // Have the testing views as an attribute of the test class
        mmv_test = MainMenuUseCaseFactory.create(
                vmm_test, mainMenuViewModel,
                searchResultViewModel, cookbookListViewModel,
                viewCookbookDAO);
        view.add(mmv_test, mmv_test.viewName);

        clv_test = CookbookListUseCaseFactory.create(
                vmm_test, mainMenuViewModel,
                cookbookListViewModel, openCookbookViewModel, addCookbookViewModel,
                viewCookbookDAO, deleteCookbookDAO);
        view.add(clv_test, clv_test.viewName);

        // Start with CookbookListView for checking
        vmm_test.setActiveView(clv_test.viewName);
        vmm_test.firePropertyChanged();

        frame.pack();
        frame.setVisible(false);
    }

    @Test
    public void testCookBookListViewBTM() {
        setUp();

        // clv_test.

        // get a reference to the first password field
        Component panel1 = clv_test.getComponent(1);
        Component panel2 = clv_test.getComponent(2);
        Component panel3 = clv_test.getComponent(3);
        System.out.println(panel1);
        System.out.println(panel2);
        System.out.println(panel3);

        // These panels have sub-components, find the respective buttons and run them
        // Then Assert that VMM_TEST .getActiveView is the Main Menu button
        // IGTG SORRY!!

        System.out.println();
        assertEquals(1, 2);

//        // create and dispatch KeyEvents to the UI
//        KeyEvent event = new KeyEvent(
//                pwdField, // we are interacting with the pwdField
//                KeyEvent.KEY_TYPED, //
//                System.currentTimeMillis(), // say the event happened right now
//                0, // no modifiers
//                KeyEvent.VK_UNDEFINED, // for KEY_TYPED, the KeyCode is undefined per documentation
//                'y'); // the character that is being typed
//
//        panel.dispatchEvent(event);
//
//
//        // pause execution for a second
//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        // print the current values the password field and view-model hold
//        System.out.println("field 1: " + new String(pwdField.getPassword()));
//        System.out.println("view-model: " + viewModel.getState().getPassword());

//        // move to the right in the password field, otherwise the event
//        // will type the character as the first character instead of the last!
//        KeyEvent eventRight = new KeyEvent(
//                pwdField,
//                KeyEvent.KEY_PRESSED,
//                System.currentTimeMillis(),
//                0,
//                KeyEvent.VK_RIGHT,
//                KeyEvent.CHAR_UNDEFINED
//        );
//        panel.dispatchEvent(eventRight);
//
//        // pause execution for a second
//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        // type a second character
//        KeyEvent event2 = new KeyEvent(
//                pwdField,
//                KeyEvent.KEY_TYPED,
//                System.currentTimeMillis(),
//                0,
//                KeyEvent.VK_UNDEFINED,
//                'z');
//        panel.dispatchEvent(event2);
//
//
//        // pause execution for 3 seconds
//        try {
//            sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        // print the current values the password field and view-model hold
//        System.out.println("field 1: " + new String(pwdField.getPassword()));
//        System.out.println("view-model: " + viewModel.getState().getPassword());
//
//        // assert that the values are as expected.
//        assertEquals("yz", new String(pwdField.getPassword()));
//        assertEquals("yz", viewModel.getState().getPassword());
    }
}
