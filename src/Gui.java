import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Gui extends JFrame{
    private JPanel panel;
    private JButton btn1;
    private JTextArea txtArea1;
    private JTextArea txtArea2;
    private JTable table1;
    private File selectedFile;

    public Gui() {
        components();
        menu();
    }

    public void components() {
        setContentPane(panel);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GUI");
    }

    public void menu()  {
        btn1.addActionListener(e -> napsat() );

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Akce");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Napsat");
        menu.add(menuItem);
        menuItem.addActionListener(e -> napsat());

        JMenuItem menuItem2 = new JMenuItem("Načíst soubor");
        menu.add(menuItem2);
        menuItem2.addActionListener(e -> nacist());

        table1.setModel(new SpravceZakazniku());
    }

    public void nacist() {
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            StringBuilder sb = new StringBuilder();
            try (Scanner sc = new Scanner(new BufferedReader(new FileReader(selectedFile)))) {
                while (sc.hasNextLine()) {
                    sb.append(sc.nextLine()).append("\n");
                }
                txtArea2.setText(String.valueOf(sb));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Chyba při čtení souboru: " + e.getMessage());
            }
        }
    }

    public void napsat() {
        txtArea2.append(txtArea1.getText() + "\n");
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setVisible(true);
    }
}
