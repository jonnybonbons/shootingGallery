import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class handsup extends JApplet implements Runnable, MouseListener { 
    Thread t;   
    int timeStep = 30;
    int vy = 1;
    int booty = 1;
    ArrayList<Target> targets = new ArrayList();
    Random r = new Random();

    public void init() {
        for (int i = 0; i < 1; i++){
            int randx = r.nextInt(359);
            int randy = r.nextInt(359);
            targets.add(new Vertical(randx, randy, vy));
            targets.add(new Circular(300,300,.1,30));
        }
        resize(1000,1000);
        addMouseListener(this);
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        Graphics offScreenG;
        Image offScreenI = null;

        offScreenI = createImage(getWidth(), getHeight());
        offScreenG = offScreenI.getGraphics();

        subpaint(offScreenG);

        g.drawImage(offScreenI, 0, 0, this);
    }

    public void subpaint(Graphics g){

        for (Target t: targets){
            if (t instanceof Circular){
                g.setColor(Color.red);
                g.fillOval(t.x,t.y,30,30);

            }
            g.setColor(Color.cyan);
            //g.fillOval(targets.get(i).getX(),targets.get(i).getY(), 200, 200);
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
                for (int i = 0; i < targets.size(); i++){
                    targets.get(i).move();
                }
                repaint();
                t.sleep(timeStep);   
            }

        } catch (InterruptedException e) {}
    }
}