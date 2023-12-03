package view.usecase_views;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.make_cookbook.MakeCookbookController;
import backend.service.rename_cookbook.RenameCookbookController;
import backend.service.search_recipes.interface_adapters.SearchController;
import backend.service.view_cookbook.ViewCookbookController;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CookbookListView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "cookbook list";
    private final CookbookListViewModel cookbookListViewModel;
    private final ViewCookbookController viewCookbookController;
    private final DeleteCookbookController deleteCookbookController;
    private final BackToMenuController backToMenuController;
    private final JButton mainMenu;
    private final JButton openCookbook;
    private final JButton deleteCookbook;

    public CookbookListView(CookbookListViewModel cookbookListViewModel, ViewCookbookController viewCookbookController,
                            DeleteCookbookController deleteCookbookController, BackToMenuController backToMenuController) {
        this.cookbookListViewModel = cookbookListViewModel;
        this.viewCookbookController = viewCookbookController;
        this.deleteCookbookController = deleteCookbookController;
        this.backToMenuController = backToMenuController;

        cookbookListViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(CookbookListViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Make the buttons
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        mainMenu = new JButton(CookbookListViewModel.MAIN_MENU_BUTTON_LABEL);
        openCookbook = new JButton(CookbookListViewModel.OPEN_COOKBOOK_BUTTON_LABEL);
        deleteCookbook = new JButton(CookbookListViewModel.DELETE_COOKBOOK_BUTTON_LABEL);

        flowLayoutPanel.add(mainMenu);
        flowLayoutPanel.add(openCookbook);
        flowLayoutPanel.add(deleteCookbook);

        // Make Cookbook Scroll panel
        JList<String> cookbookNames = new JList<>(cookbookListViewModel.getState().getCookbookNames());
        JScrollPane scrollPane = new JScrollPane(cookbookNames);

        //Checks if mutiple cookbooks are selected
        /*scrollPane.addAncestorListener(
                new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent event) {
                        if (event.getSource().equals(scrollPane)) {
                            openCookbook.setEnabled(cookbookNames.getSelectedValuesList().size() == 1);
                        }
                    }

                    @Override
                    public void ancestorRemoved(AncestorEvent event) {
                        if (event.getSource().equals(scrollPane)) {
                            openCookbook.setEnabled(cookbookNames.getSelectedValuesList().size() == 1);
                        }
                    }

                    @Override
                    public void ancestorMoved(AncestorEvent event) {
                        if (event.getSource().equals(scrollPane)) {
                            openCookbook.setEnabled(cookbookNames.getSelectedValuesList().size() == 1);
                        }
                    }
                }
        );*/

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

        //Adding all components to this Jpanel
        this.add(title);
        this.add(scrollPane);
        this.add(flowLayoutPanel);
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
        System.out.println("Property changed method called");
    }
}