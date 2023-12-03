package view.recipe_objects;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class JRecipePanelTest {
    @Test
    public void basicPanelView(){
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);

        Triplet<String, String, String[]>[] recipes = new Triplet[]{new Triplet<>("Cookies", "www.com",
                new String[]{"flour", "sugar"})};

        for (Triplet<String, String, String[]> recipe: recipes){
            view.add(new JRecipePanel(recipe));
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Open Cookbook Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAutoscrolls(true);
        frame.add(panel);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(5, 3, 400, 500);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(450, 600));
        contentPane.add(scrollPane);

        Triplet r1 = new Triplet<>("Cookies", "www.com", new String[]{"flour", "sugar"}),
                r2 = new Triplet<>("Cookiessss", "www.com", new String[]{"flour", "sugar"});

        panel.add(new JRecipePanel(r1));
        panel.add(new JRecipePanel(r2));
        panel.add(new JRecipePanel(r2));


        /*Triplet[] recipes = new Triplet[]{new Triplet<>("Cookies", "www.com",
                new String[]{"flour", "sugar"}), new Triplet<>("Cookies", "www.com",
                new String[]{"flour", "sugar"})};

        for (Triplet<String, String, String[]> recipe: recipes){
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createTitledBorder(recipe.getFirst()));

            JLabel instructionsURL = new JLabel("Recipe Link: " + recipe.getSecond());
            panel.add(instructionsURL);

            JList<String> ingredients = new JList<>(recipe.getThird());

            panel.add(ingredients);

            frame.add(panel);
        }*/

        frame.add(contentPane, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void mainTester() {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH  = 1000;
        final int FRAME_HEIGHT = 1000;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Home Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel m1 = new JLabel("safsd");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAutoscrolls(true);
        frame.add(panel,BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 800, 800);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(900, 900));
        contentPane.add(scrollPane);

        for(int i = 0; i < 30; i++) {

            JPanel sp1 = new JPanel();
            sp1.setLayout(new FlowLayout());
            sp1.setBackground(Color.WHITE);
            sp1.setPreferredSize(new Dimension(900, 180));

            JPanel ssp1 = new JPanel();
            ssp1.setLayout(new FlowLayout());
            ssp1.setBackground(Color.WHITE);
            ssp1.setPreferredSize(new Dimension(500, 170));

            JPanel ssp2 = new JPanel();
            ssp2.setLayout(new FlowLayout());
            ssp2.setBackground(Color.WHITE);
            ssp2.setPreferredSize(new Dimension(350, 170));

            JLabel l3 = new JLabel("Title: ");
            l3.setForeground(Color.BLACK);
            l3.setPreferredSize(new Dimension(100, 20));
            JTextField t1 = new JTextField("Electronic Basics");
            t1.setPreferredSize(new Dimension(320, 20));

            JLabel l4 = new JLabel("Type: ");
            l4.setForeground(Color.BLACK);
            l4.setPreferredSize(new Dimension(100, 20));
            JTextField t2 = new JTextField("Book");
            t2.setPreferredSize(new Dimension(320, 20));

            JLabel l5 = new JLabel("Authors: ");
            l5.setForeground(Color.BLACK);
            l5.setPreferredSize(new Dimension(100, 20));
            JTextField t3 = new JTextField("Bob the Builder");
            t3.setPreferredSize(new Dimension(320, 20));

            JLabel l6 = new JLabel("Publisher: ");
            l6.setForeground(Color.BLACK);
            l6.setPreferredSize(new Dimension(100, 20));
            JTextField t4 = new JTextField("ABC Company");
            t4.setPreferredSize(new Dimension(320, 20));

            JLabel l7 = new JLabel("Location: ");
            l7.setForeground(Color.BLACK);
            l7.setPreferredSize(new Dimension(100, 20));
            JTextField t5 = new JTextField("Shelf 1 Row 3");
            t5.setPreferredSize(new Dimension(320, 20));

            JLabel l8 = new JLabel("Status: ");
            l8.setForeground(Color.BLACK);
            l8.setPreferredSize(new Dimension(100, 20));
            JTextField t6 = new JTextField("Available");
            t6.setPreferredSize(new Dimension(320, 20));

            JButton btnLoanHistory = new JButton("Loan History");
            btnLoanHistory.setPreferredSize(new Dimension(300, 20));
            JButton btnLoanItem = new JButton("Loan Item");
            btnLoanItem.setPreferredSize(new Dimension(300, 20));
            JButton btnProcessReturn = new JButton("Process Return");
            btnProcessReturn.setPreferredSize(new Dimension(300, 20));

            ssp1.add(l3);
            ssp1.add(t1);
            ssp1.add(l4);
            ssp1.add(t2);
            ssp1.add(l5);
            ssp1.add(t3);
            ssp1.add(l6);
            ssp1.add(t4);
            ssp1.add(l7);
            ssp1.add(t5);
            ssp1.add(l8);
            ssp1.add(t6);

            ssp2.add(btnLoanHistory);
            ssp2.add(btnLoanItem);
            ssp2.add(btnProcessReturn);

            sp1.add(ssp1);
            sp1.add(ssp2);
            panel.add(sp1);

        }

        frame.add(m1, BorderLayout.NORTH);
        frame.add(contentPane, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}