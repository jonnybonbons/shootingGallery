import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class handsup extends JApplet implements Runnable, MouseListener { 
    Thread t;   
    int timeStep = 100;
    int booty = 1;
    ArrayList<Target> targets = new ArrayList();
    Random r = new Random();
   
    public void init() {
        for (int i = 0; i < booty; i++){
            int randx = r.nextInt(359);
            int randy = r.nextInt(359);
            targets.add(new Target(randx, randy));
        }
        addMouseListener(this);
        t = new Thread(this);
        t.start();
    }

    public void paint (Graphics g) {
        for (int i = 0; i < targets.size(); i++){
            g.setColor(Color.cyan);
            g.fillOval(targets.get(i).getX(),targets.get(i).getY(), 200, 200);
        }
    }

    public void mouseClicked(MouseEvent e) {

        // loop through the ArrayList, remove any element clicked

        int x = e.getX();
        int y = e.getY();
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void run() {
        try {
            while(true) {

                // loop through the ArrayList, calling the move() method for each

                repaint();
                t.sleep(timeStep);   
            }

        } catch (InterruptedException e) {}
    }
}