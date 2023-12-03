package view.usecase_views;

import backend.service.search_recipes.interface_adapters.SearchController;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.view_cookbook.ViewCookbookController;
import view.states.CookbookListState;
import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";

    private final MainMenuViewModel mainMenuViewModel;
    private final SearchController searchController;
    private final SeeListCookbooksController seeListCookbooksController;
    private final JTextField searchInputField = new JTextField(30);
    private final JButton search;
    private final JButton viewCookbooks;

    public MainMenuView(MainMenuViewModel mainMenuViewModel, SearchController searchController,
                        SeeListCookbooksController seeListCookbooksController) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.searchController = searchController;
        this.seeListCookbooksController = seeListCookbooksController;

        mainMenuViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(MainMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Creating filter panel
        JPanel filterPanel = new JPanel();

        // Create the first menu category for first filter
        JPanel filter1Panel = new JPanel();
        filter1Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_1_LABEL));
        JList<String> filter1Lst = new JList<>(MainMenuViewModel.FILTER_1_OPTIONS);
        JScrollPane scrollPane1 = new JScrollPane(filter1Lst);
        filter1Panel.add(scrollPane1);
        filterPanel.add(filter1Panel);

        // Create the second menu category for second filter
        JPanel filter2Panel = new JPanel();
        filter2Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_2_LABEL));
        JList<String> filter2Lst = new JList<>(MainMenuViewModel.FILTER_2_OPTIONS);
        JScrollPane scrollPane2 = new JScrollPane(filter2Lst);
        filter2Panel.add(scrollPane2);
        filterPanel.add(filter2Panel);

        // Create the third menu category for third filter
        JPanel filter3Panel = new JPanel();
        filter3Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_3_LABEL));
        JList<String> filter3Lst = new JList<>(MainMenuViewModel.FILTER_3_OPTIONS);
        JScrollPane scrollPane3 = new JScrollPane(filter3Lst);
        filter3Panel.add(scrollPane3);
        filterPanel.add(filter3Panel);

        //Create panel for search instuctions
        JPanel searchInductions = new JPanel();
        JLabel instructionsLabel = new JLabel(MainMenuViewModel.SEARCH_BOX_INSTRUCTIONS);
        searchInductions.add(instructionsLabel);

        //Create panel for search bar and search button
        JPanel searchSection = new JPanel();
        searchSection.add(searchInputField);

        search = new JButton(MainMenuViewModel.SEARCH_BUTTON_LABEL);
        searchSection.add(search);

        //Create view cookbook button
        viewCookbooks = new JButton(MainMenuViewModel.VIEW_COOKBOOKS_BUTTON_LABEL);
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navigationPanel.add(viewCookbooks);

        //Adds action listeners for buttons
        search.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            String searchText = searchInputField.getText();
                            String[] selectedFilter1 = filter1Lst.getSelectedValuesList().toArray(new String[0]);
                            String[] selectedFilter2 = filter2Lst.getSelectedValuesList().toArray(new String[0]);
                            String[] selectedFilter3 = filter3Lst.getSelectedValuesList().toArray(new String[0]);
                            searchController.execute(searchText, selectedFilter1, selectedFilter2, selectedFilter3);
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

        this.add(title);
        this.add(searchInductions);
        this.add(searchSection);
        this.add(filterPanel);
        this.add(navigationPanel);
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