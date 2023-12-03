package view.usecase_views;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.back_to_menu.BackToMenuController;
import backend.service.delete_recipe.DeleteRecipeController;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import view.recipe_objects.Triplet;
import view.states.OpenCookbookState;
import view.states.SearchResultState;
import view.view_models.OpenCookbookViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class OpenCookbookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Open Cookbook";
    private final OpenCookbookViewModel openCookbookViewModel;
    private final SeeListCookbooksController seeListCookbooksController;
    private final DeleteRecipeController deleteRecipeController;
    private final BackToMenuController backToMenuController;
    //private final RenameCookbookController renameCookbookController;
    private final JButton mainMenu;
    private final JButton viewCookbooks;
    //private final JButton renameCookbook;
    private final JButton deleteRecipe;

    JLabel cookbookName;
    DefaultListModel<String> listModel = new DefaultListModel<>();

    public OpenCookbookView(OpenCookbookViewModel openCookbookViewModel, SeeListCookbooksController seeListCookbooksController,
                            DeleteRecipeController deleteRecipeController, BackToMenuController backToMenuController) {
        this.openCookbookViewModel = openCookbookViewModel;
        this.seeListCookbooksController = seeListCookbooksController;
        this.deleteRecipeController = deleteRecipeController;
        this.backToMenuController = backToMenuController;
        //this.renameCookbookController = renameCookbookController;

        openCookbookViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(openCookbookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        cookbookName = new JLabel(openCookbookViewModel.getState().getCookbookName());
        cookbookName.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(cookbookName);

        //Creating buttons and placing them is specific panels
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        viewCookbooks = new JButton(OpenCookbookViewModel.COOKBOOK_LIST_BUTTON_LABEL);
        navigationPanel.add(viewCookbooks);
        mainMenu = new JButton(OpenCookbookViewModel.MAIN_MENU_BUTTON_LABEL);
        navigationPanel.add(mainMenu);

        JPanel editCookbookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deleteRecipe = new JButton(OpenCookbookViewModel.DELETE_RECIPE_BUTTON_LABEL);
        editCookbookPanel.add(deleteRecipe);

        // Make Recipe Scroll panel
        JList<String> recipeLst = new JList<>(listModel);
        JScrollPane recipeScrollPane = new JScrollPane(recipeLst);

        //Create active listeners
        mainMenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainMenu)) {
                            backToMenuController.execute();
                        }
                    }
                }
        );

        viewCookbooks.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(viewCookbooks)) {
                            seeListCookbooksController.execute();
                        }
                    }
                }
        );

        deleteRecipe.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteRecipe)) {
                            deleteRecipeController.execute(openCookbookViewModel.getState().getCookbookName(),
                                    recipeLst.getSelectedValuesList().toArray(new String[0]));
                        }
                    }
                }
        );

        //Adding components to this Jpanel
        this.add(recipeScrollPane);
        this.add(editCookbookPanel);
        this.add(navigationPanel);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        listModel.clear();
        OpenCookbookState state = (OpenCookbookState) evt.getNewValue();
        String[] recipes = state.getRecipeBlocks();
        listModel.addAll(Arrays.asList(recipes));
        cookbookName.setText(state.getCookbookName());
    }
}
