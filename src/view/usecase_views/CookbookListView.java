package view.usecase_views;

import backend.entity.Recipe;
import backend.service.back_to_menu.BackToMenuController;
import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.go_add_cookbook.GoAddCookbookController;
import backend.service.view_cookbook.ViewCookbookController;
import view.states.CookbookListState;
import view.view_models.CookbookListViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class CookbookListView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "All Cookbooks";
    private final CookbookListViewModel cookbookListViewModel;
    private final ViewCookbookController viewCookbookController;
    private final DeleteCookbookController deleteCookbookController;
    private final BackToMenuController backToMenuController;
    private final GoAddCookbookController goAddCookbookController;
    private final JButton mainMenu;
    private final JButton openCookbook;
    private final JButton deleteCookbook;
    private final JButton addCookbook;
    DefaultListModel<String> listModel = new DefaultListModel<>();

    public CookbookListView(CookbookListViewModel cookbookListViewModel, ViewCookbookController viewCookbookController,
                            DeleteCookbookController deleteCookbookController, BackToMenuController backToMenuController,
                            GoAddCookbookController goAddCookbookController) {
        this.cookbookListViewModel = cookbookListViewModel;
        this.viewCookbookController = viewCookbookController;
        this.deleteCookbookController = deleteCookbookController;
        this.backToMenuController = backToMenuController;
        this.goAddCookbookController = goAddCookbookController;

        cookbookListViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(CookbookListViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Make the buttons
        JPanel navigationButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        mainMenu = new JButton(CookbookListViewModel.MAIN_MENU_BUTTON_LABEL);
        navigationButtons.add(mainMenu);

        JPanel cookbookEditButtons = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        openCookbook = new JButton(CookbookListViewModel.OPEN_COOKBOOK_BUTTON_LABEL);
        deleteCookbook = new JButton(CookbookListViewModel.DELETE_COOKBOOK_BUTTON_LABEL);
        addCookbook = new JButton(CookbookListViewModel.ADD_COOKBOOK_BUTTON_LABEL);

        cookbookEditButtons.add(openCookbook);
        cookbookEditButtons.add(deleteCookbook);
        cookbookEditButtons.add(addCookbook);

        // Make Cookbook Scroll panel
        JList<String> cookbookNames = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(cookbookNames);


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

        openCookbook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(openCookbook)) {
                            viewCookbookController.execute(cookbookNames.getSelectedValue());
                        }
                    }
                }
        );

        deleteCookbook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteCookbook)) {
                            deleteCookbookController.execute(cookbookNames.getSelectedValuesList().toArray(new String[0]));
                        }
                    }
                }
        );

        addCookbook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addCookbook)) {
                            goAddCookbookController.execute();
                        }
                    }
                }
        );

        //Adding all components to this Jpanel
        this.add(title);
        this.add(scrollPane);
        this.add(cookbookEditButtons);
        this.add(navigationButtons);
    }
    private static void createCheckBoxes(JPanel panel, String[] options) {
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            panel.add(checkBox);
        }
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CookbookListState state = (CookbookListState) evt.getNewValue();
        String[] newCookbookNames = state.getCookbookNames();
        if (newCookbookNames != null){
            listModel.clear();
            listModel.addAll(Arrays.asList(newCookbookNames));
        }
    }
}