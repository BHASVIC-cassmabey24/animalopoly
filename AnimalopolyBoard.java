import javax.swing.*;
import java.awt.*;

public class AnimalopolyBoard extends JPanel {
    private JTextField Animalopoly;
    private JPanel HeaderPanel;
    private JPanel UIPanel;
    private JPanel BoardPanel;

    public AnimalopolyBoard() {
        Animalopoly = new JTextField();
        Animalopoly.setEditable(false);
        HeaderPanel = new JPanel();
        HeaderPanel.add(Animalopoly);
        UIPanel = new JPanel();
        UIPanel.add(HeaderPanel);
        UIPanel.add(BoardPanel);
        BoardPanel.setLayout(new BorderLayout());
        BoardPanel.add(UIPanel, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        AnimalopolyBoard board = new AnimalopolyBoard();
    }
}
