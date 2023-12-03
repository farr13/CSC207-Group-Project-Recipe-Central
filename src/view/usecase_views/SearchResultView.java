package view.usecase_views;

import backend.entity.Recipe;
import backend.service.add_recipe.AddRecipeController;
import backend.service.back_to_menu.BackToMenuController;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchResultView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Search Results";
    private final SearchResultViewModel searchResultViewModel;
    private final BackToMenuController backToMenuController;
    private final AddRecipeViewModel addRecipeViewModel;
    private final AddRecipeController addRecipeController;
    private final JButton AddToCookbook;
    private final JButton MainMenu;

    public SearchResultView(SearchResultViewModel searchResultViewModel, AddRecipeViewModel addRecipeViewModel,
                            AddRecipeController addRecipeController, BackToMenuController backToMenuController ) {
        this.searchResultViewModel = searchResultViewModel;
        this.backToMenuController = backToMenuController;
        this.addRecipeViewModel = addRecipeViewModel;
        this.addRecipeController = addRecipeController;
        searchResultViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchResultViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JList<Recipe> recipeLst = new JList<>(SearchResultViewModel.RECIPES);
        JScrollPane scrollPane = new JScrollPane(recipeLst);

        MainMenu = new JButton(SearchResultViewModel.MAIN_BUTTON_LABEL);
        AddToCookbook = new JButton(SearchResultViewModel.ADD_COOKBOOK_BUTTON_LABEL);

        JPanel flowLayoutPanel = new JPanel(new FlowLayout());
        flowLayoutPanel.add(MainMenu);
        flowLayoutPanel.add(AddToCookbook);

        MainMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(MainMenu)) {
                            backToMenuController.execute();
                            System.out.println("Main Menu Button");
                        }
                    }
                }
        );

        AddToCookbook.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(AddToCookbook)) {
                            System.out.println("ATC Button");
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(scrollPane);
        this.add(flowLayoutPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property Name: " + evt.getPropertyName() + ", Property change call (SearchResults view)");
    }
}