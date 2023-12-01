package view.usecase_views;

import view.view_models.SearchResultViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchResultsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "results";
    private final SearchResultViewModel searchResultViewModel;
    private final  JButton AddtoCookbook;
    private final  JButton MainMenu;

    public SearchResultsView(SearchResultViewModel searchResultViewModel) {
        this.searchResultViewModel = searchResultViewModel;
        searchResultViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchResultViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JFrame frame = new JFrame("Scrolling List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JList<String> recipeLst = new JList<>(SearchResultViewModel.RECIPES);

        JScrollPane scrollPane = new JScrollPane(recipeLst);

        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);

        AddtoCookbook = new JButton(SearchResultViewModel.ADD_COOKBOOK_BUTTON_LABEL);
        MainMenu = new JButton(SearchResultViewModel.MAIN_BUTTON_LABEL);

        MainMenu.addActionListener({
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(MainMenu)) {
                        System.out.println("Search Text: " + searchText);
                    }
        }
        });
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}