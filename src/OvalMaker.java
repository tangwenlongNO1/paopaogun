
/**
 * This program creates Oval objects on-screen, either based upon user input, or
 * randomly as a set of circles.
 *
 * @author twl
 */
import java.awt.Color;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class OvalMaker implements ActionListener {

    // graphical elements
    private JFrame mainWindow;
    private JTextField xField, yField, widthField, heightField;
    private JButton addButton, randButton;

    /**
     * Simple main() to start program.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        OvalMaker maker = new OvalMaker();
        maker.makeWindows();
    }

    /**
     * Create two windows: one for displaying shapes, and one for obtaining user
     * input.
     */
    private void makeWindows() {
        mainWindow = new JFrame();
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Shapely Shapes");
        mainWindow.setLocation(50, 50);
        mainWindow.setSize(500, 500);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        mainWindow.getContentPane().setBackground(Color.white);

        JFrame inputWindow = new JFrame();
        inputWindow.setLayout(null);
        inputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputWindow.setLocation(mainWindow.getX(),
                mainWindow.getY() + mainWindow.getHeight() + 10);
        inputWindow.setVisible(true);
        inputWindow.setSize(mainWindow.getWidth(),
                100 + inputWindow.getInsets().top + inputWindow.getInsets().bottom);
        inputWindow.setResizable(false);
        inputWindow.getContentPane().setBackground(Color.lightGray);

        int fieldWidth = 100;
        int fieldHeight = 20;
        JLabel xLabel = new JLabel("x:");
        xLabel.setHorizontalAlignment(JLabel.RIGHT);
        xLabel.setBounds(75, 10, 40, fieldHeight);
        inputWindow.add(xLabel, 0);

        xField = new JTextField();
        xField.setBounds(125, 10, fieldWidth, fieldHeight);
        xField.setBackground(Color.white);
        xField.setOpaque(true);
        inputWindow.add(xField, 0);

        JLabel yLabel = new JLabel("y:");
        yLabel.setHorizontalAlignment(JLabel.RIGHT);
        yLabel.setBounds(75, 40, 40, fieldHeight);
        inputWindow.add(yLabel, 0);

        yField = new JTextField();
        yField.setBounds(125, 40, fieldWidth, fieldHeight);
        yField.setBackground(Color.white);
        yField.setOpaque(true);
        inputWindow.add(yField, 0);

        JLabel wLabel = new JLabel("w:");
        wLabel.setHorizontalAlignment(JLabel.RIGHT);
        wLabel.setBounds(275, 10, 40, fieldHeight);
        inputWindow.add(wLabel, 0);

        widthField = new JTextField();
        widthField.setBounds(325, 10, fieldWidth, fieldHeight);
        widthField.setBackground(Color.white);
        widthField.setOpaque(true);
        inputWindow.add(widthField, 0);

        JLabel hLabel = new JLabel("h:");
        hLabel.setHorizontalAlignment(JLabel.RIGHT);
        hLabel.setBounds(275, 40, 40, fieldHeight);
        inputWindow.add(hLabel, 0);

        heightField = new JTextField();
        heightField.setBounds(325, 40, fieldWidth, fieldHeight);
        heightField.setBackground(Color.white);
        heightField.setOpaque(true);
        inputWindow.add(heightField, 0);

        addButton = new JButton("Add");
        addButton.setBounds(inputWindow.getWidth() / 2 - (fieldWidth + 10),
                heightField.getY() + fieldHeight + 10, fieldWidth,
                fieldHeight);
        addButton.addActionListener(this);
        inputWindow.add(addButton, 0);

        randButton = new JButton("Rand");
        randButton.setBounds(inputWindow.getWidth() / 2 + 10,
                heightField.getY() + fieldHeight + 10, fieldWidth,
                fieldHeight);
        randButton.addActionListener(this);
        inputWindow.add(randButton, 0);

        mainWindow.repaint();
        inputWindow.repaint();
    }

    /**
     * Adds a single Oval to main window, based upon location and size values
     * given by user. Color is chosen randomly.
     */
    private int getNumber(JTextField jtextfield) {
        Scanner scan = new Scanner(jtextfield.getText());

        if (scan.hasNextInt()) {
            int num = scan.nextInt();
            scan.close();
            return num;
        } else {
            scan.close();
            return 0;
        }
    }

    private void addOneOval() {
        int x = getNumber(xField);
        int y = getNumber(yField);
        int w = getNumber(widthField);
        int h = getNumber(heightField);
        addOval(x, y, w, h);

    }

    private void addOval(int a, int b, int c, int d) {
        Color c1;
        c1 = getRandomColor();
        Oval o1 = new Oval(a, b, c, d);
        o1.setBackground(c1);
        mainWindow.add(o1);
        mainWindow.repaint();
    }

    private Color getRandomColor() {
        Color c[] = {Color.getHSBColor(8, 186, 255), Color.getHSBColor(144, 59, 28), Color.getHSBColor(61, 89, 171), Color.getHSBColor(128, 42, 42)};
        Color c1 = c[(int) (Math.random() * 4)];
        return c1;
    }

    /**
     * Called whenever button is pressed; calling a method to generate shapes
     * based on user input.
     *
     * @param e The event caused by pressing some button or other.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addOneOval();
        } else {
            addRandomCircles();
        }
    }

    private void addRandomCircles() {
        int n = (int) (Math.random() * 10) + 1;

        for (int i = 0; i < n; i++) {
            int xlocation = (int) (Math.random() * 500);
            int ylocation = (int) (Math.random() * 500);
            int radius = (int) (Math.random() * 151) + 50;
            Oval o = new Oval(xlocation, ylocation, radius, radius);
            o.setBackground(getRandomColor());
            mainWindow.add(o);

        }
        mainWindow.repaint();
    }
}
