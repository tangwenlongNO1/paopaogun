
/**
 * Creates a simple graphical oval.
 *
 * @author David Riley
 * @author M. Allen
 */
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Oval extends JComponent {

    /**
     * post: getX() == x and getY() == y and getWidth() == w and getHeight() ==
     * h and getBackground() == Color.black
     */
    public Oval(int x, int y, int w, int h) {
        super();
        setBounds(x, y, w, h);
        setBackground(Color.black);
    }

    /**
     * post: Draws a filled Oval and the upper left corner of the bounding
     * rectangle is ( getX(), getY() ) and the oval's dimensions are getWidth()
     * and getHeight() and the oval's color is getBackground()
     */
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillOval(0, 0, getWidth(), getHeight());
        paintChildren(g);
    }
}
