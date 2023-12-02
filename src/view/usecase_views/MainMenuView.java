package view.usecase_views;

import view.view_models.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final MainMenuViewModel mainMenuViewModel;
    private final JTextField searchInputField = new JTextField(30);
    private final JButton search;
    //private final JButton viewCookbooks;

    public MainMenuView(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        mainMenuViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(MainMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create the first menu category for first filter
        JPanel filter1Panel = new JPanel();
        filter1Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_1_LABEL));
        String[] filter1Options = MainMenuViewModel.FILTER_1_OPTIONS;
        createCheckBoxes(filter1Panel, filter1Options);

        // Create the second menu category for second filter
        JPanel filter2Panel = new JPanel();
        filter2Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_2_LABEL));
        String[] filter2Options = MainMenuViewModel.FILTER_2_OPTIONS;
        createCheckBoxes(filter2Panel, filter2Options);

        // Create the third menu category for third filter
        JPanel filter3Panel = new JPanel();
        filter3Panel.setBorder(BorderFactory.createTitledBorder(MainMenuViewModel.FILTER_3_LABEL));
        String[] filter3Options = MainMenuViewModel.FILTER_3_OPTIONS;
        createCheckBoxes(filter3Panel, filter3Options);

        //Create panel for search instuctions
        JPanel searchInductions = new JPanel();
        JLabel instructionsLabel = new JLabel(MainMenuViewModel.SEARCH_BOX_INSTRUCTIONS);
        searchInductions.add(instructionsLabel);

        //Create panel for search bar and search button
        JPanel searchSection = new JPanel();
        searchSection.add(searchInputField);

        search = new JButton(MainMenuViewModel.SEARCH_BUTTON_LABEL);
        searchSection.add(search);

        //Adds action listeners for buttons
        search.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            String searchText = searchInputField.getText();
                            ArrayList<String> selectedMealTypes = getSelectedItems(filter1Panel);
                            ArrayList<String> selectedDietOptions = getSelectedItems(filter2Panel);
                            ArrayList<String> selectedHealthOptions = getSelectedItems(filter3Panel);

                            System.out.println("Search Text: " + searchText);
                            System.out.println("Selected Meal Types: " + selectedMealTypes);
                            System.out.println("Selected Diet Options: " + selectedDietOptions);
                            System.out.println("Selected Health Options: " + selectedHealthOptions);
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchInductions);
        this.add(searchSection);
        this.add(filter1Panel);
        this.add(filter2Panel);
        this.add(filter3Panel);
    }
    private static void createCheckBoxes(JPanel panel, String[] options) {
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            panel.add(checkBox);
        }
    }

    //If time, put this in a seperate class.
    private static ArrayList<String> getSelectedItems(JPanel panel) {
        ArrayList<String> selectedItems = new ArrayList<>();
        for (Component component : panel.getComponents()) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    selectedItems.add(checkBox.getText());
                }
            }
        }
        return selectedItems;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel " +
                "not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed method called");
    }
}