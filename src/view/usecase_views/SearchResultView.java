package view.usecase_views;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.go_add_cookbook.GoAddCookbookController;
import backend.service.go_add_recipe.GoAddRecipeController;
import view.states.SearchResultState;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class SearchResultView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Search Results";
    private final SearchResultViewModel searchResultViewModel;
    private final BackToMenuController backToMenuController;
    private final GoAddRecipeController goAddRecipeController;
    private final JButton AddToCookbook;
    private final JButton MainMenu;
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public SearchResultView(SearchResultViewModel searchResultViewModel, BackToMenuController backToMenuController,
                            GoAddRecipeController goAddRecipeController) {
        this.searchResultViewModel = searchResultViewModel;
        this.goAddRecipeController = goAddRecipeController;
        this.backToMenuController = backToMenuController;
        this.searchResultViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchResultViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Adding scroll panels
        JList<String> recipeLst = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(recipeLst);

        //Making buttons
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        MainMenu = new JButton(SearchResultViewModel.MAIN_BUTTON_LABEL);
        navigationPanel.add(MainMenu);

        JPanel editCookbookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        AddToCookbook = new JButton(SearchResultViewModel.ADD_COOKBOOK_BUTTON_LABEL);
        editCookbookPanel.add(AddToCookbook);

        //Adding action listener
        MainMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(MainMenu)) {
                            backToMenuController.execute();
                        }
                    }
                }
        );

        AddToCookbook.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(AddToCookbook)) {
                            goAddRecipeController.execute(recipeLst.getSelectedValuesList().toArray(new String[0]));
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(scrollPane);
        this.add(editCookbookPanel);
        this.add(navigationPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchResultState state = (SearchResultState) evt.getNewValue();

        String[] recipes = state.getRecipeLst();
        if (recipes != null){
            listModel.clear();
            listModel.addAll(Arrays.asList(recipes));
        }
    }
}